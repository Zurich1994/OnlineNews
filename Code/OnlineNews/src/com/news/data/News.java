package com.news.data;

public class News {
	private int id;
	private String title;
	private String date;
	public News() {

	}

	public News(int id, String title, String date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return getId() + this.getTitle();
	}
}
