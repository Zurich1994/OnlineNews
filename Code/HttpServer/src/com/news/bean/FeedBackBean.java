package com.news.bean;

public class FeedBackBean {
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//String username;
	public FeedBackBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	String feedback;
	String tel;
	public FeedBackBean(int id, String feedback, String tel) {
		super();
		this.id = id;
		//this.username = username;
		this.feedback = feedback;
		this.tel = tel;
	}
	
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
}
