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
		<c:when test = "${empty parma.RE }">
			<h3 align="center">게시글이 등록되었습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3 align="center">게시글이 등록되지 않았습니다<br>관리자에게 문의해주세요</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>