package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.SortDaoImpl;



public class QuerySortServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		SortDaoImpl sdi = new SortDaoImpl();
		String cond = request.getParameter("condition");
		//String cond = new String(con.getBytes("iso-8859-1"), "UTF-8");
		ArrayList<SortBean> al = new ArrayList<SortBean>();
		String temppage = request.getParameter("spage");
System.out.println(cond+"-----q---------");
		int pno = 1;
		if (temppage != null && !("").equals(temppage)) {
			try {
				pno = Integer.parseInt(temppage);
			} catch (Exception e) {
				// TODO: handle exception
				pno = 1;
			}
		}
		PageBean pagebean = new PageBean();
		pagebean.setTotalCount(sdi.getAvailableCount(cond));
		int tpage = pagebean.getPageCount();

		pagebean.setCurrentPage(pno);
		al = (ArrayList<SortBean>) sdi.getPageData(pagebean, cond);
		int s = pagebean.getTotalCount();
		String size = s + "";
		if (s < 1) {
			request.setAttribute("message", "对不起没有相关分类");
			request.getRequestDispatcher("queryfenlei.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", null);
			request.setAttribute("cond", cond);
			request.setAttribute("size", size);
			request.setAttribute("sortal", al);
			request.setAttribute("spage", pno + "");
			request.setAttribute("tpage", tpage + "");
			request.getRequestDispatcher("queryfenlei.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
