<%@page import="com.news.bean.PageBean"%>
<%@page import="java.util.Iterator"%>
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
<script type="text/javascript" src="js/jquery.js"></script>
<script charset="utf-8" type="text/javascript" src="js/myjs.js"></script>
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>    <script type="text/javascript">
        $(function() {
           $("#checkAll").click(function() {
                $('input[name="selectFlag"]').attr("checked",this.checked);
            });
            var $selectFlag = $("input[name='selectFlag']");
            $selectFlag.click(function(){
                $("#checkAll").attr("checked",$selectFlag.length == $("input[name='selectFlag']:checked").length ? true : false);
            });
        });
    </script>
</head>
<body>
<form method="post" action="QuerySortServlet" name="queryfenlei">
<%String size = (String)request.getAttribute("size");%>
<%String cond = (String)request.getAttribute("cond");%>
<%String spage = (String)request.getAttribute("spage");%>
<%String tpage = (String)request.getAttribute("tpage");%>
<%String sudel = (String) request.getAttribute("sudel");if(sudel!=null){%>
<script charset="utf-8">alert("<%=sudel%>");</script><%} %>
<%String message = (String) request.getAttribute("message");if(message!=null){%>
<script charset="utf-8">alert("<%=message%>");</script><%} %>
<script type="text/javascript">
function querysort(){
	//alert("");
	document.queryfenlei.submit();
}
</script>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li>新闻分类管理</li>
    <li>查询分类</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
        <ul class="toolbar">         
        <%if(cond!=null){%>
        <li><input class="cond" type="text" name="condition" placeholder="请输入分类名称" value="<%=cond%>"/></li>
        <%;}else{%>
        <li><input class="cond" type="text" name="condition" placeholder="请输入分类名称" value=""/></li><%;}%>
        <li class="selfen" onClick="querysort()"><span><img src="images/t02.png" /></span>查询</li>
        <li onClick="dsort()"><span><img src="images/t03.png" /></span>批量删除</li>
    	</ul>
    </div>
    
    <div class="includetable">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="9%"><input id="checkAll"" name="sl" type="checkbox" value=""/></th>
        <th width="13%">编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th width="20%">分类名称</th>
        <th width="39%">RSS</th>
        <th width="19%">操作</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<SortBean> sortal = (ArrayList<SortBean>)request.getAttribute("sortal");if(sortal!=null){
Iterator it = sortal.iterator();while(it.hasNext()){SortBean sb =(SortBean)it.next();%>
        <tr>
        <td><input name="selectFlag" type="checkbox" value="<%=sb.getSort_id()%>"/></td>
        <td><%=sb.getSort_id()%></td>
        <td><%=sb.getSort_name()%></td>
         <td><%=sb.getRSS()%></td>
        <td>
        	<a href="UpdateSortServlet1?upd=<%=sb.getSort_id()%>&condition=<%=cond%>" class="tablelink">修改</a>
             <a href="DeleteSortServlet?del=<%=sb.getSort_id()%>&condition=<%=cond%>" class="tablelink"
             onClick="if(confirm('删除分类会删除该分类下的所有新闻，确定删除么')==false)return false;"> 删除</a></td>
        </tr> 
        <%}}%>
       </tbody>
    </table>
    </div>
   
    <div class="pagin">
    	<div class="message">搜索出<i class="blue"><%if(size!=null){%><%=size %>
    	<%;}else{%>0<%;}%></i>条记录，共<i class="blue"><%if(tpage!=null){%><%=tpage%><%;}else{%>1<%;}%>页，</i>当前显示第&nbsp;<i class="blue"><%if(spage!=null){%>
    	<%=spage%><%}else{%>1<%}%>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="QuerySortServlet?condition=<%=cond%>&spage=1">首页</a></li>
        <%if(spage!=null&&tpage!=null){ int j = Integer.parseInt(spage);int i;int k;if(Integer.parseInt(tpage)>1){if(j==1){i=1;k=i+2;
        }else if(j==Integer.parseInt(tpage)){i=j-1;k=j+1;}else{i=j-1;k=j+2;}}else{i=1;k=2;}
        for(;i<k;i++){%>
        <li class="paginItem"><a href="QuerySortServlet?condition=<%=cond%>&spage=<%=i%>"><%=i%></a></li>    
        <%;} }%>
        <li class="paginItem"><a href="QuerySortServlet?condition=<%=cond%>&spage=<%=tpage%>">
        
        尾页</a></li>
        </ul>
    </div>
    </div>    
</form>
</body>
</html>
