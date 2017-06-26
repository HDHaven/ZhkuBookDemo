<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
body {
	color: #4682B4;
	background: #ADD8E6;
}

a {
	font-size: 13px;
	color: #06F;
	text-decoration: none;
}

a:HOVER {
	color: #909;
}
</style>
</head>
<body>
	<a href="#">首页</a>
	<a href="../loginout.jsp" onclick="return confirm('确定要退出登录吗？')">欢迎你，${LoginUser }</a>
	<a href="../index.jsp">退出</a>
	<h1 align="center">${StoreName }</h1>
</body>
</html>