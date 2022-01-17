package com.pons.tcsdemo.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pons.tcsdemo.entities.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User u = new User();

		u.setId(rs.getString("Id"));
		u.setName(rs.getString("Name"));
		
		return u;
	}

}
