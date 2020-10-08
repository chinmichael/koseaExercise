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
	<c:when test = "${not empty param.message }">
		<script type = "text/javascript">
			alert("성공적으로 업로드되었습니다");
		</script>
	</c:when>
	<c:otherwise>
		<script type = "text/javascript">
			alert("업로드에 실패햇습니다");
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>