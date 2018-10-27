package com.news.dao.util;


import java.io.IOException;
import java.util.ArrayList;

import com.news.bean.CommentBean;
import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.CommentDaoImpl;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;

public class getCommentXML {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String getCommXML(int new_id,int i) throws IOException {

		StringBuffer commentString = new StringBuffer();
		CommentDaoImpl cdi = new CommentDaoImpl();
		PageBean pagebean = new PageBean();
		int count;
		try {
			count = cdi.getAvailableCount(i);
			pagebean.setTotalCount(count);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int tpage = pagebean.getPageCount();
		if (i <= tpage) {
			pagebean.setCurrentPage(i);
			try {
				ArrayList<CommentBean> al = (ArrayList<CommentBean>) cdi.getPageData(pagebean, new_id);	
//				commentString
//							.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
//				commentString.append("<comments>");
//					for (CommentBean cb : al) {
//						commentString.append("<comment id=\""+cb.getId()+"\">");
//						commentString.append("<comment_body>");
//						commentString.append(cb.getComment());
//						commentString.append("</comment_body>");
//						commentString.append("<username>");
//						commentString.append(cb.getUsername());
//						commentString.append("</username>");
//						commentString.append("<zan>");
//						commentString.append(cb.getZan());
//						commentString.append("</zan>");
//						commentString.append("</comment>");
//					}
//					commentString.append("</comments>");
				
				if (al.size() > 0) {
					if(al.size()>1)
						commentString.append("[");
					for (CommentBean cb : al) {
						commentString.append("{");
						commentString.append("\"id\":");
						commentString.append(cb.getId());
						commentString.append(",");
						commentString.append("\"comment_body\":\"");
						commentString.append(cb.getComment());
						commentString.append("\",");
						commentString.append("\"username\":\"");
						commentString.append(cb.getUsername());
						commentString.append("\"}");
						commentString.append(",");
					}
					commentString.deleteCharAt(commentString.length()-1);
				if(al.size()>1)
					commentString.append("]");
				}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			

			
		}

		
		//System.out.println(infoString.toString());
		return commentString.toString();}
}
