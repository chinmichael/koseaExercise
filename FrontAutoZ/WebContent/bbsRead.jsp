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
<div align = "center">
<h2>게시글 읽기</h2>
[글번호] : ${BBS.seqno }<br>
[글제목] : ${BBS.title }<br>
[글작성자] : ${BBS.userid }, [작성일] : ${BBS.bbs_date }<br>

<table width = "80%">
	<tr><td>${BBS.content }</td></tr>
</table>
</div>
</body>
</html>