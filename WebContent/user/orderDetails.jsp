<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<h3>订单详情：</h3>
		<table class="table4">
			<tr>
				<th>订单编号:</th>
				<td>${OrderDetail.orderId }</td>
			</tr>
			<tr>
				<th>订单日期:</th>
				<td>${OrderDetail.orderDate }</td>
			</tr>
			<tr>
				<th>收货人姓名:</th>
				<td>${OrderDetail.orderConsignee }</td>
			</tr>
			<tr>
				<th>收货人电话:</th>
				<td>${OrderDetail.orderPhone }</td>
			</tr>
			<tr>
				<th>收货人地址:</th>
				<td>${OrderDetail.orderAddr }</td>
			</tr>
		</table>
	</div>
</body>
</html>