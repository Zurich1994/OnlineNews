package com.news.dao;

import java.util.ArrayList;

import com.news.bean.TuisongBen;

public interface TuisongDao {
	void addTuisong(int news_id);
	void deleteTuisong(int news_id);
	void addTU(TuisongBen tb);
	ArrayList<Integer> queryTSnews();
	ArrayList<TuisongBen> queryTSByUser(String username);
}
