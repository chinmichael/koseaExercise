<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test = "${empty param.loginMessage}">
		<h3 align = "center">로그인 되었습니다</h3>
	</c:when>
	<c:otherwise>
		<h3 align = "center">로그인 되지 않았습니다</h3>
		<h3 align = "center">${param.loginMessage }</h3>
	</c:otherwise>
</c:choose>
</body>
</html>