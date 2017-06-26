<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href=".\css\allHead.css">
<title></title>
</head>
<body>
<div >  <div>
			<div id="top_left">
				<a href="index.jsp"><img alt="" src=".\images\logo.jpg"></a>
			</div>
			<div id="top_right">
				<c:choose>
					<c:when test="${LoginUser == null }">
						<a href="login.jsp">登录</a>|<a href="register.jsp">成为会员</a>|
					</c:when>
					<c:otherwise>
						<a href="loginout.jsp" onclick="return confirm('确定要退出登录吗？')">welcome,${LoginUser }</a>|
					</c:otherwise>
				</c:choose>
				<img alt="" src=".\images\cart.gif"> <a href="user/GetCart">购物车</a>| 
				 <a href="user/GetOrderInfo">个人中心</a> 
			</div>
			<div class="clear"></div>
		</div>
		<div id="menu">
			<a href="GetBookInfoByClass?bookClass=计算机">计算机</a> <a href="GetBookInfoByClass?bookClass=管理">管理</a> <a href="#">心理</a> <a href="#">外语</a>
			<a href="#">经管</a> <a href="#">励志</a> <a href="#">社科</a> <a href="#">学术</a>
			<a href="#">少儿</a> <a href="#">艺术</a> <a href="#">原版</a> <a href="#">科技</a>
			<a href="#">考试</a> <a href="#">生活百科</a> <a href="#" class="all">全部商品目录</a>
		</div>
		<div id="search">
		  <form action="GetBookInfoByName" method="post"> 
		  		<input type="text" name="bookName" value="${SearchName }"/> 
		  		<input type="image"src=".\images\serchbutton.gif">
		  </form>
		</div>
</div>
</body>
</html>