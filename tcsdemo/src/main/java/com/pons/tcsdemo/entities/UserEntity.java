package com.pons.tcsdemo.entities;

public class UserEntity {
	
	private String id;
	private String name;
	private String userName;
	private String password;
	private Integer roleId;
	
	public UserEntity() {
		
	}
	
	public UserEntity(String id, String name, String userName, String password, Integer roleId) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
