<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<%String username = (String)session.getAttribute("username"); %>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
<div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b><%=username %> 您好，欢迎使用哈工程新闻后台管理系统</b>
    </div>  
  <div class="xline"></div>
</div>
</body>

</html>
