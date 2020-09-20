<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style class = "text/css">
body {
	height: 100%;
}

table.main {
	width: 90%;
	height: 80%;
	border: 1px solid blue;
	border-collapse:collapse;
	margin-left:20px;
	margin-right:20px;
}
td.main{
	border:1px solid blue;
}
#login {
	width:80%;
	border:1px dashed grey;
	padding:10px;
	margin-top:10px;
	margin-left:10px;
}
#menu{
	margin-top:10px;
	margin-left:20px;	
}
#content{
	background-color:orange;
}
a:hover{
	background-color:yellow;
}
td.main{
	background-color:lime;
}
</style>
</head>
<body>
<h2 align="center"><img alt="" src ="img/logo.gif"></h2>
<table class = "main" width = "100%">
<tr>
	<td class = "main" width="20%" height="300" valign="top">
		<div id = "login">
			<c:choose>
				<c:when test ="${empty sessionScope.LOGIN }">
					<jsp:include page ="login.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page ="logout.jsp"/>
				</c:otherwise>
			</c:choose>
		</div><br/>
		<div id = "menus">
			<a href="template.jsp?BODY=intro.jsp">소개</a><br/>
			<a href="template.jsp?BODY=bbsinput.jsp">게시글 쓰기</a><br/>
			<a href="">게시글 목록</a><br/>
			<a href="">상품 등록</a><br/>
			<a href="">상품 목록</a><br/>
			<a href="">장바구니 보기</a><br/>
			<a href="">답글 및 이미지 게시판</a><br/>
			<a href="">이미지 게시판 목록</a>
		</div>
	</td>
	<td id = "content">
		<jsp:include page="${param.BODY }" />
	</td>
</tr>
</table>
<h3 align = "center">CopyLeft 2020. FrontAtoZ</h3>
</body>
</html>