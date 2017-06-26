<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href=".\css\shop.css">
<title>${StoreInfo.storeName }</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="head">
		<span>${StoreInfo.storeName }</span> <br>
		<div id="shopmessage">
			评分：<input type="text" name="author"
				value="${StoreInfo.storeEvaluate }" readonly="readonly"> 销量：<input
				type="text" name="author" value="${StoreInfo.storeSaleNum }"
				readonly="readonly"> 状态：<input type="text" name="author"
				value="${StoreInfo.storeState }" readonly="readonly">&nbsp;
			评论：<input type="text" name="author"
				value="${StoreInfo.storeComment }" readonly="readonly">
		</div>
		<div id="shopintro">
			店铺简介：
			<textarea rows="3" cols="40" readonly="readonly">${StoreInfo.storeDescript }</textarea>
		</div>
	</div>
	<div id="clear"></div>

	<div id="menu2">
		<a
			href="GetBookInfoByClass?storeName=${StoreInfo.storeName }&bookClass=计算机">计算机</a>
		<a
			href="GetBookInfoByClass?storeName=${StoreInfo.storeName }&bookClass=管理">管理</a>
		<a href="#">文学</a> <a href="#">外语</a> <a href="#">经管</a> <a href="#">励志</a>
		<a href="#">社科</a> <a href="#">学术</a>
	</div>
	<div id="clear"></div>
	<div id="search2">
		<form action="GetBookInfoByName" method="post">
			<input type="hidden" name="storeName" value="${StoreInfo.storeName }" />
			<input type="text" name="bookName" value="${SearchName }"><input
				type="submit" value="店内搜索">
		</form>
	</div>
	


	<div>
		<div id="booklist">
			<br>
			<c:if test="${BookInfo.data != null }">
				<%-- 搜索结果 --%>
				<hr>
				<h1>
					<a href="#">'${SearchName==null?SearchClass:SearchName }'查询结果：</a>
				</h1>
				<br>
				<c:forEach var="bb" items="${BookInfo.data }">
				<div class="book">
					<div class="bookimage">
						<a href="GetBookDetail?bookId=${bb.bookId }"><img alt=""
							src="./images/${bb.storeName }/${bb.bookImage }"></a>
					</div>
					<div class="bookIntr">
						<span>书名：${bb.bookName }</span><br> <span>售价：${bb.bookPrice }</span>
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
								<a href="GetBookInfoByClass?page=1&bookClass=${SearchClass }&storeName=${StoreInfo.storeName }">首页</a>
								<a
									href="GetBookInfoByClass?page=${BookInfo.curPage-1 }&bookClass=${SearchClass }&storeName=${StoreInfo.storeName }">上一页</a>
							</c:if>
							<c:if test="${SearchName != null }">
								<a href="GetBookInfoByName?page=1&bookName=${SearchName }&storeName=${StoreInfo.storeName }">首页</a>
								<a
									href="GetBookInfoByName?page=${BookInfo.curPage-1 }&bookName=${SearchName }&storeName=${StoreInfo.storeName }">上一页</a>
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${BookInfo.curPage == BookInfo.totalPages }">下一页 尾页</c:when>
						<c:otherwise>
							<c:if test="${SearchName == null }">
								<a
									href="GetBookInfoByClass?page=${BookInfo.curPage+1 }&bookClass=${SearchClass }&storeName=${StoreInfo.storeName }">下一页</a>
								<a
									href="GetBookInfoByClass?page=${BookInfo.totalPages }&bookClass=${SearchClass }&storeName=${StoreInfo.storeName }">尾页</a>
							</c:if>
							<c:if test="${SearchName != null }">
								<a
									href="GetBookInfoByName?page=${BookInfo.curPage+1 }&bookName=${SearchName }&storeName=${StoreInfo.storeName }">下一页</a>
								<a
									href="GetBookInfoByName?page=${BookInfo.totalPages }&bookName=${SearchName }&storeName=${StoreInfo.storeName }">尾页</a>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>
			<%-- 搜索结束 --%>
			
			
			<hr>
			<a href="">最近热销</a><br>
			<c:forEach var="bb" items="${StoreHotSale }">
				<div class="book">
					<div class="bookimage">
						<a href="GetBookDetail?bookId=${bb.bookId }"><img alt=""
							src="./images/${bb.storeName }/${bb.bookImage }"></a>
					</div>
					<div class="bookIntr">
						<span>书名：${bb.bookName }</span><br> <span>售价：${bb.bookPrice }</span>
					</div>
				</div>
			</c:forEach>

			<hr>
			<a href="">最近上新</a><br>
			<c:forEach var="bb" items="${StoreNewUpload }">
				<div class="book">
					<div class="bookimage">
						<a href="GetBookDetail?bookId=${bb.bookId }"> <img alt=""
							src="images/${bb.storeName }/${bb.bookImage }"></a>
					</div>
					<div class="bookIntr">
						<span>书名：${bb.bookName }</span><br> <span>售价：${bb.bookPrice }</span>
					</div>
				</div>
			</c:forEach>
			<hr>
		</div>
	</div>
	<div id="clear"></div>
	<jsp:include page="tail.jsp" />
</body>
</html>