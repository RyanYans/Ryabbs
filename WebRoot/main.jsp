<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.rya.bbs.userbean.UserBean" %>
<html>
  <head>
		<title>RY论坛主页</title>
  </head>
  
  <body>
    <h1>RY论坛</h1>
    
    <% UserBean user = (UserBean)session.getAttribute("userinfo"); 
    
   		if(user == null) { 
   	%>
    <a href="<%=request.getContextPath() %>/login.jsp">登录</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath() %>/register.jsp">注册</a>
    <% }else{ %>
	欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;<%=user.getUsername() %>	   
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath() %>/LoginoutServlet">注销</a>
    <% } %>
  </body>
</html>
