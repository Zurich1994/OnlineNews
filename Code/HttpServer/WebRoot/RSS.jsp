<%@page import="com.news.dao.impl.SortDaoImpl" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title> 

<script type="text/javascript">
window.onload=function(){
func();
}
function func(){
document.rss.submit();};
</script>

</head>
<body>
<form name="rss" action="RssServlet" >
<center>
<h1><p style="margin-top:200px;">正在从RSS更新新闻，请稍候</p></h1>
<table border="1">
<tr width="500px">

</tr></table>
</center>
</form>
</body>
</html>