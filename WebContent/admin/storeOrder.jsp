<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>店铺订单</title>
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
	<h2>订单列表</h2>
	<c:if test="${StoreOrder.data == null }">
		<p>该店铺暂无订单信息</p>
	</c:if>
	<c:if test="${StoreOrder.data != null }">
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
			<c:forEach var="product" items="${StoreOrder.data }">
				<tr>
					<td>${product.orderId }</td>
					<td>${product.userName }</td>
					<td>${product.bookName }</td>
					<td>${product.bookPrice }</td>
					<td>${product.bookNumber }</td>
					<td><a target="_blank" href="../images/${AStore.storeName }/${product.bookImage }">点击查看</a></td>
					<td>${product.orderState }</td>
					<td><a href="GetOrderDetail?orderId=${product.orderId }">订单详情</a></td>
				</tr>
			</c:forEach>
		</table>
		<p align="center">
			每页${StoreOrder.pageSize }行 共${StoreOrder.totalRows }行
			页数${StoreOrder.curPage }/${StoreOrder.totalPages }<br>
			<c:choose>
				<c:when test="${StoreOrder.curPage == 1 }">首页 上一页</c:when>
				<c:otherwise>
					<a href="GetStoreOrder?page=1&storeName=${AStore.storeName }">首页</a>
					<a
						href="GetStoreOrder?page=${StoreOrder.curPage-1 }&storeName=${AStore.storeName }">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${StoreOrder.curPage == StoreOrder.totalPages }">下一页 尾页</c:when>
				<c:otherwise>
					<a
						href="GetStoreOrder?page=${StoreOrder.curPage+1 }&storeName=${AStore.storeName }">下一页</a>
					<a
						href="GetStoreOrder?page=${StoreOrder.totalPages }&storeName=${AStore.storeName }">尾页</a>
				</c:otherwise>
			</c:choose>
		</p>
	</c:if>
</body>
</html>