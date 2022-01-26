package com.pons.tcsdemo.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pons.tcsdemo.entities.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity>{

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserEntity u = new UserEntity();

		u.setId(rs.getString("Id"));
		u.setName(rs.getString("Name"));
		
		return u;
	}

}
