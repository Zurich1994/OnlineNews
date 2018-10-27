package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.impl.StaffDaoImpl;
import com.news.dao.impl.UserDaoImpl;



public class LoginServlet extends HttpServlet {

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

		StaffDaoImpl sdi = new StaffDaoImpl();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		String s = new String(username.getBytes("iso-8859-1"), "UTF-8");
		//数据库不区分大小写，所以取出来再和输入对比
		if(!sdi.isHaveThisUser(username)){
			request.setAttribute("message","此用户名尚未注册");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(pass.equals(sdi.selectUserByUname(s).getPassword())&&
				username.equals(sdi.selectUserByUname(s).getUsername())){
			String type = sdi.selectUserByUname(username).getType();
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("type",type);
			request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		else{
			request.setAttribute("message","用户名或者密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
