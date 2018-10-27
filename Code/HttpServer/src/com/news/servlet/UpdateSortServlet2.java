package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.SortBean;
import com.news.dao.impl.SortDaoImpl;



public class UpdateSortServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/;html,charset=utf-8");
		request.setCharacterEncoding("utf-8");
		SortDaoImpl sdi = new SortDaoImpl();
		String fln = request.getParameter("flno");
		String condition = request.getParameter("condition");
		int flno = Integer.parseInt(fln);
		String flname = request.getParameter("flname");
		String content = request.getParameter("content");
		sdi.updateSort(new SortBean(flno, flname, content));
		request.setAttribute("upd", fln);		
		request.getRequestDispatcher("queryfenlei.jsp").forward(request, response);


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
