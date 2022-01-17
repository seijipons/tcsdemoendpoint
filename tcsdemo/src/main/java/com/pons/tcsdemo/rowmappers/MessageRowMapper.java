package com.pons.tcsdemo.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pons.tcsdemo.entities.Message;


public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setId(rs.getString("Id"));
		message.setMessage(rs.getString("Message"));
		
		message.setMessageTo(rs.getString("MessageTo"));
		message.setMessageFrom(rs.getString("MessageFrom"));
		return message;
	}

}
