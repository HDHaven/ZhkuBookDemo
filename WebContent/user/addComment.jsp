<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\ordercomment.css">

<title>订单评价</title>
</head>
<body>
	<div id="goodsimage">
		<img src="../images/${param.storeName }/${param.bookImage }">
	</div>
	<form action="AddComment" method="post">
		<div id="goodsintro">
			&nbsp;&nbsp;
			<h2>${param.bookName }</h2>
			<input type="hidden" name="bookName" value="${param.bookName }"/>
			<input type="hidden" name="storeName" value="${param.storeName }"/>
			<br> <br> <br> <br> &nbsp;&nbsp;价格：<span>${param.bookPrice }</span><br>
			<br> &nbsp;&nbsp;总体评价：<span> <input type="radio"
				name="commentScore" value="5" checked>5&nbsp; <input
				type="radio" name="commentScore" value="4" checked>4&nbsp; <input
				type="radio" name="commentScore" value="3" checked>3&nbsp; <input
				type="radio" name="commentScore" value="2" checked>2&nbsp; <input
				type="radio" name="commentScore" value="1" checked>1&nbsp;
			</span><br>
		</div>
		<div id="clear"></div>
		<div id="comment">
			<br> <br> <span>其他买家需要你的建议哦！</span>
			<div id="clear"></div>
			使用感受：
			<textarea rows="6" cols="90" name="commentContent"></textarea>
			<br> <br> &nbsp; &nbsp; &nbsp;<input type="submit"
				value="提交">
		</div>
	</form>
</body>
</html>