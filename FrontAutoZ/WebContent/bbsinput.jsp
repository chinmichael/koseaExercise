<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">게시판 글쓰기</h2>
<form action="bbsPost" method="post">
제목 : <input type = "text" name ="TITLE"><br><br>
<textarea rows = "5" cols="80" name = "content"></textarea><br>
<div align ="center">
<input type ="submit" value ="글 올리기">
<input type = "reset" value = "취 소">
</div>
</form>
</body>
</html>