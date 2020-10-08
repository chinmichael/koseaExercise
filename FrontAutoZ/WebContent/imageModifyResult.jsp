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
	<c:when test = "${not empty param.seqno }">
		<script type ="text/javascript">
			alert("수정이 성공적으로 완료되었습니다");
			location.href="imageList?seqno=" + ${param.seqno};
		</script>
	</c:when>
	<c:otherwise>
		<script type ="text/javascript">
			alert("게시글 수정에 실패했습니다. 관리자에게 문의해주세요.");
			location.href="imageRead?id="+${param.id};
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>