<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<!--   第一种方法传参数 -->
	<!--   <form action="LoginAction.action" method="post">
   用户名：<input type="text" name="username"><br>
   密码：<input type="password" name="password"><br>
   <input type="submit" value="提交">
   </form>-->
	<!--   第二种方法传参数 -->
	<!--  <form action="LoginAction.action" method="post">
   用户名：<input type="text" name="user.username"><br>
   密码：<input type="password" name="user.password"><br>
   <input type="submit" value="提交">-->
	<!--   第三种方法传参数 -->
	<form action="LoginAction.action" method="post">
		用户名：<input type="text" name="username"><br><s:fielderror name="username"></s:fielderror> 
		年龄：<input
			type="text" name="age"><br> 密码：<input type="password"
			name="password"><br> 书籍1：<input type="text"
			name="bookList[0]"><br> 书籍2：<input type="text"
			name="bookList[1]"><br> user1：<input type="text"
			name="userList[0].username"><br> user2：<input
			type="text" name="userList[1].username"><br> <input
			type="submit" value="提交">
	</form>
</body>
</html>
