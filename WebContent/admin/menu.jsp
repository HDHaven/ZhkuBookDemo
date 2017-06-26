<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>仲有书后台管理</title>
<link rel="stylesheet" href="../css/normalize.css">
<link rel="stylesheet" href="../css/style.css" media="screen"
	type="text/css" />
</head>
<body>
	<div style="text-align: center; clear: both;">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
	</div>
	<div class="container">
		<ul>
			<li class="dropdown"><a href="#" data-toggle="dropdown">临时店铺管理<i class="icon-arrow"></i></a>
				<ul class="dropdown-menu">
					<li><a href="GetTempStore" target="content">店铺申请审核</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" data-toggle="dropdown">店铺管理<i class="icon-arrow"></i></a>
				<ul class="dropdown-menu">
					<li><a href="GetAllStore" target="content">店铺查看</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" data-toggle="dropdown">用户管理<i class="icon-arrow"></i></a>
				<ul class="dropdown-menu">
					<li><a href="GetAllUser" target="content">用户查看</a></li>
				</ul></li>
		</ul>
	</div>

	<script src="../js/index.js"></script>

</body>

</html>