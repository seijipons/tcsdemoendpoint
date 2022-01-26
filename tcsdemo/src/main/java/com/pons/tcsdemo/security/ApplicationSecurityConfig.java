package com.pons.tcsdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.pons.tcsdemo.security.ApplicationUserRole.*;
import static com.pons.tcsdemo.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests() //authorize requests
		.antMatchers("/", "index", "/css/*", "/js/*").permitAll() //whitelist some urls
        .antMatchers("/h2-console/**").permitAll() //whitelist h2 database console
        .antMatchers(HttpMethod.GET,"/message/**").hasAnyRole(USER.name(), ADMIN.name()) //user and admin
		.antMatchers(HttpMethod.POST,"/message/**").hasAuthority(MESSAGE_WRITE.getPermission()) //only who has this authority can make a POST req
		.antMatchers("/message").hasAnyRole(USER.name(), ADMIN.name()) //
		.anyRequest()	//every request... 
		.authenticated() //must be authenticated
		.and()
		.httpBasic();
		
		//http.headers().frameOptions().disable(); //Disable X-Frame-Options in Spring Security 
	}
	 
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails adminTest = User.builder()
				.username("adminname")
				.password(passwordEncoder.encode("password"))
				//.roles(ADMIN.name())
				.authorities(USER.getGrantedAuthorities())
				.build();
		
		UserDetails userTest = User.builder()
				.username("username")
				.password(passwordEncoder.encode("password"))
				//.roles(ADMIN.name())
				.authorities(ADMIN.getGrantedAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(
				adminTest, 
				userTest);
		
	}
}
