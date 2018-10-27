package com.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.SortDao;
import com.news.dao.SpiltSortPageDao;
import com.news.dao.util.DBUtil;

public class SortDaoImpl implements SortDao,SpiltSortPageDao {
	String sql = null;
	ResultSet rs = null;
	SortBean sb = null;
	@Override
	public void addSort(SortBean sb) {
		// TODO Auto-generated method stub
		sql="insert into news_sort values(?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, sb.getSort_id());
			db.ps.setString(2, sb.getSort_name());
			db.ps.setString(3, sb.getRSS());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	@Override
	public boolean isHaveThisName(String name) {
		// TODO Auto-generated method stub
		sql="select * from news_sort where sort_name=?";
		DBUtil db =new DBUtil(sql);
		try {
			db.ps.setString(1,name);
			rs=db.ps.executeQuery();
			while(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
		}
		return false;
	
	}
	@Override
	public ArrayList<SortBean> seleteSortByName(String name) {
		sql="select * from news_sort where sort_name like ?";
		DBUtil db = new DBUtil(sql);
		ArrayList<SortBean> al = new ArrayList<SortBean>();
		try {
			db.ps.setString(1, "%"+name+"%");
			rs=db.ps.executeQuery();
			while(rs.next()){
				int s_no=rs.getInt(1);
				String s_name=rs.getString(2);
				String s_rss=rs.getString(3);
				al.add(new SortBean(s_no, s_name, s_rss));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection getPageData(PageBean pagebean,String name) {
		// TODO Auto-generated method stub
		sql="select * from news_sort where sort_name like ? order by sort_id limit "
			+(pagebean.getCurrentPage()-1)*pagebean.getPageSize()+","+pagebean.getPageSize();
		DBUtil db = new DBUtil(sql);
		ArrayList<SortBean> al = new ArrayList<SortBean>();
		try {
			db.ps.setString(1, "%"+name+"%");
			rs=db.ps.executeQuery();
			while(rs.next()){
				int s_no=rs.getInt(1);
				String s_name=rs.getString(2);
				String s_rss=rs.getString(3);
				al.add(new SortBean(s_no, s_name, s_rss));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();}
		return null;
	}
	@Override
	public int getAvailableCount(Object obj){
		// TODO Auto-generated method stub
		String name= (String) obj;
		int counter = 0;
		sql="select count(*) from news_sort where sort_name like ? ";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, "%"+name+"%");
			rs=db.ps.executeQuery();
			while(rs.next()){
				counter = rs.getInt(1);
			}
			return counter;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}db.close();
		}
		return 0;
		
		
	}
	@Override
	public void deleteSort(int s_id) {
		// TODO Auto-generated method stub
		sql="delete from news_sort where sort_id=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,s_id);
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	@Override
	public void updateSort(SortBean sort) {
		// TODO Auto-generated method stub  UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson' 
		sql="update news_sort set sort_name=?,RSS=? where sort_id=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1,sort.getSort_name());
			db.ps.setString(2,sort.getRSS());
			db.ps.setInt(3, sort.getSort_id());
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
	@Override
	public SortBean selectSortById(int id) {
		// TOD;O Auto-generated method stub
		sql="select * from news_sort where sort_id=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,id);
			rs=db.ps.executeQuery();
			while(rs.next()){
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				String s_rss = rs.getString(3);
				return new SortBean(s_id, s_name, s_rss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
		}
		
		return null;
	}
}
