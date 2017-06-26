<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>临时店铺管理</title>
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
	<h2 align="center">临时店铺</h2>
	<c:choose>
		<c:when test="${TempStoreInfo.data == null }"><h5 align="center">暂无申请店铺信息</h5></c:when>
		<c:otherwise>

			<table align="center" width="450px">
				<tr>
					<th>店铺名称</th>
					<th>申请开店人</th>
					<th>店铺简介</th>
					<th>营业执照</th>
					<th>操作</th>
				</tr>
				<c:forEach var="ts" items="${TempStoreInfo.data }" varStatus="vs">
					<tr>
						<td><c:out value="${ts.tempStoreName }" /></td>
						<td><c:out value="${ts.userName }" /></td>
						<td><c:out value="${ts.tempStoreDescript }" /></td>
						<td><a href="../images/licenses/${ts.tempStoreLicense }" target="_blank">点击查看</a></td>
						<td><a href="AddStore?index=${vs.count -1 }">通过</a> <a
							href="DeleteTempStoreById?tempStoreId=${ts.tempStoreId }">忽略</a></td>
					</tr>
				</c:forEach>
			</table>
			<p align="center">
				每页${TempStoreInfo.pageSize }行 共${TempStoreInfo.totalRows }行
				页数${TempStoreInfo.curPage }/${TempStoreInfo.totalPages }<br>
				<c:choose>
					<c:when test="${TempStoreInfo.curPage == 1 }">首页 上一页</c:when>
					<c:otherwise>
						<a href="GetTempStore?page=1">首页</a>
						<a href="GetTempStore?page=${TempStoreInfo.curPage-1 }">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when
						test="${TempStoreInfo.curPage == TempStoreInfo.totalPages }">下一页 尾页</c:when>
					<c:otherwise>
						<a href="GetTempStore?page=${TempStoreInfo.curPage+1 }">下一页</a>
						<a href="GetTempStore?page=${TempStoreInfo.totalPages }">尾页</a>
					</c:otherwise>
				</c:choose>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>