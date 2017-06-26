<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>店铺信息</title>
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
	<h2 align="center">店铺信息</h2>
	<table align="center" width="800px">
		<tr>
			<th>店名</th>
			<th>店主</th>
			<th>店铺评分</th>
			<th>店铺状态</th>
			<th>销售额</th>
			<th>销量</th>
			<th>营业执照</th>
			<th>操作</th>
		</tr>
		<c:forEach var="store" items="${StoreInfo.data }">
			<tr>
				<td>${store.storeName }</td>
				<td>${store.userName }</td>
				<td>${store.storeEvaluate }</td>
				<td>${store.storeState }</td>
				<td>${store.storeSale }</td>
				<td>${store.storeSaleNum }</td>
				<td><a href="../images/licenses/${store.storeLicense }"
					target="_blank">点击查看</a></td>
				<td><a href="GetStoreOrder?storeName=${store.storeName }">店铺订单</a>
					<a
					href="DeleteStore?storeName=${store.storeName }&page=${StoreInfo.curPage }"
					onclick="return confirm('确定要删除该店铺吗？')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		每页${StoreInfo.pageSize }行 共${StoreInfo.totalRows }行
		页数${StoreInfo.curPage }/${StoreInfo.totalPages }<br>
		<c:choose>
			<c:when test="${StoreInfo.curPage == 1 }">首页 上一页</c:when>
			<c:otherwise>
				<a href="GetAllStore?page=1">首页</a>
				<a href="GetAllStore?page=${StoreInfo.curPage-1 }">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${StoreInfo.curPage == StoreInfo.totalPages }">下一页 尾页</c:when>
			<c:otherwise>
				<a href="GetAllStore?page=${StoreInfo.curPage+1 }">下一页</a>
				<a href="GetAllStore?page=${StoreInfo.totalPages }">尾页</a>
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>