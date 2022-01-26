package com.pons.tcsdemo.security;

public enum ApplicationUserPermission {
	USER_READ("user:read"),
	USER_WRITE("user:write"),
	MESSAGE_READ("message:read"),
	MESSAGE_WRITE("message:write");
	
	final private String permission;

	ApplicationUserPermission(String permission) {
		this.permission=permission;
	}

	public String getPermission() {
		return permission;
	}
	
	

}
