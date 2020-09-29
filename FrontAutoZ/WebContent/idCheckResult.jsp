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
	<h2 align = "center">아이디 중복 확인</h2>
	<form action="idCheck.do" name = "frm">
		아이디 : <input type = "text" name = "ID" value = "${ID }">
		<input type = "submit" value = "중복검사">
	</form> <br>
	
	<c:choose>
		<c:when test = "${empty checkMessage }">
			<h2 style = "display:inline;">사용가능한 아이디입니다.</h2>
			<input type = "button" value = "사용" onClick="idOK()">
		</c:when>
		<c:otherwise>
			<h2>중복되는 아이디가 있습니다.</h2>
			<script type="text/javascript">
				opener.document.joinFrm.ID.value = '';
				opener.document.joinFrm.IDCHK.value = '';
			</script>
		</c:otherwise>
	</c:choose>
	<script type = "text/javascript">
		function idOK () {
			opener.document.joinFrm.ID.value = document.frm.ID.value;
			opener.document.joinFrm.IDCHK.value = document.frm.ID.value;
			self.close();
		}
	</script>
</body>
</html>