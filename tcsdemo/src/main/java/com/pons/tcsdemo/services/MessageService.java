package com.pons.tcsdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pons.tcsdemo.dao.MessageDao;
import com.pons.tcsdemo.entities.Message;


@Service
public class MessageService {

	@Autowired
	MessageDao messageDao;
	
	public List<Message> getMessagesTo(String u) {
		return messageDao.getMessagesTo(u);		
	}
	
	public int addMessage(Message m) {
		return messageDao.addMessage(m);		
	}

}
