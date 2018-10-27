package com.news.dao;

import java.util.Collection;

import com.news.bean.PageBean;



public interface SpiltNewsPageDao {
	public Collection getPageData(PageBean pagebean,String news_title, int s_id,String TSstate) throws Exception;
	public int getAvailableCount(String news_title, int s_id) throws Exception;

}
