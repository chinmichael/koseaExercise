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
	<c:when test = "${empty param.loginMessage }">
		<script type="text/javascript">
			self.close();
			opener.window.location.reload();
		</script>
	</c:when>
	<c:otherwise>
		<h3 align="center">${param.loginMessage}</h3>
	</c:otherwise>
</c:choose>
</body>
</html>