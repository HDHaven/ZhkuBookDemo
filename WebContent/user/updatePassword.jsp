<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="..\css\allHead.css">
<link type="text/css" rel="stylesheet" href="..\css\personal.css">
<link type="text/css" rel="stylesheet" href="..\css\editaddress.css">
<link type="text/css" rel="stylesheet" href="..\css\editpassword.css">
<title>修改密码</title>
<script type="text/javascript">
	function check() {
		if (f.password.value == "") {
			alert("原密码不能为空");
			return false;
		} else if (f.newPassword.value == ""
				|| f.newPassword.value != f.renewpassword.value) {
			alert("密码为空或者两次密码不相同");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="personaldetil">
		<div id="title">
			<span>个人中心</span>
		</div>
		<div id="clear"></div>
		<div id="catalog">
			<a href="GetOrderInfo">我的订单</a> <a href="GetAddr">修改地址</a> <a
				href="updatePassword.jsp"><b>修改密码</b></a>
			<c:if test="${ManagerUser != null }">
				<a href="../manager/EnterStore">我的店铺</a>
			</c:if>
			<c:if test="${ManagerUser == null }">
				<a href="applyStore.jsp">申请开店铺</a>
			</c:if>
		</div>
		<img alt="" src="..\images\myadvertise.GIF">

		<div id="editpassword">
			<form action="UpdatePassword" method="post" name="f"
				onSubmit="return check()">
				<table>
					<tr>
						<th>原密码:</th>
						<td><input type="password" value="" name="password"></td>
					</tr>
					<tr>
						<th>新密码:</th>
						<td><input type="password" value="" name="newPassword"></td>
					</tr>
					<tr>
						<th>确认新密码:</th>
						<td><input type="password" value="" name="renewpassword"></td>
					</tr>
					<tr>
						<td></td>
						<td align="left"><input type="submit" value="提交">&nbsp;<input
							type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>