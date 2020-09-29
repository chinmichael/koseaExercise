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
	<h2 align = "center">상품중복 확인</h2>
	<form action="codeCheck.do" name="frm">
		상품코드 : <input type="text" name="CODE" value="${CODE }">
		<input type = "submit" value = "중복검사">
	</form> <br>
	<c:choose>
		<c:when test = "${not empty itemMessage }">
			입력가능한 상품코드입니다.
			<input type = "button" value = "사용" onclick = "useCode()">
		</c:when>
		<c:otherwise>
			이미 등록된 상품코드입니다.
			<script type = "text/javascript">
				opener.document.register.CODE.value = '';
				opener.document.register.codeChecked.value = '';
				
			</script>
		</c:otherwise>
	</c:choose>
	
	<script type = "text/javascript">
		function useCode() {
			opener.document.register.CODE.value = document.frm.CODE.value;
			opener.document.register.codeChecked.value = document.frm.CODE.value;

			self.close();
		}
	</script>
</body>
</html>