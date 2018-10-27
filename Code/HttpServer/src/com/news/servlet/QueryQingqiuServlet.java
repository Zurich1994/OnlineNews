package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.RequestBean;
import com.news.dao.impl.RequestDaoImpl;



public class QueryQingqiuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		RequestDaoImpl rdi = new RequestDaoImpl();
		ArrayList<RequestBean> al = new ArrayList<RequestBean>();
		al = (ArrayList<RequestBean>) rdi.seleteAll();
		request.setAttribute("sortal", al);
		request.getRequestDispatcher("queryqingqiu.jsp").forward(request,
					response);
		}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
