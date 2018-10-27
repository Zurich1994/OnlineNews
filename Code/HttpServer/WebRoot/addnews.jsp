<%@page import="com.news.bean.NewsBean"%>
<%@page import="com.news.bean.SortBean"%>
<%@page import="java.util.ArrayList"%>
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
<script charset="utf-8" type="text/javascript" src="js/myjs.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
});
</script>
<script type="text/javascript">
function addn(){
	var selfenlei=document.f1.selfenlei.value;
	var newstitle=document.f1.news_title.value;
	var s2=document.getElementById("s2");
	var s3=document.getElementById("s3");
	s2.innerHTML="";
	s3.innerHTML="";
	s6.innerHTML="";
	var i=1;
	if(newstitle==""){
		s2.innerHTML="新闻标题不能为空";
		i=0;
		}
	if(selfenlei=="- 请选择新闻分类 -"){
		s3.innerHTML="请选择新闻分类";
		i=0;
		}
	if(i==1){
		document.f1.submit();
		}
	
	}
function querysort(){
	document.queryfenlei.submit();
	}
function qgoods(){
	document.querygoods.submit();
}
function havethis(){
	alert("");
}
</script>
</head>

<body>
<form method="post" action="AddNewsServlet" name="f1" id="form">
<%String fir = (String) request.getAttribute("fir");if(fir!="first"){%>
<script type="text/javascript">
getsort("addgoods");
</script><%;}%>
<%String message = (String) request.getAttribute("message");%>
<%String panduan = (String) request.getAttribute("panduan");if(panduan=="f"){%>
<script type="text/javascript">
havethis();
</script><%;} %>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>新闻管理</li>
    <li>添加新闻</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">添加新闻</a></li>
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    <div class="lef">
    <div class="le">
  	  <ul class="forminfo">
  	    <li >
  	      <label>新闻标题<b>*</b></label><input name="news_title" type="text" class="dfinput" 
  	      value="" placeholder="请填写新闻标题" style="width:200px;"/>
	      </li>
        
        <li>
    <label>新闻分类<b>*</b></label> 
    <div class="vocation">
    <select name="selfenlei" class="select1" width="202" <%if(message!=null){%>onClick="alert('<%=message%>')"<%}%>>
    <option>- 请选择新闻分类 -</option>
    <%ArrayList<SortBean> sortal = (ArrayList<SortBean>)request.getAttribute("sortal"); 
if(sortal!=null)for(int i=0;i<sortal.size();i++){SortBean sb=sortal.get(i);%>
    <option value="<%=sb.getSort_id()%>"><%=sb.getSort_name() %></option>
    <%} %>
    </select>
    </div>   
    </li>
  	  </ul>
    </div>
    
    <div class="leti"><table>
    <tr height="40"><td><span><font color=red size=2 id="s2"></font></span></td></tr>
    <tr height="46"><td><span><font color=red size=2 id="s3"></font></span></td></tr>
    </table>
    </div>
    </div> 
    
    
    <div class="lef">
    <div class="le"> 
    	<ul class="forminfo"> 
   		<li>
  	      <label>图片URL</label><input name="picture" type="text" class="dfinput" 
  	      value="" placeholder="请填写图片URL" style="width:200px;"/>
    	</li>
    	</ul>    	
    </div>
    <div class="leti">
   <table>
    <tr height="40"><td>
     <span><font color=red size=2 id="s5"></font></span></td></tr>
    <tr height="45"><td><span><font color=red size=2 id="s6"></font></span></td></tr>

    </table>
    </div>
    </div> 
    </div>
    <ul class="forminfo"> 
  
    <li style="margin-top:15px">
      <label>正文<b>*</b></label>
    <textarea name="new_body" style="width:735px;height:160px; border:1px solid #7f7f7f;resize: none; ">
    </textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="添 加" onclick="addn()"/></li>
  </ul>
    
    </div>
    </div>    
    
    </div>


</body>

</html>
