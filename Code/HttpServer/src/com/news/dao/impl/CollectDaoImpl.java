package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.bean.CollectBean;
import com.news.dao.CollectDao;
import com.news.dao.util.DBUtil;

public class CollectDaoImpl implements CollectDao {
	String sql = null;
	ResultSet rs = null;
	CollectBean cb = null;
	@Override
	public void addCollect(CollectBean cb) {
		// TODO Auto-generated method stub
		sql = "insert into collect values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, cb.getId());
			db.ps.setString(2,cb.getUsername());
			db.ps.setInt(3, cb.getNews_id());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}}
	

	@Override
	public ArrayList<Integer> queryCollect(String username) {
		// TODO Auto-generated method stub
		sql = "select news_id from collect where username = ?";
		DBUtil db = new DBUtil(sql);
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			db.ps.setString(1, username);
			rs = db.ps.executeQuery();
			while(rs.next()){
				int news_id = rs.getInt(1);
				al.add(news_id);
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
				
  		return null;
	}

	@Override
	public void delCollect(String username, int id) {
		// TODO Auto-generated method stub
		sql = "delete from collect where username=? and news_id = ?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, username);
			db.ps.setInt(2, id);
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
		
	}
	
}
