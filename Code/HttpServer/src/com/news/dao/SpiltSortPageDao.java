package com.news.dao;

import java.util.Collection;

import com.news.bean.PageBean;


public interface SpiltSortPageDao {
	public Collection getPageData(PageBean pagebean,String name) throws Exception;
	public int getAvailableCount(Object obj) throws Exception;
}