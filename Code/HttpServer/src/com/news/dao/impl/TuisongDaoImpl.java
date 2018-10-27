package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.bean.TuisongBen;
import com.news.dao.TuisongDao;
import com.news.dao.util.DBUtil;

public class TuisongDaoImpl implements TuisongDao {
	String sql = null;
	ResultSet rs = null;
	TuisongBen tb = null;

	@Override
	public void addTuisong(int news_id) {
		// TODO Auto-generated method stub
		sql = "insert into tuisong values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, 0);
			db.ps.setInt(2, news_id);
			db.ps.setString(3, "");
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	@Override
	public void deleteTuisong(int news_id) {
		// TODO Auto-generated method stub
		sql = "delete from tuisong where news_id=? ";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, news_id);
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	@Override
	public void addTU(TuisongBen tb) {
		// TODO Auto-generated method stub
		sql = "insert into tuisong values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,0);
			db.ps.setInt(2,tb.getNews_id());
			db.ps.setString(3, tb.getUsername());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
	}

	@Override
	public ArrayList<Integer> queryTSnews() {
		// TODO Auto-generated method stub
		sql = "select news_id from tuisong where username = \"\"";
		DBUtil db = new DBUtil(sql);
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
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
	public ArrayList<TuisongBen> queryTSByUser(String username) {
		// TODO Auto-generated method stub
		sql = "select * from tuisong where username = ?";
		DBUtil db = new DBUtil(sql);
		ArrayList<TuisongBen> al = new ArrayList<TuisongBen>();
		try {
			db.ps.setString(1, username);
			rs = db.ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				int news_id = rs.getInt(2);
				al.add(new TuisongBen(id, news_id, username));
			}
			return al;
		}  catch (SQLException e) {
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

	
}
