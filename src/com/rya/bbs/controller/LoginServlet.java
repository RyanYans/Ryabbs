package com.rya.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rya.bbs.factory.ServiceFactory;
import com.rya.bbs.service.IUserService;
import com.rya.bbs.service.impl.UserServiceImpl;
import com.rya.bbs.userbean.UserBean;

public class LoginServlet extends HttpServlet {

	// 获取service
	private IUserService service = (UserServiceImpl)ServiceFactory.newInstance().getService("USERSERVICE");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//设置响应正文字符集
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//获取请求正文
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//验证数据完整性
		if(username == null || "".equals(username)){
			out.write("用户名不能为空！2秒后转向登录页");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		if(password == null || "".equals(password)){
			out.write("密码不能为空！2秒后转向登录页");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		
		//验证数据真确性
		UserBean user = service.findUserByName(username);
		
		if(user == null){
			//没查到用户
			out.write("没有该用户！2秒后转向登录页");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		//登录成功，将用户信息存入session域中
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", user);
		response.sendRedirect(request.getContextPath());
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
