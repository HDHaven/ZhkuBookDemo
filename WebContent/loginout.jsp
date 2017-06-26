<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" %>
<%
	// 注销session对象，返回首页
	session.invalidate();
	response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/index.jsp");
%>