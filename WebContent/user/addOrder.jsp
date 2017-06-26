<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\submitorder.css">
<title>确认订单</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="ordermessage">
		<h3>确认订单信息</h3>
		<br>

		<table id="table1">
			<tr>
				<th>商品</th>
				<th>单价(元)</th>
				<th>数量(本)</th>
				<th>小计(元)</th>
			</tr>
		</table>
		<hr>

		<table id="table2">
		<c:forEach var="pro" items="${ProductList }">
			<tr>
				<td id="table2_img"><a href="GetBookDetails?storeName=${pro.storeName }&bookName=${pro.bookName }"><img src="../images/${pro.storeName }/${pro.bookImage }" /></a></td>
				<td id="table2_name">${pro.bookName }</td>
				<td id="table2_price">${pro.bookPrice }</td>
				<td id="table2_count">${pro.bookNumber }</td>
				<td id="table2_totalprice">${Integer.parseInt(pro.bookPrice) * Integer.parseInt(pro.bookNumber) }</td>
			</tr>
		</c:forEach>
		</table>

		<div id="totalprice">
			总价：<span>${SumPrice }元</span>
		</div>
		<div id="clear"></div>
		<br>
		<h3>填写收货地址</h3>
		<hr>
		<form action="AddOrder" method="post">
			<table>
				<tr>
					<th>收货人姓名:</th>
					<td><input type="text" value="${UserAddr.userConsignee }" name="orderConsignee"></td>
				</tr>
				<tr>
					<th>收货人电话:</th>
					<td><input type="text" value="${UserAddr.userPhone }" name="orderPhone"></td>
				</tr>
				<tr>
					<th>收货人地址:</th>
					<td><textarea rows="5" cols="80" name="orderAddr">${UserAddr.userAddr }</textarea></td>
				</tr>
				<tr>
					<th></th>
					<th align="left"><input type="submit" value="提交订单"></th>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>