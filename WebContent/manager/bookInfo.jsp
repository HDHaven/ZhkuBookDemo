<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="contentType" content="text/html; charset=utf-8">
<title>Insert title here</title>
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


a {
	font-size: 15px;
	color: #06F;
	text-decoration: none;
}

a:HOVER {
	color: #909;
}
</style>
</head>
<body>
	<h2>图书信息列表</h2>
	<form action="GetBookByName" method="post">
		书名：<input type="text" name="bookName" value="${BookName }"/><input type="submit" value="查询">
	</form>
	<hr>
	<c:if test="${BookInfo.data == null }">暂无图书信息</c:if>
	<c:if test="${BookInfo.data != null }">
	<table>
		<tr>
			<th>书名</th>
			<th>ISBN</th>
			<th>作者</th>
			<th>出版社</th>
			<th>销量</th>
			<th>价格</th>
			<th>库存量</th>
			<th>操作</th>
		</tr>
		<c:forEach var="book" items="${BookInfo.data }">
			
		<tr>
			<td>${book.bookName }</td>
			<td>${book.bookISBN }</td>
			<td>${book.bookAuthor }</td>
			<td>${book.bookPublisher }</td>
			<td>${book.bookSaleNum }</td>
			<td>
			<form action="UpdateBook" method="post">
				<input type="hidden" name="bookId" value="${book.bookId }"/>
				<input type="hidden" name="page" value="${BookInfo.curPage }"/>
				<input size="1px" type="text" name="bookPrice" value="${book.bookPrice }"/>
				<input type="submit" value="[修改]"/>
			</form>
			</td>
			<td>
			<form action="UpdateBook" method="post">
				<input type="hidden" name="bookId" value="${book.bookId }"/>
				<input type="hidden" name="page" value="${BookInfo.curPage }"/>
				<input size="1px" type="text" name="bookSumNum" value="${book.bookSumNum }"/>
				<input type="submit" value="[修改]"/>
			</form>
			</td>
			<td>
				<a target="_blank" href="../images/${StoreName }/${book.bookImage }">封面</a>
				<a href="DeleteBook?bookId=${book.bookId }&page=${BookInfo.curPage }" onclick="return confirm('确定要删除该图书？')">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		每页${BookInfo.pageSize }行 共${BookInfo.totalRows }行
		页数${BookInfo.curPage }/${BookInfo.totalPages }<br>
		<c:choose>
			<c:when test="${BookInfo.curPage == 1 }">首页 上一页</c:when>
			<c:otherwise>
				<c:if test="${BookName == null }">
				<a href="GetBook?page=1&${StoreName }">首页</a>
				<a href="GetBook?page=${BookInfo.curPage-1 }">上一页</a>
				</c:if>
				<c:if test="${BookName != null }">
				<a href="GetBookByName?page=1&bookName=${BookName }">首页</a>
				<a href="GetBookByName?page=${BookInfo.curPage-1 }&bookName=${BookName }">上一页</a>
				</c:if>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${BookInfo.curPage == BookInfo.totalPages }">下一页 尾页</c:when>
			<c:otherwise>
				<c:if test="${BookName == null }">
				<a href="GetBook?page=${BookInfo.curPage+1 }">下一页</a>
				<a href="GetBook?page=${BookInfo.totalPages }">尾页</a>
				</c:if>
				<c:if test="${BookName != null }">
				<a href="GetBookByName?page=${BookInfo.curPage+1 }&bookName=${BookName }">下一页</a>
				<a href="GetBook?page=${BookInfo.totalPages }&bookName=${BookName }">尾页</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</p>
	</c:if>
</body>
</html>