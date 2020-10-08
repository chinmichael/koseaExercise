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
	<c:when test = "${empty LIST }">
		등록된 게시글이 존재하지 않습니다
	</c:when>
	<c:otherwise>
		<table width="100%">
			<tr><td align = "right"><b>${startRow }~${endRow }/${count }</b></td></tr>
		</table>
		<table width="100%" border="1">
			<tr><td>이미지</td><td>글제목</td><td>작성자</td><td>작성일</td></tr>
			<c:forEach var ="write" items="${LIST }">
				<tr><td><img alt="" src="upload/${write.image_name }" width="50" height="50"></td>
					<td><a href="javascript:goView(${write.writing_id })">${write.title }</a></td>
					<td>${write.writer_name }</td>
					<td>${write.register_date }</td></tr>
			</c:forEach>
		</table>
		
		<c:set var = "startPage" value = "${currentPage - (currentPage%10 == 0 ? 10 : (currentPage%10)) + 1 }" />
		<c:set var = "endPage" value = "${startPage + 9 }" />
		<c:if test = "${endPage > pageCount }">
			<c:set var ="endPage" value = "${pageCount }"/>
		</c:if>
		<c:if test = "${startPage > 10 }">
			<a href="javascript:goPage(${startPage - 1 })">[이전]</a>
		</c:if>
		
		<c:forEach var="pageNo" begin="1" end="${pageCount}">
			<c:if test = "${currentPage == pageNo }"><font size="5"></c:if>
			<a href = "javascript:goPage(${pageNo })">${pageNo }</a>
			<c:if test = "${currentPage == pageNo }"></font></c:if>
		</c:forEach>
		
		<c:if test = "${endPage < pageCount }">
			<a href="javascript:goPage(${endPage + 1 })">[다음]</a>
		</c:if>
		
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	function goView(no) {
		document.move.id.value = no;
		document.move.action = "imageRead";
		document.move.submit();
	}
	function goPage(page) {
		document.move.action = "imageList";
		document.move.page.value = page;
		document.move.submit();
	}
</script>
<form name ="move" method = "post">
	<input type = "hidden" name = "id">
	<input type = "hidden" name = "page" value = "${currentPage }">
</form>
</body>
</html>