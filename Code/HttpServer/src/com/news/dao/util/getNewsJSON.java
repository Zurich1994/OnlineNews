package com.news.dao.util;


import java.io.IOException;
import java.util.ArrayList;

import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;

public class getNewsJSON {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String getNewsJSON(int i) throws IOException {

		StringBuffer infoString = new StringBuffer();
		NewsDaoImpl ndi = new NewsDaoImpl();
		NewsBean nb = new NewsBean();
		nb = ndi.selectNewsById(i);
		if (nb!=null) {
				infoString.append("{");
					infoString.append("\"title\":\"");
							infoString.append(nb.getNews_title());
						infoString.append("\",");
						infoString.append("\"body\":\"");
							infoString.append(nb.getNews_body());
						infoString.append("\",");
						infoString.append("\"id\":");
						infoString.append(nb.getNews_id());
					infoString.append("}");
		}
				
		System.out.println(infoString.toString());
		return infoString.toString();
	}
}
