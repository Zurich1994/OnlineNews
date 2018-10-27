package com.news.bean;

public class CollectBean {
	int id;
	public CollectBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollectBean(int id, String username, int news_id) {
		super();
		this.id = id;
		this.username = username;
		this.news_id = news_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	String username;
	int news_id;
}
