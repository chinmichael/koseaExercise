<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test = "${not empty param.MSG}">
		<h2 align="center">구단등록에 성공했습니다</h2>
	</c:when>
	<c:otherwise>
		<h2 align="center">구단등록에 실패했습니다. 관리자에게 문의하세요</h2>
	</c:otherwise>
</c:choose>
</body>
</html>