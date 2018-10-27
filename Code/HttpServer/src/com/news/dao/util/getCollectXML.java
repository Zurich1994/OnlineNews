package com.news.dao.util;

import java.io.IOException;
import java.util.ArrayList;

import com.news.bean.NewsBean;
import com.news.dao.impl.NewsDaoImpl;

public class getCollectXML {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static String getCollectXML(ArrayList<Integer> al)
			 {
		StringBuffer CollectString = new StringBuffer();
		NewsDaoImpl ndi = new NewsDaoImpl();
		if (al.size() > 0) {
			if(al.size()>1)
				CollectString.append("[");
			for (int a : al) {
				NewsBean nb = ndi.selectNewsById(a);
				CollectString.append("{");
				CollectString.append("\"id\":");
				CollectString.append(nb.getNews_id());
				CollectString.append(",");
				CollectString.append("\"title\":\"");
				CollectString.append(nb.getNews_title());
				CollectString.append("\",");
				CollectString.append("\"date\":\"");
				CollectString.append(nb.getDate().substring(0, 11));
				CollectString.append("\"}");
				CollectString.append(",");
			}
			CollectString.deleteCharAt(CollectString.length()-1);
		if(al.size()>1)
			CollectString.append("]");
		}
 
		// System.out.println(infoString.toString());
		return CollectString.toString();

	}
}
