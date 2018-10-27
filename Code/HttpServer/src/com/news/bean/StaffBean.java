package com.news.bean;

public class StaffBean {
	String username;
	public StaffBean(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	String password;
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public StaffBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
