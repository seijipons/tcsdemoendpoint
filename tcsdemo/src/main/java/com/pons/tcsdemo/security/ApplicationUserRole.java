package com.pons.tcsdemo.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

import static com.pons.tcsdemo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
	USER(Sets.newHashSet(MESSAGE_READ)),
	ADMIN(Sets.newHashSet(MESSAGE_READ,MESSAGE_WRITE,USER_READ,USER_WRITE));
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
	//this method returns a list of permissions that has every role
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		
		//Strea and Lambda implementations to get the list of permissions allowed for every rol
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
			.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
			.collect(Collectors.toSet());
		
		permissions.add(new SimpleGrantedAuthority("ROLE_ " + this.name()));
		
		return permissions;
	}
}
