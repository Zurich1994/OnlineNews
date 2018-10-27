package com.news.data;

public class IndexNews {
	private int id;
	private String title;
	private String body;
	
	public IndexNews() {

	}

	public IndexNews(int id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
