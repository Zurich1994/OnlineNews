<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<%String type = (String)session.getAttribute("type"); %>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>服务器管理</div>
    <dl class="leftmenu">
    <%if(type.equals("admin")){%>   
    <dd>
    <div class="title">
    <span><img src="images/leftico03.png" /></span>新闻管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="querynews.jsp" target="rightFrame">查询新闻</a><i></i></li>
        </li>
        <li><cite></cite><a href="addnews.jsp" target="rightFrame">添加新闻</a><i></i></li>
          <li><cite></cite><a href="RSS.jsp" target="rightFrame">RSS更新新闻</a><i></i></li>
          <li><cite></cite><a href="CleanServlet" target="rightFrame">清除一月前新闻</a><i></i></li>
        </ul>    
    </dd>
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>新闻分类管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="queryfenlei.jsp" target="rightFrame">查询分类</a><i></i></li>
        <li><cite></cite><a href="addfenlei.jsp" target="rightFrame">添加分类</a><i></i></li>
    </ul>     
    </dd>   
    
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>开发者服务
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="queryqingqiu.jsp" target="rightFrame">查询最新请求</a><i></i></li>
    </ul>     
    </dd> 
    <%}else if(type.equals("developer")){%>
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>开发者服务
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="queryqingqiu.jsp" target="rightFrame">查询最新请求</a><i></i></li>
    </ul>     
    </dd> 
    <%} %>
    </dl>
    
</body>
</html>
