<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
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
	<h2 align="center">用户查看</h2>
	<c:choose>
		<c:when test="${UserInfo.data == null }">暂无用户信息</c:when>
		<c:otherwise>

			<table align="center" width="800px">
				<tr>
					<th>用户名</th>
					<th>地址</th>
					<th>联系电话</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${UserInfo.data }">
					<tr>
						<td>${user.userName }</td>
						<td>${user.userAddr }</td>
						<td>${user.userPhone }</td>
						<td><a href="GetUserOrder?userName=${user.userName }">查看订单</a>
							<a
							href="DeleteUser?page=${UserInfo.curPage }&userName=${user.userName }"
							onclick="return confirm('确定要删除该用户吗？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<p align="center">
				每页${UserInfo.pageSize }行 共${UserInfo.totalRows }行
				页数${UserInfo.curPage }/${UserInfo.totalPages }<br>
				<c:choose>
					<c:when test="${UserInfo.curPage == 1 }">首页 上一页</c:when>
					<c:otherwise>
						<a href="GetAllUser?page=1">首页</a>
						<a href="GetAllUser?page=${UserInfo.curPage-1 }">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${UserInfo.curPage == UserInfo.totalPages }">下一页 尾页</c:when>
					<c:otherwise>
						<a href="GetAllUser?page=${UserInfo.curPage+1 }">下一页</a>
						<a href="GetAllUser?page=${UserInfo.totalPages }">尾页</a>
					</c:otherwise>
				</c:choose>
			</p>
		</c:otherwise>
	</c:choose>

</body>
</html>