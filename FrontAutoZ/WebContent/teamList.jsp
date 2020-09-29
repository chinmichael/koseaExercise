<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table.team_main{
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
<h2>구단 목록</h2>
<c:choose>
<c:when test = "${empty TEAM }">
	<h3>등록된 구단이 존재하지 않습니다.</h3>
</c:when>

<c:otherwise>
	<table class = "team_main">
		<tr>
			<th width = "10%">구단번호</th><th width="20%">구단주</th><th width="50%">구단명</th><th width="20%">창단일</th>
		</tr>
		<c:forEach var = "team" items = "${TEAM }">
			<tr>
				<td>${team.getId() }</td>
				<td>${team.getOwner() }</td>
				<td><a href = "teamRead?=${team.getId() }">${team.getName() }</a></td>
				<td>${team.getBirth() }</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach begin="1" end="${PAGE }" var="page">
		<a href = "bbsList.do?PAGENO=${page }">${page }</a>
	</c:forEach>
	
</c:otherwise>
</c:choose>

</body>
</html>