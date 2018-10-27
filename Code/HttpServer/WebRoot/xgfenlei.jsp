<%@page import="com.news.bean.SortBean"%>
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
<script charset="utf-8" type="text/javascript" src="js/xgfenlei.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
});
</script>
</head>

<body>
<%String cond = (String)request.getAttribute("cond");%>
<form method="post" action="UpdateSortServlet2?condition=<%=cond%>" name="xgfenlei" id="form">

<%SortBean sb = (SortBean)request.getAttribute("sb"); %>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>新闻分类管理</li>
    <li>查询分类</li>
    <li>修改分类</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">修改分类</a></li>
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    <div class="lefen">
    <div class="le">
  	  <ul class="forminfo">
  	    <li>
  	      <label>分类编号<b>*</b></label><input name="flno" type="text" readonly class="dfinput" 
  	      value="<%=sb.getSort_id()%>" style="width:200px;" onclick="alert('很抱歉暂时不能为您修改分类编号')"/>
    </li>
  	  </ul>
    </div>
    
    <div class="leti"><table>
    <tr height="40"><td>
     <span><font color=red size=2 id="s1"></font></span></td></tr>
    
    </table>
    </div>
    </div> 
    
    
    <div class="lefen">
    <div class="le"> 
    	<ul class="forminfo"> 
   		<li>
  	      <label>分类名称<b>*</b></label><input name="flname" type="text" class="dfinput" value="<%=sb.getSort_name()%>" style="width:200px;"/>
    	</li>   
        <li></li>
    	</ul>    	
    </div>
    <div class="leti">
   <table>
    <tr height="40"><td>
     <span><font color=red size=2 id="s5"></font></span></td></tr>
   
    </table>
    </div>
    </div> 
    </div>
    <ul class="forminfo"> 
  
    <li style="margin-top:15px"><label>分类RSSs</label>
    <textarea name="content" style="width:735px;height:160px; border:1px solid #7f7f7f;resize: none; "><%=sb.getRSS()%></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="修 改"  onclick="xgfn()"/></li>
  </ul>
    
    </div>
    </div>    
    
    </div>


</body>

</html>
