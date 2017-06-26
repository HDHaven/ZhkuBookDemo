<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="UTF-8">

<title>menu</title>

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
			<li class="dropdown"><a href="#" data-toggle="dropdown">订单管理<i
					class="icon-arrow"></i></a>
				<ul class="dropdown-menu">
					<li><a href="GetOrder" target="content">订单查看</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" data-toggle="dropdown">图书管理<i
					class="icon-arrow"></i></a>
				<ul class="dropdown-menu">
					<li><a href="addBook.jsp" target="content">添加新图书</a></li>
					<li><a href="GetBook" target="content">图书信息查看</a></li>
				</ul></li>
		</ul>
	</div>

	<script src="../js/index.js"></script>

</body>

</html>