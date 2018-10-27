package com.news.dao.util;


import java.io.IOException;
import java.util.ArrayList;

import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;

public class getNewsXML {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String getNewsXML(int i) throws IOException {

		StringBuffer infoString = new StringBuffer();
		NewsDaoImpl ndi = new NewsDaoImpl();
		NewsBean nb = new NewsBean();
		nb = ndi.selectNewsById(i);
		if (nb!=null) {
				infoString.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
					infoString.append("<news>");
						infoString.append("<title>");
							infoString.append(nb.getNews_title());
						infoString.append("</title>");
						infoString.append("<picture>");
							infoString.append(nb.getNews_picture());
						infoString.append("</picture>");
						infoString.append("<body>");
							infoString.append(nb.getNews_body());
						infoString.append("</body>");
						
					infoString.append("</news>");
						
				} 
				
		System.out.println(infoString.toString());
		return infoString.toString();
	}
}
