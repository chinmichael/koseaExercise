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
<h2 align="center">게시판 글쓰기</h2>
<form action="bbsPost" method="post" onSubmit="return validate(this)">
제목 : <input type = "text" name ="TITLE"><br><br>
<textarea rows = "5" cols="80" name = "CONTENT"></textarea><br>
<div align ="center">
<input type ="submit" value ="글 올리기">
<input type = "reset" value = "취 소">
</div>
</form>

<script type = "text/javascript">
	function validate(frm) {
		
		if(frm.TITLE.value == '') {
			alert("제목을 입력하세요");
			return false;
		}
		if(frm.CONTENT.value == '') {
			alert("글 내용을 입력하세요");
			return false;
		}
		var r = confirm("글 올리겠습니까");
		if(r == false) return false;
	}
</script>
</body>
</html>