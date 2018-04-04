<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.removeAttribute("requestName");
request.getSession().removeAttribute("sessionName");
request.getSession().getServletContext().removeAttribute("contextName");

request.getSession().removeAttribute("currentUser");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'destory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>这是销毁页面</h1>
     <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">init</button>
    <button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">destory</button>
  </body>
</html>
