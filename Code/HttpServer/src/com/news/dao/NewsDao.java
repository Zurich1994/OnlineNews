package com.news.dao;


import com.news.bean.NewsBean;



public interface NewsDao {
	void addNewsByURL(String url,int sort_id);
	void deleteNews();
	public void addNews(NewsBean nb);
	public boolean isHaveThisTitle(String title);
	public NewsBean selectNewsById(int id);
	public void deleteNews(int g_id);
	void setTS(int news_id);
	void quxiaoTS(int news_id);
}
