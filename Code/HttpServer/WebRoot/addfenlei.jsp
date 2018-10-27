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
		<script charset="utf-8" type="text/javascript" src="js/addfl.js"></script>
		<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
	});
</script>
	</head>

	<body>
		<form method="post" action="AddSortServlet" name="addfl">
		<%String message=(String)request.getAttribute("message");
		if(message!=null){%>
		<script charset="utf-8">
		alert("<%=message%>");</script>
		<%;} %>

			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						新闻分类管理
					</li>
					<li>
						添加分类
					</li>
				</ul>
			</div>

			<div class="formbody">


				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="#tab1" class="selected">添加分类</a>
							</li>
						</ul>
					</div>

					<div id="tab1" class="tabson">
						<div class="lefen">
							<div class="le">
								<ul class="forminfo">
									<li>
										<label>
											分类RSS
											<b>*</b>
										</label>
									
											 <input name="flrss" type="text" class="dfinput" value=""
											 placeholder="请填写分类RSS" style="width: 200px;" />
								</ul>
							</div>

							<div class="leti">
								<table>
									<tr height="40">
										<td>
											<span><font color=red size=2 id="addfl1"></font>
											</span>
										</td>
									</tr>

								</table>
							</div>
						</div>


						<div class="lefen">
							<div class="le">
								<ul class="forminfo">
									<li>
										<label>
											分类名称
											<b>*</b>
										</label>
									
										<input name="flname" type="text" class="dfinput" value=""
											placeholder="请填写分类名称" style="width: 200px;" />
									</li>
									<li></li>
								</ul>
							</div>
							<div class="leti">
								<table>
									<tr height="40">
										<td>
											<span><font color=red size=2 id="addfl5"></font>
											</span>
										</td>
									</tr>

								</table>
							</div>
						</div>
					</div>
					<ul class="forminfo">
						
						<li>
							<input type="submit" class="btn" value="添 加"/>
						</li>

					</ul>

				</div>
			</div>


		</form>
	</body>

</html>
