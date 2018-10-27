<%@page import="com.news.bean.NewsBean"%>
<%@page import="com.news.bean.SortBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<form method="post" action="QueryNewsServlet" name="querynews" id="form">
<%String cond = (String)request.getAttribute("cond");%>
<%String selfenlei = (String)request.getAttribute("selfenlei"); %>
<%String TSstate = (String)request.getAttribute("TSstate"); %>
<%String size = (String)request.getAttribute("size");%>
<%String spage = (String)request.getAttribute("spage");%>
<%String tpage = (String)request.getAttribute("tpage");%>
<%String sudel = (String) request.getAttribute("sudel");if(sudel!=null){%>
<script charset="utf-8">alert("<%=sudel%>");</script><%} %>
<%String message = (String) request.getAttribute("message");%>
<%String fir = (String) request.getAttribute("fir");if(fir!="first"){%>
<script type="text/javascript">
getsort("querynews");
</script><%;} %>
<script type="text/javascript">
function qnews(){
	//alert("");
	document.querynews.submit();
}
</script>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li>新闻管理</li>
    <li>查询新闻</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
        <ul class="toolbar">         
        <%if(cond!=null){%>
        <li><input class="cond" type="text" name="condition" placeholder="请输入新闻标题" value="<%=cond%>"/></li>
        <%;}else{%>
        <li><input class="cond" type="text" name="condition" placeholder="请输入新闻标题" value=""/></li><%;}%>
        <li class="f1">
        <select name="selfenlei"  class="flei" <%if(message!=null){%>onClick="alert('<%=message%>')"<%}%>>
        		<option value="-1" selected="selected">- 所有分类 -</option>
                <%ArrayList<SortBean> sortal = (ArrayList<SortBean>)request.getAttribute("sortal"); 
if(sortal!=null)for(int i=0;i<sortal.size();i++){SortBean sb=sortal.get(i);%>
    <option value="<%=sb.getSort_id()%>"><%=sb.getSort_name() %></option>
    <%} %>
             </select></li>
             
             <li class="f1">
        <select name="TSstate"  class="flei" >
        <%if(TSstate!=null&&TSstate.equals("YES")) {%>
        		<option value="">全部新闻</option>
        		<option value="NO">未设为推送</option>
                <option value="YES" selected="selected">已设为推送</option>
                <%}else if(TSstate!=null&&TSstate.equals("NO")){%>
                <option value="">全部新闻</option>
                <option value="NO" selected="selected">未设为推送</option>
                <option value="YES" >已设为推送</option>
                <%}else{%>
                <option value="" selected="selected">全部新闻</option>
                <option value="NO" >未设为推送</option>
                <option value="YES" >已设为推送</option>
                <%}%>
             </select></li>
             
            <%if(selfenlei!=null){ %>
 <script language= JavaScript>
 
     document.getElementsByName("selfenlei")[0].value=<%=Integer.parseInt(selfenlei)%>;
    </script><%;} %>
             
        <li class="sel" onClick="qnews()"><span><img src="images/t02.png" /></span>查询</li>
        <li onClick="dgoods()"><span><img src="images/t03.png" /></span>批量删除</li>
    	</ul>
    
    </div>
    
    <div class="includetable">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="5%"><input id="checkAll" type="checkbox" value=""/></th>
        <th width="5%">编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th width="42%">新闻标题</th>
        <th width="15%">新闻分类</th>
        <th width="18%">发布日期</th>
        <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<String> sname = (ArrayList<String>)request.getAttribute("sname");
        ArrayList<NewsBean> goodsal = (ArrayList<NewsBean>)request.getAttribute("goodsal");
if(goodsal!=null)for(int i=0;i<goodsal.size();i++){String name = sname.get(i);NewsBean gb=goodsal.get(i);%>
        <tr>
        <td><input name="selectFlag" type="checkbox" value="<%=gb.getNews_id()%>"/></td>
        <td><%=gb.getNews_id()%></td>
        <td><%=gb.getNews_title()%></td>
        <td><%=name%></td>
        <td><%=gb.getDate()%></td>
        <td><a href="UpdateNewsServlet1?upd=<%=gb.getNews_id()%>&what=0&name=<%=name%>" class="tablelink">查看</a>
        	<%if(gb.getTS().equals("NO")) {%>
        	<a href="TSnewsServlet?news_id=<%=gb.getNews_id()%>&condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&TSstate=<%=TSstate%>" class="tablelink">设为推送</a>
        	<%}else{ %>
        	<a href="QXtuisongServlet?news_id=<%=gb.getNews_id()%>&condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&TSstate=<%=TSstate%>" class="tablelink">取消推送</a>
        	<%}%>
             <a name="deletegoods" href="DeleteNewsServlet?del=<%=gb.getNews_id()%>&condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&TSstate=<%=TSstate%>" class="tablelink" > 删除</a></td>
        </tr> 
        <%}%>
       </tbody>
    </table>
    </div>
    <div class="pagin">
    	<div class="message">搜索出<i class="blue"><%if(size!=null){%><%=size %>
    	<%;}else{%>0<%;}%></i>条记录，共<i class="blue"><%if(tpage!=null){%><%=tpage%><%;}else{%>1<%;}%>页，</i>当前显示第&nbsp;<i class="blue"><%if(spage!=null){%>
    	<%=spage%><%}else{%>1<%}%>&nbsp;</i>页</div>
        <ul class="paginList">
        <%if(selfenlei!=null){ %>
        <li class="paginItem">                                                          
        <a href="QueryNewsServlet?condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&spage=1">首页</a></li>
        <%if(spage!=null&&tpage!=null){ int j = Integer.parseInt(spage);int i;int k;if(Integer.parseInt(tpage)>1){if(j==1){i=1;k=i+2;
        }else if(j==Integer.parseInt(tpage)){i=j-1;k=j+1;}else{i=j-1;k=j+2;}}else{i=1;k=2;}
        for(;i<k;i++){%>
        <li class="paginItem"><a href="QueryNewsServlet?condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&TSstate=<%=TSstate%>&spage=<%=i%>"><%=i%></a></li>    
        <%;} }%>
        <li class="paginItem"><a href="QueryNewsServlet?condition=<%=cond%>&selfenlei=<%=Integer.parseInt(selfenlei)%>&TSstate=<%=TSstate%>&spage=<%=tpage%>">
        
        尾页</a></li>
        <%} %>
        </ul>
    </div>
  </div>
</form>
</body>

</html>
