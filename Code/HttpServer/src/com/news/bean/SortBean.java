package com.news.bean;

public class SortBean {
	int sort_id;
	String sort_name;
	String RSS;
	
	public String getRSS() {
		return RSS;
	}
	public void setRSS(String rSS) {
		RSS = rSS;
	}
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	public SortBean(int sort_id, String sort_name, String rSS) {
		super();
		this.sort_id = sort_id;
		this.sort_name = sort_name;
		RSS = rSS;
	}
	public SortBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
