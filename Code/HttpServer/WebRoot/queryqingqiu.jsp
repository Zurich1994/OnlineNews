<%@page import="java.util.Iterator"%>
<%@page import="com.news.bean.RequestBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script charset="utf-8" type="text/javascript" src="js/myjs.js"></script>
</head>
<body>
<form method="post" action="QueryQingqiuServlet" name="queryqingqiu">

<script type="text/javascript">
function qingqiu(){
	//alert("");
	document.queryqingqiu.submit();
}
</script>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li>开发者服务</li>
    <li>查询最新请求</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
        <ul class="toolbar">         
        <li  onClick="qingqiu()" style="float:right"><span><img src="images/t02.png" /></span>刷新</li>
    	</ul>
    </div>
    
    <div >
    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="40%">请求时间</th>
        <th width="60%">类型</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<RequestBean> sortal = (ArrayList<RequestBean>)request.getAttribute("sortal");if(sortal!=null){
Iterator it = sortal.iterator();while(it.hasNext()){RequestBean sb =(RequestBean)it.next();%>
        <tr>
        <td><%=sb.getTime()%></td>
        <td><%=sb.getType()%></td>
        </tr> 
        <%}}%>
       </tbody>
    </table>
    </div>
   
    
    </div>    
</form>
</body>
</html>
