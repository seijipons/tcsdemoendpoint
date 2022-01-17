package com.pons.tcsdemo.entities;


public class Message {
	
	private String id;
	private String message;
	private String messageTo;
	private String messageFrom;
	
	public Message() {
		
	}
	
	public Message(String id, String message, String messageTo, String messageFrom) {
		super();
		this.id = id;
		this.message = message;
		this.messageTo = messageTo;
		this.messageFrom = messageFrom;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageTo() {
		return messageTo;
	}

	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}
	
	public String getMessageFrom() {
		return messageFrom;
	}

	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}
	

}
