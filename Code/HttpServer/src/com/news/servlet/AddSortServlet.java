package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.SortBean;
import com.news.dao.impl.SortDaoImpl;

public class AddSortServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SortDaoImpl sdi = new SortDaoImpl();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String flrss=request.getParameter("flrss");
		String flnam=request.getParameter("flname");
		String flname = new String(flnam.getBytes("iso-8859-1"), "UTF-8");
		if(sdi.isHaveThisName(flname)){
			request.setAttribute("message","该分类名称已存在，请重新输入");
			request.getRequestDispatcher("addfenlei.jsp").forward(request, response);
		}
		else{
			sdi.addSort(new SortBean(0, flname, flrss));
			request.setAttribute("message","添加成功");
			request.getRequestDispatcher("/addfenlei.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
