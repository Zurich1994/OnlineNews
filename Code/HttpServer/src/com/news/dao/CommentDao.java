package com.news.dao;

import java.util.ArrayList;

import com.news.bean.CommentBean;


public interface CommentDao {
	public void addComment(CommentBean cb);
	public ArrayList<CommentBean> selectCommentById(int id);
}
