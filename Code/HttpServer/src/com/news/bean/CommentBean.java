package com.news.bean;

public class CommentBean {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	int id;
	public CommentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentBean(int id, String comment, String username, int news_id,
			int zan) {
		super();
		this.id = id;
		this.comment = comment;
		this.username = username;
		this.news_id = news_id;
		this.zan = zan;
	}
	String comment;
	String username;
	int news_id;
	int zan;
	
	
}
