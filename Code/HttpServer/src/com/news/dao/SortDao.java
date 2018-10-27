package com.news.dao;

import java.util.ArrayList;

import com.news.bean.SortBean;

public interface SortDao {
	void addSort(SortBean sb);
	boolean isHaveThisName(String name);
	ArrayList<SortBean> seleteSortByName(String name);
	void deleteSort(int s_id);
	void updateSort(SortBean sort);
	SortBean selectSortById(int id);
}
