package com.news.bean;

import java.sql.Date;

public class RequestBean {
	int id;
	public RequestBean(int id, String time, String type) {
		super();
		this.id = id;
		this.time = time;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String time;
	public RequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String type;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
