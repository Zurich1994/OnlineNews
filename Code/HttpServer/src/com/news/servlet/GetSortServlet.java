package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.SortBean;
import com.news.dao.impl.SortDaoImpl;


public class GetSortServlet extends HttpServlet {

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
		al = sdi.seleteSortByName("");
		String fir = "first";
		String what = request.getParameter("what");
		//if()
		String url;
		if(what.equals("querynews")){
			url="querynews.jsp";
		}
		else{
			url= "addnews.jsp";
		}
		if(al.isEmpty()){
			request.setAttribute("message","抱歉，还未添加任何分类，无法选择");
			request.setAttribute("fir",fir);
			request.getRequestDispatcher(url).forward(request, response);
			}
		else{
			request.setAttribute("message",null);
			request.setAttribute("sortal", al);
			request.setAttribute("fir",fir);
			request.getRequestDispatcher(url).forward(request, response);
		}
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
