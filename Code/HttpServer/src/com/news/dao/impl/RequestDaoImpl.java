package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.news.bean.RequestBean;
import com.news.dao.util.DBUtil;

public class RequestDaoImpl {
	String sql = null;
	ResultSet rs = null;
	RequestBean rb = null;
	
	public void addRequest(RequestBean rb) {
		// TODO Auto-generated method stub
		sql="insert into request values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, rb.getId());
			db.ps.setString(2, rb.getTime());
			db.ps.setString(3, rb.getType());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	
	public ArrayList<RequestBean> seleteAll() {
		int counter = 0;
		sql="select count(*) from request";
		DBUtil db = new DBUtil(sql);
		try {
			rs=db.ps.executeQuery();
			while(rs.next()){
				counter = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(counter>10)
			counter = 10;
		sql="select * from request order by id desc limit 0,"+counter;
		db = new DBUtil(sql);
		ArrayList<RequestBean> al = new ArrayList<RequestBean>();
		try {
			rs=db.ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String time =rs.getString(2);
				String type=rs.getString(3);
				al.add(new RequestBean(0,time, type));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{try {
			rs.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
		// TODO Auto-generated method stub
		
	}
}
