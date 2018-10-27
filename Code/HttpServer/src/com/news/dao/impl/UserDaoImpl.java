package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.bean.UserBean;
import com.news.dao.UserDao;
import com.news.dao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	String sql = null;
	ResultSet rs = null;
	UserBean ub=new UserBean();
	@Override
	public void addUser(String username,String password){
		sql="insert into user values(?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, username);
			db.ps.setString(2, password);
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	public UserBean selectUserByUname(String username) {
		sql = "select * from user where username=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, username);
			rs = db.ps.executeQuery();
			while (rs.next()) {
				String username1 = rs.getString(1);
				String password = rs.getString(2);
				ub.setPassword(password);	
				ub.setUsername(username);
			}
			rs.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ub;

	}
	@Override
	public Boolean isHaveThisUser(String username) {
		// TODO Auto-generated method stub
		sql="select * from user where username=?";
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
	public void upadteUser(UserBean ub) {
		// TODO Auto-generated method stub
		sql="update  users set password=? where username=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1,ub.getPassword());
			db.ps.setString(2, ub.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}

}
