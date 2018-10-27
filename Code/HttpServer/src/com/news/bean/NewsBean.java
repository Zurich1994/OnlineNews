package com.news.bean;

import java.sql.Date;

public class NewsBean {
	public NewsBean(int news_id, int sort_id, String news_title,
			String news_body, String news_picture, String date, String tS) {
		super();
		this.news_id = news_id;
		this.sort_id = sort_id;
		this.news_title = news_title;
		this.news_body = news_body;
		this.news_picture = news_picture;
		this.date = date;
		TS = tS;
	}


	int news_id;
	int sort_id;
	String news_title;
	String news_body;
	String news_picture;
	String date;
	String TS;
	public String getTS() {
		return TS;
	}
	public void setTS(String tS) {
		TS = tS;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_body() {
		return news_body;
	}
	public void setNews_body(String news_body) {
		this.news_body = news_body;
	}
	public String getNews_picture() {
		return news_picture;
	}
	public void setNews_picture(String news_picture) {
		this.news_picture = news_picture;
	}
	
	
	public NewsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
