package com.news.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.TuisongBen;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.TuisongDaoImpl;

public class tsToUserServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		TuisongDaoImpl tdi = new TuisongDaoImpl();
		NewsDaoImpl ndi = new NewsDaoImpl();
		ArrayList<Integer> TSnews = tdi.queryTSnews();
		ArrayList<TuisongBen> alreadyTS = tdi.queryTSByUser(username);
		int index = 0;
		for(int i=0;i<TSnews.size();i++){
			if(alreadyTS!=null&&alreadyTS.size()>0){
				for(int j = 0;j<alreadyTS.size();j++){
					if(TSnews.get(i) == alreadyTS.get(j).getNews_id())
						TSnews.remove(index);
				}
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		sb.append("<TS>");
		System.out.println(TSnews.size());
		if(TSnews!=null&&TSnews.size()>0){
		for(int k=0;k<TSnews.size();k++){
			sb.append("<title>");
			sb.append(ndi.selectNewsById(TSnews.get(k)).getNews_title());
			sb.append("</title>");
			tdi.addTU(new TuisongBen(0, TSnews.get(k), username));
		}}
		sb.append("</TS>");
		out.write(sb.toString());
		System.out.println(sb.toString());
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
