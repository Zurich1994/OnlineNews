package com.news.bean;

public class TuisongBen {
	int id;
	public TuisongBen(int id, int news_id, String username) {
		super();
		this.id = id;
		this.news_id = news_id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	int news_id;
	String username;
	
}
