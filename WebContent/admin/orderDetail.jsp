<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单收货信息</title>
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
	<h2>店铺信息</h2>
	<table>
		<tr>
			<th>店铺名称</th>
			<td>${AStore.storeName }</td>
			<th>店家</th>
			<td>${AStore.userName }</td>
		</tr>
	</table>
	<h2>订单详情</h2>
	<table>
		<tr>
			<th>订单编号</th>
			<th>订单日期</th>
			<th>订单成交价</th>
			<th>订单收货人</th>
			<th>订单收货地址</th>
			<th>收货人联系方式</th>
			<th>购买用户</th>
		</tr>
		<tr>
			<td>${OrderDetail.orderId }</td>
			<td>${OrderDetail.orderDate }</td>
			<td>${OrderDetail.orderPrice }</td>
			<td>${OrderDetail.orderConsignee }</td>
			<td>${OrderDetail.orderAddr }</td>
			<td>${OrderDetail.orderPhone }</td>
			<td>${OrderDetail.userName }</td>
		</tr>
	</table>
</body>
</html>