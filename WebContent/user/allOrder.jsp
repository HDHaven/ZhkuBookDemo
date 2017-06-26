<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\allorder.css">
<script type="text/javascript" src="..\js\jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="..\js\jquery.reveal.js"></script>

<title>${LoginUser }的所有订单</title>
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
			<a href="GetOrderInfo"><span
				style="color: red; font-weight: bold">全部订单</span></a> <a
				href="GetOrderInfo?orderState=待处理">待处理</a> <a
				href="GetOrderInfo?orderState=正在配送">正在配送</a> <a
				href="GetOrderInfo?orderState=已完成">已完成</a> <a
				href="GetOrderInfo?orderState=已取消">已取消</a> <a
				href="GetOrderInfo?orderState=待审核">待审核</a>
		</div>

		<div id="orderhead">
			<table class="tb1">
				<tr>
					<td class="tb1_id">订单号</td>
					<td class="tb1_date">日期</td>
					<td class="tb1_totalprice">成交价</td>
					<td class="tb1_detile">订单详情</td>
				</tr>
			</table>

		</div>
		<div id="orderdetile">
			<table class="tb2">
				<c:forEach var="order" items="${OrderInfo.data }">
					<tr><td colspan="4"><hr></td></tr>
					<tr>
						<td class="tb1_id">${order.orderId }</td>
						<td class="tb1_date">${order.orderDate }</td>
						<td class="tb1_totalprice">${order.orderPrice }￥</td>
						<td class="tb1_detile"><a target="_blank"
							href="GetOrderProducts?orderId=${order.orderId }">详情</a></td>
					</tr>
				</c:forEach>
			</table>
			<p align="center">
				每页${OrderInfo.pageSize }行 共${OrderInfo.totalRows }行
				页数${OrderInfo.curPage }/${OrderInfo.totalPages }<br>
				<c:choose>
					<c:when test="${OrderInfo.curPage == 1 }">首页 上一页</c:when>
					<c:otherwise>
						<a href="GetOrder?page=1">首页</a>
						<a href="GetOrder?page=${OrderInfo.curPage-1 }">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${OrderInfo.curPage == OrderInfo.totalPages }">下一页 尾页</c:when>
					<c:otherwise>
						<a href="GetOrder?page=${OrderInfo.curPage+1 }">下一页</a>
						<a href="GetOrder?page=${OrderInfo.totalPages }">尾页</a>
					</c:otherwise>
				</c:choose>
			</p>
		</div>
	</div>
</body>
</html>