package com.news.dao;

import java.util.Collection;

import com.news.bean.PageBean;


public interface SpiltCommentPageDao {
	public Collection getPageData(PageBean pagebean,int news_id) throws Exception;
	public int getAvailableCount(int news_id) throws Exception;
}