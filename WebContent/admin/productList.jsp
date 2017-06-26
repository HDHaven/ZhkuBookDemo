<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单商品信息</title>
<style>
body {
	background: #eeeeee;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	border-left: 1px solid #888;
	border-top: 1px solid #888;
	background: #efefef;
}

th, td {
	border-right: 1px solid #888;
	border-bottom: 1px solid #888;
	padding: 5px 15px;
}

th {
	font-weight: bold;
	background: #ccc;
}
</style>
</head>
<body>
	<h2>订单详情</h2>
	<table>
		<tr>
			<th>订单编号</th>
			<td>${param.orderId }</td>
			<th>购买用户</th>
			<td>${param.userName }</td>
		</tr>
	</table>
	<hr>
	<h2>商品信息</h2>
	<table>
		<tr>
			<th>商品所属店铺</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>商品数量</th>
			<th>商品图片</th>
			<th>订单状态</th>
		</tr>
		<c:forEach var="product" items="${ProductList }">

			<tr>
				<td>${product.storeName }</td>
				<td>${product.bookName }</td>
				<td>${product.bookPrice }</td>
				<td>${product.bookNumber }</td>
				<td><a href="../images/${product.storeName }/${product.bookImage }" target="_blank">点击查看</a></td>
				<td>${product.orderState }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>