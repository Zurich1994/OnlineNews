package com.news.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.NewsBean;
import com.news.dao.impl.NewsDaoImpl;



public class AddNewsServlet extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		NewsDaoImpl ndi=new NewsDaoImpl();
		String news_titl=request.getParameter("news_title");
		String news_title = new String(news_titl.getBytes("iso-8859-1"), "UTF-8");
		String selfenle=request.getParameter("selfenlei");
		String selfenlei = new String(selfenle.getBytes("iso-8859-1"), "UTF-8");
		int f_id = Integer.parseInt(selfenlei);
		String picture=request.getParameter("picture");
		String new_bod=request.getParameter("new_body");
		String new_body = new String(new_bod.getBytes("iso-8859-1"), "UTF-8");
		java.util.Date date = new java.util.Date();
		NewsBean nb = new NewsBean(0, f_id, news_title, new_body, picture, date.toGMTString(),"NO");
		ndi.addNews(nb);
		System.out.println(1);
		request.getRequestDispatcher("addnews.jsp").forward(request, response);
		
	    
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
