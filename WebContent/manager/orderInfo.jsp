<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="contentType" content="text/html; charset=utf-8">
<title>${StoreName }的订单</title>
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
	<h2>订单列表</h2>
	<form action="GetOrderByState" method="post">
		订单状态：<select name="orderState">
			<option value="${OrderState }">${OrderState }</option>
			<option value="待处理" >待处理</option>
			<option value="正在配送" >正在配送</option>
			<option value="已完成" >已完成</option>
			<option value="已取消" >已取消</option>
			<option value="待审核" >待审核</option>
		</select>
		<input type="submit" value="查询">
	</form>
	<hr>
	<c:if test="${OrderInfo.data == null }">订单信息为空</c:if>
	<c:if test="${OrderInfo.data != null }">
	<table>
		<tr>
			<th>订单编号</th>
			<th>购买用户</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>商品数量</th>
			<th>商品图片</th>
			<th>订单状态</th>
			<th>订单详情</th>
		</tr>
		<c:forEach var="product" items="${OrderInfo.data }">
		<tr>
			<td>${product.orderId }</td>
			<td>${product.userName }</td>
			<td>${product.bookName }</td>
			<td>${product.bookPrice }</td>
			<td>${product.bookNumber }</td>
			<td><a target="_blank" href="../images/${StoreName }/${product.bookImage }">点击查看</a></td>
			<td>
			<form action="UpdateOrderState" method="post">
				<input type="hidden" name="productId" value="${product.productId }"/>
				<input type="hidden" name="page" value="${OrderInfo.curPage }"/>
				<select name="orderState">
					<option value="${product.orderState }" selected>${product.orderState }</option>
					<option value="待处理">待处理</option>
					<option value="正在配送">正在配送</option>
					<option value="已完成">已完成</option>
					<option value="已取消">已取消</option>
					<option value="待审核">待审核</option>
				</select>
				<input type="submit" value="[修改]"/>
			</form>
			</td>
			<td><a href="GetOrderDetails?orderId=${product.orderId }">订单详情</a></td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		每页${OrderInfo.pageSize }行 共${OrderInfo.totalRows }行
		页数${OrderInfo.curPage }/${OrderInfo.totalPages }<br>
		<c:choose>
			<c:when test="${OrderInfo.curPage == 1 }">首页 上一页</c:when>
			<c:otherwise>
				<c:if test="${OrderState == null }">
					<a href="GetOrder?page=1">首页</a>
					<a href="GetOrder?page=${OrderInfo.curPage-1 }">上一页</a>
				</c:if>
				<c:if test="${OrderState != null }">
					<a href="GetOrderByState?page=1&orderState=${OrderState }">首页</a>
					<a href="GetOrderByState?page=${OrderInfo.curPage-1 }&orderState=${OrderState }">上一页</a>
				</c:if>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${OrderInfo.curPage == OrderInfo.totalPages }">下一页 尾页</c:when>
			<c:otherwise>
				<c:if test="${OrderState == null }">
				<a href="GetOrder?page=${OrderInfo.curPage+1 }">下一页</a>
				<a href="GetOrder?page=${OrderInfo.totalPages }">尾页</a>
				</c:if>
				<c:if test="${OrderState != null }">
				<a href="GetOrderByState?page=${OrderInfo.curPage+1 }&orderState=${OrderState }">下一页</a>
				<a href="GetOrderByState?page=${OrderInfo.totalPages }&orderState=${OrderState }">尾页</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</p>
	</c:if>
</body>
</html>