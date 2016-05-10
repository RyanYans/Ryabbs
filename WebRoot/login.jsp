<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
		<title>RY论坛登录页面</title>
		
		<script type="text/javascript">
			function _submit(){
				var username = document.getElementsByName("username")[0].value;
				var password = document.getElementsByName("password")[0].value;

				if(username == ""){
					alert("请输入用户名！");
					return false;
				}
				if(password == ""){
					alert("请输入密码！");
					return false;
				}
				return true;
			}
		</script>
		
  </head>
  
  <body>
  	<h1>RY论坛  登录页面</h1>
  	<form action="<%=request.getContextPath() %>/LoginServlet" method="post" onsubmit="return _submit();">
  		用户名：<input type="text" name="username" /> <br>
  		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /> <br>
  		<input type="submit" value="登录" />
  	</form>
   
   	
  </body>
</html>
