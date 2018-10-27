package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.bean.StaffBean;
import com.news.dao.StaffDao;
import com.news.dao.util.DBUtil;

public class StaffDaoImpl implements StaffDao {

	String sql = null;
	ResultSet rs = null;
	StaffBean sb=new StaffBean();
	@Override
	
	public StaffBean selectUserByUname(String username) {
		sql = "select * from staff where username=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, username);
			rs = db.ps.executeQuery();
			while (rs.next()) {
				String username1 = rs.getString(1);
				String password = rs.getString(2);
				String type = rs.getString(3);
				sb.setPassword(password);	
				sb.setUsername(username);
				sb.setType(type);
			}
			rs.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return sb;

	}
	@Override
	public Boolean isHaveThisUser(String username) {
		// TODO Auto-generated method stub
		sql="select * from staff where username=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, username);
			rs =db.ps.executeQuery();
			while(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
		return false;
	}

	@Override
	public void addStaff(StaffBean sb) {
		// TODO Auto-generated method stub
		sql="insert into staff values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, sb.getUsername());
			db.ps.setString(2, sb.getPassword());
			db.ps.setString(2, sb.getType());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}

}
