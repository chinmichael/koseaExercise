<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table.item_main{
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
<h2>상품 목록</h2>
<c:choose>
<c:when test = "${empty ITEM }">
	<h3>등록된 상품이 존재하지 않습니다.</h3>
</c:when>

<c:otherwise>
	<table class = "item_main">
		<tr>
			<th width = "10%">상품번호</th><th width="40%">상품이름</th><th width="10%">상품가격</th><th width="20%">원산지</th><th></th>
		</tr>
		<c:forEach var = "item" items = "${ITEM }">
			<tr>
				<td>${item.getCode() }</td>
				<td><a href = "itemRead?code=${item.getCode() }">${item.getName() }</a></td>
				<td><fmt:formatNumber groupingUsed="true">${item.getPrice() }</fmt:formatNumber></td>
				<td>${item.getOrigin() }</td>
				<td><a href="#" onclick="window.open('addCart?CODE=${item.getCode()}','cart','width-400,height=350').focus()">장바구니 담기</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div align="center">
	<c:forEach begin="1" end="${PAGE }" var="page">
		<a href = "itemList?PAGE=${page }">${page }</a>
	</c:forEach>
	</div>
</c:otherwise>
</c:choose>

</body>
</html>