package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;
import com.news.dao.util.GetUrlUtil;

public class RssServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		SortDaoImpl sdi = new SortDaoImpl();
		ArrayList<SortBean> al = new ArrayList<SortBean>();
		al= sdi.seleteSortByName("");
		Iterator it = al.iterator();
		NewsDaoImpl ndi = new NewsDaoImpl();
		while(it.hasNext()){
			SortBean sb = (SortBean)it.next();
			System.out.println(sb.getRSS());
			if(sb.getRSS().equals("")||sb.getRSS()==null)
				System.out.println("urlÎª¿Õ");
			else{
				GetUrlUtil a = new GetUrlUtil(sb.getRSS());
				ArrayList<String> hrefList = a.getHrefList();
				for (int i = 0; i < hrefList.size(); i++){
					ndi.addNewsByURL(hrefList.get(i),sb.getSort_id());
					System.out.println("µÚ"+i+"¸ö-----------------------------------------");
					}
			}
			
			
		}
		//!str.isEmpty()||str!=""
		
		request.getRequestDispatcher("RssSuc.jsp").forward(request,
				response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
