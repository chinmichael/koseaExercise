<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table.bbs_main{
	border : 1px solid blue;
	width : 90%;
	border-collapse: collapse;
}

th {
   border: 1px solid blue;
}

td {
   border: 1px solid red;
}
</style>
</head>
<body>
<div align = "center">
<h2>게시글 목록</h2>
<c:choose>
<c:when test = "${empty LIST }">
	<h3>등록된 게시글이 존재하지 않습니다.</h3>
</c:when>

<c:otherwise>
	<table class = "bbs_main">
		<tr>
			<th width = "10%">글번호</th><th width="20%">작성자</th><th width="50%">글제목</th><th width="20%">작성일</th>
		</tr>
		<c:forEach var = "bbs" items = "${LIST }">
			<tr>
				<td>${bbs.seqno }</td>
				<td>${bbs.userid }</td>
				<td><a href = "bbsRead?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
				<td>${bbs.bbs_date }</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href = "bbsList.do?PAGENO=${page }">${page }</a>
	</c:forEach>
	
</c:otherwise>
</c:choose>
</div>

<script type = "text/javascript">
	if('${RESULT}' == "Insert") {
		alert("게시글이 등록되었습니다.");
	} else if('${RESULT}' == "Error") {
		alert("게시글이 등록되지 않았습니다 관리자에게 문의해주세요");
	}
</script>

</body>
</html>