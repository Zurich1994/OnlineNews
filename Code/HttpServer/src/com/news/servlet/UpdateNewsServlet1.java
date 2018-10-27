package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.NewsBean;
import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;



public class UpdateNewsServlet1 extends HttpServlet {

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
		NewsDaoImpl gdi= new NewsDaoImpl();
		String upd = request.getParameter("upd");
		int g_id=Integer.parseInt(upd);
		String wha = request.getParameter("what");
		int what=Integer.parseInt(wha);	
		NewsBean gb = gdi.selectNewsById(g_id);
		SortDaoImpl sdi = new SortDaoImpl();
		ArrayList<SortBean> sortal = new ArrayList<SortBean>();
		sortal = sdi.seleteSortByName("");
		request.setAttribute("gb", gb);

		request.setAttribute("sortal", sortal);
		if(what==1){
		request.getRequestDispatcher("xggoods.jsp").forward(request, response);}
		if(what==0){
			String nam = request.getParameter("name");
			String name = new String(nam.getBytes("iso-8859-1"), "UTF-8");
			request.setAttribute("name", name);
			request.getRequestDispatcher("cknews.jsp").forward(request, response);}
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
