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
<h2 align="center">Game Result</h2>
	<div align="center">
		<c:choose>
			<c:when test="${empty param.result }">
				<img src="img/nogoal.png">
			</c:when>
			<c:otherwise>
				<img src="img/goal.png">
			</c:otherwise>
		</c:choose>
		
		<br><br><a href="template.jsp?BODY=penaltyGame.jsp">재시도</a>
	</div>

</body>
</html>