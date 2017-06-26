<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\allorder.css">
<link type="text/css" rel="stylesheet" href="..\css\applyshop.css">
<script type="text/javascript" src="..\js\jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="..\js\jquery.reveal.js"></script>

<title>申请开店</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="personaldetil">
		<div id="title">
			<span>个人中心</span>
		</div>
		<div id="clear"></div>
		<div id="catalog">
			<a href="GetOrderInfo">我的订单</a> <a href="GetAddr">修改地址</a> <a
				href="updatePassword.jsp">修改密码</a>
			<c:if test="${ManagerUser != null }">
				<a href="../manager/EnterStore">我的店铺</a>
			</c:if>
			<c:if test="${ManagerUser == null }">
				<a href="applyStore.jsp"><b>申请开店铺</b></a>
			</c:if>
		</div>
		<img alt="" src="..\images\myadvertise.GIF">

		<div id="writemessage">
			<h3>请填写下列信息：</h3>
			<form action="ApplyStore" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th>店铺名称：</th>
						<td><input type="text" value="" name="storeName"></td>
					</tr>
					<tr>
						<th>营业执照：</th>
						<td><input type="file" value="" name="file"></td>
					</tr>
					<tr>
						<th>店铺描述：</th>
						<td><textarea name="storeDescript" rows="4" cols="60"></textarea></td>
					</tr>

				</table>
				<br> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="提交">

			</form>
		</div>
	</div>





</body>
</html>