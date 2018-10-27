<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<%String username = (String)session.getAttribute("username"); %>
</head>

<body style="background:url(images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.jsp" target="_parent"><img src="images/loginlogo.png" title="系统首页" /></a>
    </div>
<div class="topright">    
  <ul>
    <li><a href="login.jsp" target="_parent">退出</a></li>
  </ul>
     
    <div class="user">
    <span><%=username %></span>
    <i>欢迎您</i>
    </div>    
    
</div>

</body>
</html>
