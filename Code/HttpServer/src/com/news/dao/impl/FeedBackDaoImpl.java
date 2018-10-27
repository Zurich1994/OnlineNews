package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.bean.FeedBackBean;
import com.news.dao.FeedBackDao;
import com.news.dao.util.DBUtil;

public class FeedBackDaoImpl implements FeedBackDao {
	String sql = null;
	ResultSet rs = null;
	FeedBackBean fb = new FeedBackBean();
	@Override
	public void addFeedBack(FeedBackBean fb) {
		// TODO Auto-generated method stub
		sql="insert into feedback values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, fb.getId());
			db.ps.setString(2, fb.getFeedback());
			db.ps.setString(3, fb.getTel());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}

}
