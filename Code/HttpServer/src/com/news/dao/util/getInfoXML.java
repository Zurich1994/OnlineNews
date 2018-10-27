package com.news.dao.util;


import java.io.IOException;
import java.util.ArrayList;

import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;

public class getInfoXML {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static String getInfoXML(String sortName,int i) throws IOException {

		StringBuffer infoString = new StringBuffer();
		NewsDaoImpl ndi = new NewsDaoImpl();
		SortDaoImpl sdi = new SortDaoImpl();
		ArrayList<SortBean> as = sdi.seleteSortByName(sortName);
		if(as.size()>0){
		for (SortBean sb : as) {
			PageBean pagebean = new PageBean();
			int count;
			try {
				count = ndi.getAvailableCount("", sb.getSort_id());
				pagebean.setTotalCount(count);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int tpage = pagebean.getPageCount();
			if (i <= tpage) {
				pagebean.setCurrentPage(i);
				ArrayList<NewsBean> nal;
				try {
					nal = (ArrayList<NewsBean>) ndi.getPageData(pagebean, "",
							sb.getSort_id(),"");
					//infoString
					//		.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
					infoString.append("<rss version=\"2.0\">");
					infoString.append("<channel>");
					infoString.append("<title><![CDATA[工程新闻网   - ");
					infoString.append(sortName);
					infoString.append("]]></title> ");
					infoString.append("<description><![CDATA[ http://3g.sina.com.cn ]]></description><link>http://3g.sina.com.cn</link><language>zh-cn</language><generator>3G.SINA.COM.CN</generator><ttl>5</ttl>");
					for (NewsBean nb : nal) {
						infoString.append("<item>");
						infoString.append("<title><![CDATA[");
						infoString.append(nb.getNews_title());
					infoString.append("]]></title>");
					
							infoString.append("<id>");
								infoString.append(nb.getNews_id());
							infoString.append("</id>");
							infoString.append("<source><![CDATA[");
								infoString.append("工程新闻网");
							infoString.append("]]></source>");
							infoString.append("<link>");
								infoString.append("http://172.16.0.1:8080/HttpServer/getNewsServlet?news_id=");
								infoString.append(nb.getNews_id());
							infoString.append("</link>");
							infoString.append("<guid>");
							infoString.append("http://172.16.0.1:8080/HttpServer/getNewsServlet?news_id=");
							infoString.append(nb.getNews_id());
							infoString.append("</guid>");
							infoString.append("<pubDate>");
								infoString.append(nb.getDate());
							infoString.append("</pubDate>");
							infoString.append("<comments>");
							infoString.append("</comments>");
							infoString.append("<category>");
							infoString.append("</category>");
							
							infoString.append("<enclosure url='");
							infoString.append(nb.getNews_picture());
							infoString.append("' length='10000' type='image/jpeg' alt=''/>");
						infoString.append("</item>");
						infoString.append("<id>");
						infoString.append(nb.getNews_id());
					infoString.append("</id>");
					}
					infoString.append("</channel>");
					infoString.append("</rss>");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			
		}

		}
		//System.out.println(infoString.toString());
		return infoString.toString();
	}
}
