<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\personal.css">
<script type="text/javascript" src="..\js\jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="..\js\jquery.reveal.js"></script>

<title>已完成订单</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="personaldetil">
		<div id="title">
			<span>个人中心</span>
		</div>
		<div id="clear"></div>
		<div id="catalog">
			<a href="GetOrderInfo"><b>我的订单</b></a> <a href="GetAddr">修改地址</a> <a
				href="updatePassword.jsp">修改密码</a>
			<c:if test="${ManagerUser != null }">
				<a href="../manager/EnterStore">我的店铺</a>
			</c:if>
			<c:if test="${ManagerUser == null }">
				<a href="applyStore.jsp">申请开店铺</a>
			</c:if>
		</div>
		<img alt="" src="..\images\myadvertise.GIF">
		<div id="order">
			<a href="GetOrderInfo">全部订单</a> <a href="GetOrderInfo?orderState=待处理">待处理</a> <a
				href="GetOrderInfo?orderState=正在配送">正在配送</a> <a
				href="GetOrderInfo?orderState=已完成"><span
				style="color: red; font-weight: bold">已完成</span></a> <a
				href="GetOrderInfo?orderState=已取消">已取消</a> <a
				href="GetOrderInfo?orderState=待审核">待审核</a>
		</div>

		<div id="orderhead">
			<table class="tb1">
				<tr>
					<td class="tb1_td1">商品</td>
					<td class="tb1_td2">单价</td>
					<td class="tb1_td3">数量</td>
					<td class="tb1_td6">店铺</td>
					<td class="tb1_td6">订单详情</td>
				</tr>
		<c:if test="${OrderInfo.data == null }">
			<tr><td><h4 align="center">该类订单为空</h4><td></tr>
		</c:if>
			</table>
		</div>
		<c:if test="${OrderInfo.data != null }">
			<div id="orderdetile">
				<table class="tb2">
					<c:forEach var="pro" items="${OrderInfo.data }">
						<tr>
							<td class="tb2_td1"><a href="#"><img
									src="../images/${pro.storeName }/${pro.bookImage }" /></a></td>
							<td class="tb2_td2"><a href="#">${pro.bookName }</a></td>
							<td class="tb1_td2">${pro.bookPrice }</td>
							<td class="tb1_td3">${pro.bookNumber }</td>
							<td class="tb1_td6">${pro.storeName }</td>
							<td class="tb1_td6">
								<a href="GetOrderDetailss?orderId=${pro.orderId }">详情</a>
								<a target="_blank" href="addComment.jsp?storeName=${pro.storeName }&bookName=${pro.bookName }&bookImage=${pro.bookImage }&bookPrice=${pro.bookPrice }">去评价</a>									
							</td>
						</tr>
					</c:forEach>
				</table>
				<p align="center">
					每页${OrderInfo.pageSize }行 共${OrderInfo.totalRows }行
					页数${OrderInfo.curPage }/${OrderInfo.totalPages }<br>
					<c:choose>
						<c:when test="${OrderInfo.curPage == 1 }">首页 上一页</c:when>
						<c:otherwise>
							<a href="GetOrderByState?page=1&orderState=已完成">首页</a>
							<a
								href="GetOrderByState?page=${OrderInfo.curPage-1 }&orderState=已完成">上一页</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${OrderInfo.curPage == OrderInfo.totalPages }">下一页 尾页</c:when>
						<c:otherwise>
							<a href="GetOrder?page=${OrderInfo.curPage+1 }&orderState=已完成">下一页</a>
							<a href="GetOrder?page=${OrderInfo.totalPages }&orderState=已完成">尾页</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</c:if>
	</div>
</body>
</html>