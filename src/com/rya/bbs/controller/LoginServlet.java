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

	// ��ȡservice
	private IUserService service = (UserServiceImpl)ServiceFactory.newInstance().getService("USERSERVICE");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//������Ӧ�����ַ���
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//��ȡ��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//��֤����������
		if(username == null || "".equals(username)){
			out.write("�û�������Ϊ�գ�2���ת���¼ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		if(password == null || "".equals(password)){
			out.write("���벻��Ϊ�գ�2���ת���¼ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		
		//��֤������ȷ��
		UserBean user = service.findUserByName(username);
		
		if(user == null){
			//û�鵽�û�
			out.write("û�и��û���2���ת���¼ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		//��¼�ɹ������û���Ϣ����session����
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", user);
		response.sendRedirect(request.getContextPath());
			
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
