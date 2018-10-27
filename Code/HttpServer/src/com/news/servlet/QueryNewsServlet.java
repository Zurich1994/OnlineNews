package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.NewsBean;
import com.news.bean.PageBean;
import com.news.bean.SortBean;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.SortDaoImpl;



public class QueryNewsServlet extends HttpServlet {

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
		NewsDaoImpl ndi = new NewsDaoImpl();
		String title = request.getParameter("condition");
		String selfenle = request.getParameter("selfenlei");
		String TSstate = request.getParameter("TSstate");
		String temppage = request.getParameter("spage");
		int pno=1;
		int selfenlei = Integer.parseInt(selfenle);
		if(temppage!=null&&!("").equals(temppage)){
			try{
				pno=Integer.parseInt(temppage);
			}catch (Exception e) {
				// TODO: handle exception
				pno=1;
			}
		}
		PageBean pagebean = new PageBean();
		try {
			pagebean.setTotalCount(ndi.getAvailableCount(title,selfenlei));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tpage=pagebean.getPageCount();
		pagebean.setCurrentPage(pno);
		ArrayList<NewsBean> al = null;
		try {
			al = (ArrayList<NewsBean>) ndi.getPageData(pagebean,title,selfenlei,TSstate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int s = pagebean.getTotalCount();
		String size = s+"";
		SortDaoImpl sdi = new SortDaoImpl();
		ArrayList<SortBean> sortal = new ArrayList<SortBean>();
		sortal = sdi.seleteSortByName("");
		ArrayList<String> sname = new ArrayList<String>();
		for (NewsBean n : al) {
			sname.add(sdi.selectSortById(n.getSort_id()).getSort_name());
		}
		request.setAttribute("selfenlei", selfenle);
		request.setAttribute("TSstate", TSstate);
		request.setAttribute("cond",title);
		request.setAttribute("size",size);
		request.setAttribute("sortal", sortal);
		request.setAttribute("sname", sname);
		request.setAttribute("goodsal", al);
		request.setAttribute("spage", pno+"");
		request.setAttribute("tpage", tpage+"");
		request.setAttribute("fir", "first");
		request.setAttribute("gs", "gs");
		request.getRequestDispatcher("querynews.jsp").forward(request,
				response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
