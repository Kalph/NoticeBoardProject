<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String msg = (String) request.getAttribute("msg");
%>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h2 align="center"><%=msg%></h2>
	<div align="center">
		<button onclick="location.href='<%=request.getContextPath()%>'" style="width:100px">홈으로</button>
	</div>
</body>
</html>