<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情</title>
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
				<td>${StoreName }</td>
				<th>店家</th>
				<td>${ManagerUser }</td>
			</tr>
		</table>
		<h2>订单详情</h2>
		<table>
			<tr>
				<th>订单编号</th>
				<td>${OrderDetail.orderId }</td>
			</tr>
			<tr>
				<th>订单日期</th>
				<td>${OrderDetail.orderDate}</td>
			</tr>
			<tr>
				<th>订单收货人</th>
				<td>${OrderDetail.orderConsignee }</td>
			</tr>
			<tr>
				<th>收货人联系方式</th>
				<td>${OrderDetail.orderPhone }</td>
			</tr>
			<tr>
				<th>购买用户</th>
				<td>${OrderDetail.userName }</td>
			</tr>
			<tr>
				<th>订单收货地址</th>
				<td>${OrderDetail.orderAddr }</td>
			</tr>
		</table>
</body>
</html>