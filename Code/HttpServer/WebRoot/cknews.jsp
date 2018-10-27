<%@page import="com.news.bean.NewsBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
});
</script>
</head>

<body>
<%NewsBean gb = (NewsBean)request.getAttribute("gb"); %>
<% String name = (String)request.getAttribute("name");%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>新闻管理</li>
    <li>查询新闻</li>
    <li>查看详情</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">查看详情</a></li>
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    <div class="le">
  	  <ul class="forminfo">
  	    <li>
  	      <label>新闻编号</label><input name="" type="text" class="dfinput" value="<%=gb.getNews_id() %>" readonly style="width:200px;"/>
    </li> 
    <li >
  	      <label>新闻标题</label><input name="" type="text" class="dfinput" value="<%=gb.getNews_title() %>"  readonly style="width:200px;"/>
    	</li>
        <li>
    <label>新闻分类</label><input name="" type="text" class="dfinput" value="<%=name %>" readonly style="width:200px;"/></li>
   
      
    </ul></div>
    
    <div class="le"> 
    <ul class="forminfo"> 
   		<li>
  	      <label>图片URL</label><input name="" type="text" class="dfinput" value="<%=gb.getNews_picture() %>" readonly style="width:200px;"/>
    	</li>
        <li>
  	      <label>发布日期</label><input name="" type="text" class="dfinput" value="<%=gb.getDate() %>" readonly style="width:200px;"/>
    	</li>
        
    </ul>
    	
    </div>
    
    <ul class="forminfo"> 
  
    <li><label>正文</label>
    <textarea name="content" readonly  style="width:735px;height:180px; border:1px solid #7f7f7f;resize: none;"><%=gb.getNews_body() %></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="返 回" onclick="javascrtpt:history.go(-1);"/></li>
  </ul>
    
    </div>
    </div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>
