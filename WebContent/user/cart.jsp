<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link href="..\css\cart.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="..\js\jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="..\js\Calculation.js"></script>

<script type="text/javascript">
$(document).ready(function () {

	// 全选        
	$(".allselect").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			$(this).attr("checked", true);
		});
		GetCount();
	});

	//反选
	$("#invert").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			if ($(this).attr("checked")) {
				$(this).attr("checked", false);
			} else {
				$(this).attr("checked", true);
			} 
		});
		GetCount();
	});

	//取消
	$("#cancel").click(function () {
		$(".gwc_tb2 input[name=newslist]").each(function () {
			$(this).attr("checked", false);
		});
		GetCount();
	});

	// 输出
	$(".gwc_tb2 input[name=newslist]").click(function () {
		GetCount();	
	});
});
    //计算总价
function GetCount() {
	var conts = 0;
	var aa = 0;
	$(".gwc_tb2 input[name=newslist]").each(function () {
		if ($(this).attr("checked")) {
			for (var i = 0; i < $(this).length; i++) {
				conts += parseInt($(this).val());
				aa += 1;
			}
		}
	});
	$("#shuliang").text(aa);
	$("#zong1").html((conts).toFixed(2));
	$("#jz1").css("display", "none");
	$("#jz2").css("display", "block");
}


<!---总数---->
	$(function () {
		$(".quanxun").click(function () {
			setTotal();
			
		});
		function setTotal() {
			var len = $(".tot");
			var num = 0;
			for (var i = 0; i < len.length; i++) {
				num = parseInt(num) + parseInt($(len[i]).text());

			}
		
			$("#zong1").text(parseInt(num).toFixed(2));
			$("#shuliang").text(len.length);
		}
		
	})
	</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<!---针对每种商品加减算总数---->
	<script type="text/javascript">
	$(function () {
		var t = $("#text_box1");
		$("#add1").click(function () {
			t.val(parseInt(t.val()) + 1)
			setTotal(); GetCount();
		})
		$("#min1").click(function () {
			t.val(parseInt(t.val()) - 1)
			setTotal(); GetCount();
		})
		function setTotal() {

			$("#total1").html((parseInt(t.val()) * 9).toFixed(2));
			$("#newslist-1").val(parseInt(t.val()) * 9);
		}
		setTotal();
	})
	</script>




	<!-- 商品 -->
	<c:if test="${CartInfo == null }">
		<span>购物车空空如也</span>
	</c:if>
	<div class="gwc" style="margin: auto;">
		<c:if test="${CartInfo != null }">
			<table cellpadding="0" cellspacing="0" class="gwc_tb1">
				<tr>
					<td class="tb1_td1"><input type="checkbox" class="allselect" /></td>
					<td class="tb1_td1">全选</td>
					<td class="tb1_td3">商品</td>
					<td class="tb1_td4">单价</td>
					<td class="tb1_td5">数量</td>
					<td class="tb1_td6">合计</td>
					<td class="tb1_td7">操作</td>
				</tr>
			</table>
			<br>
			<table cellpadding="0" cellspacing="0" class="gwc_tb2">
				<c:forEach var="store" items="${StoreList }">
					<tr>
						<th><span>${store }</span></th>
					</tr>
					<c:forEach var="cart" items="${CartInfo[store] }">
						<tr>
							<td class="tb2_td1"><input type="checkbox" value="1"
								name="newslist" id="newslist-1" /></td>
							<td class="tb2_td2"><a href="#"><img
									src=".\bookcover\1.jpg" /></a></td>
							<td class="tb2_td3"><a href="#">产品名称</a></td>
							<td class="tb1_td4">单价</td>
							<td class="tb1_td5"><input id="min1" name=""
								style="width: 20px; height: 18px; border: 1px solid #ccc;"
								type="button" value="-" /> <input id="text_box1" name=""
								type="text" value="1"
								style="width: 30px; text-align: center; border: 1px solid #ccc;" />
								<input id="add1" name=""
								style="width: 20px; height: 18px; border: 1px solid #ccc;"
								type="button" value="+" /></td>
							<td class="tb1_td6"><label id="total1" class="tot"
								style="color: #ff5500; font-size: 14px; font-weight: bold;"></label></td>
							<td class="tb1_td7"><a href="#">删除</a></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
		</c:if>




		<table cellpadding="0" cellspacing="0" class="gwc_tb3">
			<tr>
				<td class="tb1_td1"><input id="checkAll" class="allselect"
					type="checkbox" /></td>
				<td class="tb1_td1">全选</td>
				<td class="tb3_td1"><input id="invert" type="checkbox" />反选 <input
					id="cancel" type="checkbox" />取消</td>
				<td class="tb3_td2">已选商品 <label id="shuliang"
					style="color: #ff5500; font-size: 14px; font-weight: bold;">0</label>
					件
				</td>
				<td class="tb3_td3">合计(不含运费):<span>￥</span><span
					style="color: #ff5500;"><label id="zong1"
						style="color: #ff5500; font-size: 14px; font-weight: bold;"></label></span></td>
				<td class="tb3_td4"><span id="jz1">结算</span><a href="#"
					style="display: none;" class="jz2" id="jz2">结算</a></td>
			</tr>
		</table>

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%-- 	<jsp:include page="tail.jsp"></jsp:include> --%>
</body>
</html>