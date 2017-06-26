<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href=".\css\allHead.css">
<link type="text/css" rel="stylesheet" href=".\css\book.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="content">
		<div id="bookimage">
			<img alt=""
				src="images/${BookDetail.storeName }/${BookDetail.bookImage }">
		</div>

		<div id="bookdetile">
			<h2>${BookDetail.bookName }</h2>

			<div id="bookabstract">
				<textarea rows="5" cols="80" readonly="readonly">${BookDetail.bookDescript }</textarea>
				作者：<span>${BookDetail.bookAuthor }</span>&nbsp; 出版社：<span>${BookDetail.bookPublisher }</span>
				&nbsp; 总页数：<span>${BookDetail.bookPage }</span><br> 销量：<span>${BookDetail.bookSaleNum }</span>&nbsp;
				ISBN：<span>${BookDetail.bookISBN }</span>
			</div>

			<div id="bookprice">
				抢购价(￥)：${BookDetail.bookPrice }
			</div>

			<a href="user/AddCart"><img alt="" src=".\images\addProduce.GIF"></a>
			&nbsp;&nbsp;&nbsp; <a href="#"><img alt="" src=".\images\buy.GIF"></a>
		</div>

		<div id="bookrightmessage">
			<img alt="" src=".\images\shop.jpg"> &nbsp;&nbsp;商店：<input
				type="text" name="shopname" value="${BookDetail.storeName }"
				readonly="readonly">
			<hr>
			<img alt="" src=".\images\shoppromise.GIF"> <br> <br>
			&nbsp;&nbsp;&nbsp;<a href="EnterStores?storeName=${BookDetail.storeName }">进入店铺</a>&nbsp;&nbsp;<a
				href="#">收藏店铺</a>
		</div>
	</div>

	<div id="clear"></div>

	<div id="comment">
		<h2 align="left">图书评价</h2>
		<br>
		<c:forEach var="comment" items="${BookComment.data }">
			<hr><br>
			<div id="commentdetil">
				<textarea rows="4" cols="120" disabled="disabled"
					name="commentdetil">${comment.commentContent }</textarea>
				<div id="commentdetilperson">
					<br> 评论人：<span>${comment.userName }</span> <br> 评分：<span>${comment.commentScore }</span>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>