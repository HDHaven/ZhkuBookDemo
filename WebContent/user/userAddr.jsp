<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\personal.css">
<link type="text/css" rel="stylesheet" href="..\css\editaddress.css">
<title>修改地址</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="personaldetil">
		<div id="title">
			<span>个人中心</span>
		</div>
		<div id="clear"></div>
		<div id="catalog">
			<a href="GetOrderInfo">我的订单</a> <a href="GetAddr"><b>修改地址</b></a> <a
				href="updatePassword.jsp">修改密码</a>
			<c:if test="${ManagerUser != null }">
				<a href="../manager/EnterStore">我的店铺</a>
			</c:if>
			<c:if test="${ManagerUser == null }">
				<a href="applyStore.jsp">申请开店铺</a>
			</c:if>
		</div>
		<img alt="" src="..\images\myadvertise.GIF">

		<div id="editaddress">
			<form action="UpdateAddr" method="post">
				<table>
					<tr>
						<th>收货人:</th>
						<td><input type="text" value="${UserAddr.userConsignee }"
							name="userConsignee"></td>
					</tr>
					<tr>
						<th>联系方式:</th>
						<td><input type="text" value="${UserAddr.userPhone }"
							name="userPhone"></td>
					</tr>
					<tr>
						<th>配送地址:</th>
						<td><textarea rows="5" cols="80" name="userAddr">${UserAddr.userAddr }</textarea></td>
					</tr>
					<tr>
						<th></th>
						<th align="left"><input type="submit" value="修改"></th>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>