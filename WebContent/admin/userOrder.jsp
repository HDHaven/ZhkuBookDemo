<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户订单</title>
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
	<h2>用户信息</h2>
	<table>
		<tr>
			<th>用户名</th>
			<td>${param.userName }</td>
		</tr>
	</table>
	<h2>订单列表</h2>
		<c:if test="${UserOrder.data == null }"><p>该用户暂无订单信息</p></c:if>
		<c:if test="${UserOrder.data != null }">
			<table>
				<tr>
					<th>订单编号</th>
					<th>订单日期</th>
					<th>订单成交价</th>
					<th>收货人</th>
					<th>收货地址</th>
					<th>联系方式</th>
					<th>购买用户</th>
					<th>订单详情</th>
				</tr>
				<c:forEach var="order" items="${UserOrder.data }">
					<tr>
						<td>${order.orderId }</td>
						<td>${order.orderDate }</td>
						<td>${order.orderPrice }</td>
						<td>${order.orderConsignee }</td>
						<td>${order.orderAddr }</td>
						<td>${order.orderPhone }</td>
						<td>${order.userName }</td>
						<td><a
							href="GetOrderProduct?orderId=${order.orderId }&userName=${param.userName }">订单详情</a></td>
					</tr>
				</c:forEach>
			</table>
			<p align="center">
				每页${UserOrder.pageSize }行 共${UserOrder.totalRows }行
				页数${UserOrder.curPage }/${UserOrder.totalPages }<br>
				<c:choose>
					<c:when test="${UserOrder.curPage == 1 }">首页 上一页</c:when>
					<c:otherwise>
						<a href="GetUserOrder?page=1&userName=${param.userName }">首页</a>
						<a
							href="GetUserOrder?page=${UserOrder.curPage-1 }&userName=${param.userName }">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${UserOrder.curPage == UserOrder.totalPages }">下一页 尾页</c:when>
					<c:otherwise>
						<a
							href="GetUserOrder?page=${UserOrder.curPage+1 }&userName=${param.userName }">下一页</a>
						<a
							href="GetUserOrder?page=${UserOrder.totalPages }&userName=${param.userName }">尾页</a>
					</c:otherwise>
				</c:choose>
			</p>
		</c:if>
</body>
</html>