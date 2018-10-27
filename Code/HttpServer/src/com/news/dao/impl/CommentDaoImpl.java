package com.news.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.news.bean.CommentBean;
import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.CommentDao;
import com.news.dao.SpiltCommentPageDao;
import com.news.dao.SpiltSortPageDao;
import com.news.dao.util.DBUtil;

public class CommentDaoImpl implements CommentDao,SpiltCommentPageDao {

	String sql = null;
	ResultSet rs = null;
	CommentBean cb = new CommentBean();
	@Override
	public void addComment(CommentBean cb) {
		// TODO Auto-generated method stub
			sql="insert into comment values(?,?,?,?,?)";
			DBUtil db = new DBUtil(sql);
			try {
				db.ps.setInt(1, cb.getId());
				db.ps.setString(2, cb.getComment());
				db.ps.setString(3, cb.getUsername());
				db.ps.setInt(4, cb.getNews_id());
				db.ps.setInt(5, cb.getZan());
				db.ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{db.close();}
		
	}
	@Override
	public Collection getPageData(PageBean pagebean, int news_id)
			throws Exception {
		// TODO Auto-generated method stub
		sql="select * from comment where news_id = ? order by id limit "
				+(pagebean.getCurrentPage()-1)*pagebean.getPageSize()+","+pagebean.getPageSize();
			DBUtil db = new DBUtil(sql);
			ArrayList<CommentBean> al = new ArrayList<CommentBean>();
			try {
				db.ps.setInt(1,news_id);
				rs=db.ps.executeQuery();
				while(rs.next()){
					int id=rs.getInt(1);
					String comment=rs.getString(2);
					String username=rs.getString(3);
					int zan = rs.getInt(5);
					al.add(new CommentBean(id, comment, username, news_id, zan));
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
	public int getAvailableCount(int news_id) throws Exception {
		// TODO Auto-generated method stub
		int counter = 0;
		sql="select count(*) from comment where news_id = ? ";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, news_id);
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
	public ArrayList<CommentBean> selectCommentById(int id) {
		// TODO Auto-generated method stub
		sql="select * from comment where new_id=?";
		ArrayList<CommentBean> al = new ArrayList<CommentBean>();
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,id);
			rs=db.ps.executeQuery();
			while(rs.next()){
				int idd = rs.getInt(1);
				String comment = rs.getString(2);
				String username = rs.getString(3);
				int news_id = rs.getInt(4);
				int zan = rs.getInt(5);
				 al.add(new CommentBean(idd, comment, username, news_id, zan));
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
