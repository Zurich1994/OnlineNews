<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css"> 
<script charset="utf-8" src="js/login.js">
</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table height="100%" width="100%" border="0"><tbody><tr>
<td align="center" valign="middle"> 
<form method="post" action="LoginServlet" name="f1" id="form">
<table id="__01" width="601" height="451" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="600" height="10" colspan="14" >
			<img src="images/login/fengefu.gif" width="600" height="10" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="10" alt=""></td>
	</tr>
	<tr>
		<td width="123" height="429" rowspan="11">
			<img src="images/login/fengefu.gif" width="123" height="429" alt=""></td>
		<td colspan="6" rowspan="2">
			<img src="images/login/03.jpg" width="274" height="32" alt=""></td>
		<td colspan="4">
			<img src="images/login/04.jpg" width="74" height="17" alt=""></td>
		<td rowspan="2">
			<img src="images/login/5.jpg" width="32" height="32" alt=""></td>
		<td width="97" height="32" colspan="2" rowspan="2">
			<img src="images/login/fengefu.gif" width="97" height="32" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="17" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login/07.jpg" width="57" height="15" alt=""></td>
		<td>
			<img src="images/login/08.jpg" width="17" height="15" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="15" alt=""></td>
	</tr>
	<tr>
		<td colspan="12">
			<img src="images/login/09.jpg" width="381" height="121" alt=""></td>
		<td width="96" height="397" rowspan="9">
			<img src="images/login/fengefu.gif" width="96" height="397" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="121" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/11.jpg" width="53" height="44" alt=""></td>
		<td  id="username" colspan="6">
			<input name="username" class="nameandpass" type="text" placeholder="请输入用户名，祝您工作愉快" onclick="udj()" onblur="ubdj()" ></td>
		<td colspan="5" class="czbj"><input type="button" class="cz" value="" border="0" onclick="czuser()"></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="44" alt=""></td>
	</tr>
	<tr>
		<td colspan="12" class="chbj">
			<img src="images/login/14.jpg" width="381" height="44" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="44" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/15.jpg" width="53" height="44" alt=""></td>
		<td id="password" colspan="6">
			<input name="pass" class="nameandpass" type="password" placeholder="请输入您的密码" onclick="pdj()" onblur="pbdj()"></td>
		<td colspan="5" class="czbj">
		  <input type="button" class="cz" value="" border="0" onclick="czpass()">
		</td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="44" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" rowspan="2">
			<img src="images/login/18.jpg" width="54" height="108" alt=""></td>
		<td rowspan="2">
			<img src="images/login/19.jpg" width="111" height="108" alt=""></td>
		<td id="tishi" colspan="9" ><span><font color=red size=2 id="s1">${message}</font></span>
			</td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="88" alt=""></td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="images/login/21.jpg" width="50" height="20" alt=""></td>
		<td colspan="2" rowspan="2">
			<input type="button" id="submi" value="" onclick="logincheck()" >
</td>
		<td colspan="5">
			<img src="images/login/23.jpg" width="68" height="20" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="20" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/24.jpg" width="53" height="15" alt=""></td>
		<td colspan="3">
			<input type="button" id="zhuce" value="" border="0"></td>
		<td>
			<img src="images/login/26.jpg" width="49" height="15" alt=""></td>
		<td colspan="3">
			<img src="images/login/27.jpg" width="35" height="15" alt=""></td>
		<td colspan="2" rowspan="2">
			<img src="images/login/28.jpg" width="33" height="16" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="15" alt=""></td>
	</tr>
	<tr>
		<td colspan="8" rowspan="2">
			<img src="images/login/29.jpg" width="314" height="21" alt=""></td>
		<td colspan="2" rowspan="2">
			<img src="images/login/30.jpg" width="34" height="21" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="images/login/31.jpg" width="33" height="20" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="20" alt=""></td>
	</tr>
	<tr>
		<td width="600" height="11" colspan="14">
			<img src="images/login/fengefu.gif" width="600" height="11" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="11" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/fengefu.gif" width="123" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="53" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="111" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="49" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="59" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="39" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="17" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="17" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="32" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/login/fengefu.gif" width="96" height="1" alt=""></td>
		<td></td>
	</tr>
</table>
</form></td></tr></tbody></table>
<!-- End Save for Web Slices -->

</body>
</html>