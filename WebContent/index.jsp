<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>仲有书(ZhkuBook.com)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="content">
		<div id="content_bottom">
			<div id="product_top">
				<img alt="" src="images/productlist.gif">
			</div>
			<c:if test="${BookInfo.data != null }">
				<%-- 搜索结果 --%>
				<hr>
				<h1>
					<a href="#">'${SearchName==null?SearchClass:SearchName }'查询结果：</a>
				</h1>
				<br>
				<c:forEach var="book" items="${BookInfo.data }">
					<div class="booklist">
						<div class="book">
							<a href="GetBookDetail?bookId=${book.bookId }"> <img alt=""
								src="images/${book.storeName }/${book.bookImage }"></a>
						</div>
						<div class="bookIntr">
							<span>书名：<c:out value="${book.bookName }" /></span><br> <span>售价：${book.bookPrice }</span>
						</div>
					</div>
				</c:forEach>
				<div class="clear"></div>
				<div id="jumpPage">
					每页${BookInfo.pageSize }行 共${BookInfo.totalRows }行
					页数${BookInfo.curPage }/${BookInfo.totalPages }<br>
					<c:choose>
						<c:when test="${BookInfo.curPage == 1 }">首页 上一页</c:when>
						<c:otherwise>
							<c:if test="${SearchName == null }">
								<a href="GetBookInfoByClass?page=1&bookClass=${SearchClass }">首页</a>
								<a
									href="GetBookInfoByClass?page=${BookInfo.curPage-1 }&bookClass=${SearchClass }">上一页</a>
							</c:if>
							<c:if test="${SearchName != null }">
								<a href="GetBookInfoByName?page=1&bookName=${SearchName }">首页</a>
								<a
									href="GetBookInfoByName?page=${BookInfo.curPage-1 }&bookName=${SearchName }">上一页</a>
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BookInfo.curPage == BookInfo.totalPages }">下一页 尾页</c:when>
						<c:otherwise>
							<c:if test="${SearchName == null }">
								<a
									href="GetBookInfoByClass?page=${BookInfo.curPage+1 }&bookClass=${SearchClass }">下一页</a>
								<a
									href="GetBookInfoByClass?page=${BookInfo.totalPages }&bookClass=${SearchClass }">尾页</a>
							</c:if>
							<c:if test="${SearchName != null }">
								<a
									href="GetBookInfoByName?page=${BookInfo.curPage+1 }&bookName=${SearchName }">下一页</a>
								<a
									href="GetBookInfoByName?page=${BookInfo.totalPages }&bookName=${SearchName }">尾页</a>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>
			<%-- 最近热销 --%>
			<hr>
			<h1>
				<a href="#">最近热销</a>
			</h1>
			<div id="product_bottom">
				<c:forEach var="book" items="${HotSale }">
					<div class="booklist">
						<div class="book">
							<a href="GetBookDetail?bookId=${book.bookId }"> <img alt=""
								src="images/${book.storeName }/${book.bookImage }"></a>
						</div>
						<div class="bookIntr">
							<span>书名：${book.bookName }</span><br> <span>售价：${book.bookPrice }</span>
						</div>
					</div>
				</c:forEach>
				<%-- 最新上架 --%>
				<hr>
				<h1>
					<a href="#">最新上架</a>
				</h1>
				<br>
				<c:forEach var="book" items="${NewUpload }">
					<div class="booklist">
						<div class="book">
							<a href="GetBookDetail?bookId=${book.bookId }"> <img alt=""
								src="images/${book.storeName }/${book.bookImage }"></a>
						</div>
						<div class="bookIntr">
							<span>书名：${book.bookName }</span><br> <span>售价：${book.bookPrice }</span>
						</div>
					</div>
				</c:forEach>

				<hr>
			</div>
		</div>
	</div>
	<jsp:include page="tail.jsp" />
</body>
</html>