<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="contentType" content="text/html; charset=utf-8">
<title>添加图书</title>
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
	<h2 align="center">添加图书</h2>
	<form action="AddBook" method="post" enctype="multipart/form-data">
		<table align="center" width="650px">
			<tr>
				<th>图书名称:</th>
				<td><input type="text" name="bookName"></td>
				<th>图书ISBN号:</th>
				<td><input type="text" name="bookISBN"></td>
			</tr>
			<tr>
				<th>图书作者:</th>
				<td><input type="text" name="bookAuthor"></td>
				<th>图书出版社:</th>
				<td><input type="text" name="bookPublisher"></td>
			</tr>
			<tr>
				<th>图书类别:</th>
				<td><input type="text" name="bookClass"></td>
				<th>图书总页数:</th>
				<td><input type="text" name="bookPage"></td>
			</tr>
			<tr>
				<th>图书价格:</th>
				<td><input type="text" name="bookPrice"></td>
				<th>图书库存量:</th>
				<td><input type="text" name="bookSumNum"></td>
			</tr>
			<tr>
				<th>图书简介:</th>
				<td colspan="3"><textarea rows="6" cols="67"
						name="bookDescript"></textarea></td>
			</tr>
			<tr>
				<th>图书封面:</th>
				<td colspan="3"><input type="file" name="file"
					value="上传图片.."></td>
			</tr>
		</table>
		<center>
			<input type="submit" value="添加"> <input type="reset"
				value="重置">
		</center>
	</form>
</body>
</html>