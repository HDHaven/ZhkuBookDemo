<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allorder.css">
<title>订单详情</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="personaldetil">
		<h3>包含的商品：</h3>
		<div id="product">
			<table class="table3">
				<c:forEach var="product" items="${ProductInfo }">

					<tr>
						<td class="table3_th"><a href="GetBookDetails?storeName=${product.storeName }&bookName=${product.bookName }"><img
							src="../images/${product.storeName }/${product.bookImage }"></a></td>
						<td class="table3_th">${product.bookName }</td>
						<td class="table3_th">${product.storeName }</td>
						<td class="table3_th">${product.bookPrice }(￥)</td>
						<td class="table3_th">${product.bookNumber }(本)</td>
						<td class="table3_th">${product.orderState }</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div id="clear"></div>
		<hr>
		<h3>收货人信息：</h3>
		<table class="table4">
			<tr>
				<th>收货人姓名:</th>
				<td>${Order.orderConsignee }</td>
			</tr>
			<tr>
				<th>收货人电话:</th>
				<td>${Order.orderPhone }</td>
			</tr>
			<tr>
				<th>收货人地址:</th>
				<td>${Order.orderAddr }</td>
			</tr>
		</table>
	</div>
</body>
</html>