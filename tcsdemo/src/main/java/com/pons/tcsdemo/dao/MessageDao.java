package com.pons.tcsdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import com.pons.tcsdemo.entities.Message;
import com.pons.tcsdemo.rowmappers.MessageRowMapper;




@Component
public class MessageDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Message> getMessagesTo(String u) {
		
		String query = "SELECT * FROM Message m WHERE m.MessageTo = ?";
		return jdbcTemplate.query(query, new MessageRowMapper(), u);
	}
	
	
	public int addMessage(Message message) {
		
		return jdbcTemplate.update("INSERT INTO Message (Message, MessageFrom, MessageTo) VALUES ( ?, ?, ?)", message.getMessage(), message.getMessageFrom(), message.getMessageTo());
	}

}
