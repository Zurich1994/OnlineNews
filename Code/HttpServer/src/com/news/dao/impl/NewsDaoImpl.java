package com.news.dao.impl;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.dao.NewsDao;
import com.news.dao.SpiltNewsPageDao;
import com.news.dao.util.CaptureHtmlUtil;
import com.news.dao.util.DBUtil;

public class NewsDaoImpl implements NewsDao,SpiltNewsPageDao {
	String sql = null;
	ResultSet rs = null;
	NewsBean nb = null;
	
	public boolean isHaveThisTitle(String title) {
		// TODO Auto-generated method stub
		sql="select * from news where news_title=?";
		DBUtil db =new DBUtil(sql);
		try {
			db.ps.setString(1,title);
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
	public void addNewsByURL(String url,int sort_id) {
		// TODO Auto-generated method stub
		NewsBean nb = new NewsBean();
		java.util.Date date = new java.util.Date();
		String title;
		try {
			title = CaptureHtmlUtil.captureHtml(url,"<title>","</title>","_新闻_腾讯网","");
			title = title.replaceAll("<[^>]+>", "");
			nb.setNews_title(title);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		
		if(!isHaveThisTitle(nb.getNews_title())){
		try {
			String s  = CaptureHtmlUtil.captureHtml(url,"<P style=\"TEXT-INDENT: 2em\">","</P></div>","</P>","\n");
			if(!s.equals("")||!s.isEmpty()){ s = CaptureHtmlUtil.captureHtml(url,"<div id=\"Cnt-Main-Article-QQ\" bossZone=\"content\">","</P></div>","</P>","\n");}
			String body =  delHTMLTag(s);
			nb.setNews_body(body);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!nb.getNews_body().equals("")&!nb.getNews_body().isEmpty()){
				try {String picture = CaptureHtmlUtil.captureHtml(url,"<P align=center>","</P></div>","","");; 
			//String picture = CaptureHtmlUtil.captureHtml(url,"<P align=center>","</P></div>","","");
			if(!picture.isEmpty()){
				picture = picture.substring(picture.indexOf("src=\"")+5, picture.length()-1);
				picture = picture.substring(0, picture.indexOf("\""));	
			}
			nb.setNews_picture(picture);
			Date gmtdate = new Date(date.getYear(), date.getMonth(), date.getDate());
			
			nb.setDate(gmtdate.toGMTString());
			nb.setSort_id(sort_id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		sql="insert into news values(?,?,?,?,?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, nb.getNews_id());
			db.ps.setInt(2, nb.getSort_id());
			db.ps.setString(3, nb.getNews_title());
			db.ps.setString(4, nb.getNews_body());
			db.ps.setString(5, nb.getNews_picture());
			db.ps.setString(6, nb.getDate());
			db.ps.setString(7,"NO");
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}}}
	}
	
	public void addNews(NewsBean nb) {
		// TODO Auto-generated method stub
		sql="insert into news values(?,?,?,?,?,?,?)";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1, nb.getNews_id());
			db.ps.setInt(2, nb.getSort_id());
			db.ps.setString(3, nb.getNews_title());
			db.ps.setString(4, nb.getNews_body());
			db.ps.setString(5, nb.getNews_picture());
			db.ps.setString(6, nb.getDate());
			db.ps.setString(7,"NO");
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	//;
	@Override
	public void deleteNews() {
		// TODO Auto-generated method stub
		sql="delete from news where TO_DAYS(NOW()) - TO_DAYS(Date) >= 30";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}

	@Override
	public Collection getPageData(PageBean pagebean, String news_title, int s_id,String TSstate)
			throws Exception {
		if(s_id==-1){sql="select * from news where news_title like  ? and TS like ? order by news_id desc limit "
				+(pagebean.getCurrentPage()-1)*pagebean.getPageSize()+","+pagebean.getPageSize();}
			else{
				sql="select * from news where news_title like ?  and TS like ? and sort_id like ?  order by news_id desc limit "
				+(pagebean.getCurrentPage()-1)*pagebean.getPageSize()+","+pagebean.getPageSize();
			}
//			sql="select * from sort where s_name like ? order by s_id limit "
//				+(pagebean.getCurrentPage()-1)*pagebean.getPageSize()+","+pagebean.getPageSize();
			DBUtil db = new DBUtil(sql);
			ArrayList<NewsBean> al = new ArrayList<NewsBean>();
			try {
				db.ps.setString(1, "%"+news_title+"%");
				db.ps.setString(2, "%"+TSstate+"%");
				if(s_id!=-1)
				   {db.ps.setInt(3,s_id);}
				rs=db.ps.executeQuery();
				while(rs.next()){
					int news_id=rs.getInt(1);
					int sort_i=rs.getInt(2);
					String title=rs.getString(3);
					String news_body=rs.getString(4);
					String news_picture=rs.getString(5);
					String date =rs.getString(6);
					String TS = rs.getString(7);
					al.add(new NewsBean(news_id, sort_i, title, news_body, news_picture, date,TS));
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
			}db.close();}
			return null;
	}

	@Override
	public int getAvailableCount(String news_title, int s_id) throws Exception {
		int counter = 0;
		if(s_id==-1){sql="select count(*) from news where news_title like  ?   ";}
		else{
			sql="select count(*) from news where news_title like ? and sort_id like ? ";
		}
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1, "%"+news_title+"%");
			if(s_id!=-1)
			   {db.ps.setInt(2,s_id);}
			rs=db.ps.executeQuery();
			while(rs.next()){
				counter = rs.getInt(1);
			}
			return counter;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	
	}

	@Override
	public NewsBean selectNewsById(int id) {
		sql="select * from news where news_id=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,id);
			rs=db.ps.executeQuery();
			while(rs.next()){
				int news_id = rs.getInt(1);
				int sort_id = rs.getInt(2);
				String news_title = rs.getString(3);
				String news_body = rs.getString(4);
				String news_picture = rs.getString(5);
				String date = rs.getString(6);
				String TS = rs.getString(7);
				return new NewsBean(news_id, sort_id, news_title, news_body, news_picture, date,TS);
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

	public void deleteNews(int g_id) {
		// TODO Auto-generated method stub
		sql="delete from news where news_id=?";
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setInt(1,g_id);
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.close();}
	}
	public String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}

	@Override
	public void setTS(int news_id) {
		// TODO Auto-generated method stub
		sql="update news set TS=?  where news_id="+news_id;
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1,"YES");
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.close();
		}
	}

	@Override
	public void quxiaoTS(int news_id) {
		// TODO Auto-generated method stub
		sql="update news set TS=?  where news_id="+news_id;
		DBUtil db = new DBUtil(sql);
		try {
			db.ps.setString(1,"NO");
			db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
	
}
