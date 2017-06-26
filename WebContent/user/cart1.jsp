<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\cart4.css">
<title>${LoginUser }的购物车</title>
<script type="text/javascript">
	function getTotal() {
		var buys = document.getElementsByName("buy");
		var prices = document.getElementsByName("price");
		var total = 0;
		for (var i = 0; i < buys.length; i++) {
			if (buys[i].checked) {
				total += parseFloat(prices[i].innerHTML);
				document.getElementById(buys[i].value).value = "true";
			} else {
				document.getElementById(buys[i].value).value = "false";
			}
		}
		document.getElementById("sumPrice").innerHTML = total;
		document.getElementById("sum").value = total;
	}
	// 检测输入
	function check() {
// 				document.getElementByName("sumPrice").value = document
// 						.getElementById("sumPrice").innerHTML;
		var buys = document.getElementsByName("buy");
		var flag = false;
		for (var i = 0; i < buys.length; i++) {
			if (buys[i].checked) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请选择要购买的商品");
		}
		return flag;
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<%-- 购物车为空 --%>
	<c:if test="${CartInfo == null }">
		<h3 align="center">购物车空空如也</h3>
	</c:if>
	<!-- 购物车不为空，显示 -->
	<c:if test="${CartInfo != null }">
		<form action="GenerateOrder" method="post">

			<table class="cart" cellspacing="0">
				<tr class="tablehead">
					<td class="other"><input type="checkbox"
						onclick="selectAll();" />全选</td>
					<td class="product">商品</td>
					<td class="product"></td>
					<td class="other">单价</td>
					<td class="other">数量</td>
					<td class="other">合计</td>
					<td class="other">操作</td>
				</tr>
				<c:forEach var="store" items="${StoreList }">
					<tr></tr>
					<tr>
						<th colspan="6" align="left">${store }</th>
					</tr>
					<c:forEach var="cart" items="${CartInfo[store] }">
						
						<tr class="tablecenter">
							<td class="other" align="center"><input type="checkbox" name="buy"
								value="${cart.cartId }" onclick="getTotal();" /> <input
								type="hidden" id="${cart.cartId }" name="${cart.cartId }" /></td>
							<td class="product"><a href="GetBookDetails?storeName=${cart.storeName }&bookName=${cart.bookName }"><img
								src="../images/${cart.storeName }/${cart.bookImage }"></a></td>
							<td class="product">${cart.bookName }</td>
							<td class="other">${cart.bookPrice }</td>
							<td class="other"><a
								href="UpdateCart?cartId=${cart.cartId }&bookNumber=${cart.bookNumber-1 }"
								class="jian"> </a>${cart.bookNumber }<a class="jia"
								href="UpdateCart?cartId=${cart.cartId }&bookNumber=${cart.bookNumber+1 }"></a></td>
							<td class="other"><b name="price">${Integer.parseInt(cart.bookPrice) * Integer.parseInt(cart.bookNumber) }</b></td>
							<td class="other"><a
								href="DeleteFromCart?cartId=${cart.cartId }"
								onclick="return confirm('确定要删除该商品吗？')">删除</a></td>
						</tr>
					</c:forEach>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td align="right" colspan="3" class="price">总价：<b
						id="sumPrice"></b>元
						<input type="hidden" name="sumPrice" id="sum"/>

					</td>
					<td align="center"><input type="submit" value="结算"
						style="color: red; font-size: 20px" onclick="return check();" /></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>