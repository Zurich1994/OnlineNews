package com.news.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.RequestBean;
import com.news.dao.impl.RequestDaoImpl;
import com.news.dao.impl.UserDaoImpl;

public class LoginOrRegister extends HttpServlet {

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

		doPost(request, response);
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String what=request.getParameter("what");//注册还是登陆
		UserDaoImpl udi = new UserDaoImpl();
		if(what.equals("login")){
			if(!udi.isHaveThisUser(username))
				out.write("noUser");//没有此用户名
			else if(udi.selectUserByUname(username).getPassword().equals(password)
					&&password.equals(udi.selectUserByUname(username).getPassword()))
				out.write("true");
			else//密码错误
				out.write("false");
			}
		else if(what.equals("register")){
			if(udi.isHaveThisUser(username))
				out.write("false");//有此用户名
			else{
				udi.addUser(username, password);
				out.write("true");
			}
		}else
			out.write("error");
		out.flush();
		out.close();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.toString();
		String type = this.getClass().getCanonicalName().toString().substring(25);
		RequestDaoImpl rdi = new RequestDaoImpl();
		rdi.addRequest(new RequestBean(0,df.format(new Date()).toString(), type));
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
