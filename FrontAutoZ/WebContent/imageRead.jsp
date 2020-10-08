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
	<c:when test = "${empty result }">
		존재하지 않는 글입니다.
	</c:when>
	<c:otherwise>
		<table border="1" width="100%" align="center">
			<tr><td>글제목</td><td>${result.title }</td></tr>
			<tr><td>작성자</td><td>${result.writer_name }</td></tr>
			<tr><td colspan="2"><img alt="" src="upload/${result.image_name }" width="350" height="350"></td></tr>
			<tr><td>글내용</td><td>${result.content }</td></tr>
			<tr><td colspan="2">
				<a href="javascript:goReply()">[답글]</a><a href="javascript:goModify()">[수정]</a><a href="javascript:goDelete()">[삭제]</a><a href="imageList">[목록]</a>
			</td></tr>
		</table>
	</c:otherwise>
</c:choose>
<form name = "move">
	<input type = "hidden" name = "id" value = "${result.writing_id }">
	<input type = "hidden" name = "parentid" value = "${result.writing_id }">
	<input type = "hidden" name = "groupid" value = "${result.group_id }">
</form>
<script type = "text/javascript">

	function goModify() {
		document.move.action = "imageModify";
		document.move.submit();
	}

	function goDelete() {
		document.move.action = "imageDelete";
		document.move.submit();
	}
	
	function goReply() {
		document.move.action = "WriteFormServlet";
		document.move.submit();
	}
</script>
</body>
</html>