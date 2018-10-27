package com.news.dao;

import java.util.ArrayList;

import com.news.bean.CollectBean;


public interface CollectDao  {
	void addCollect(CollectBean cb);
	ArrayList<Integer> queryCollect(String username);
	void delCollect(String username,int id);
	
}
