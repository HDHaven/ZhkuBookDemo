<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="contentType" content="text/html; charset=utf-8">
<title>${LoginUser }的店铺</title>
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
</style>
</head>
<body>
	<h2>店铺信息</h2>
	<table width="600px">
		<tr>
			<th>店铺名称</th>
			<td>${StoreInfo.storeName }</td>
			<th>店铺评分</th>
			<td>${StoreInfo.storeEvaluate }</td>
		</tr>
		<tr>
			<th>销售总本数</th>
			<td>${StoreInfo.storeSaleNum }</td>
			<th>销售总金额</th>
			<td>${StoreInfo.storeSale }</td>
		</tr>
		<tr>
			<th>店铺总评论数</th>
			<td>${StoreInfo.storeComment }</td>
			<th>店铺状态</th>
			<td>${StoreInfo.storeState }</td>
		</tr>
		<tr>
			<th>营业执照</th>
			<td colspan="3"><a href="../images/licenses/${StoreInfo.storeLicense }"
				target="_blank">点击查看</a></td>
		</tr>
		<tr>
			<th>店铺简介</th>
			<td height="150px" colspan="3">${StoreInfo.storeDescript }</td>
		</tr>
	</table>
</body>
</html>