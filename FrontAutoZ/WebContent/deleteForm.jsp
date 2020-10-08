<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "delete.do" method = "post" name ="deleteImageFrm" onSubmit ="return validate(this)">
	<input type = "hidden" name = "id" value = "${result.writing_id }">
	<input type = "hidden" name = "pw" value = "${result.password }">
	<table width="100%" border="1">
		<tr><td>글제목</td><td>${result.title }</td></tr>
		<tr><td>작성자</td><td>${result.writer_name }</td></tr>
		<tr><td>이메일</td><td>${result.email }</td></tr>
		<tr><td>암호</td><td><input type = "password" name ="password" size="20"></td></tr>
		<tr><td>이미지</td><td><img alt="" src="upload/${result.image_name }" width="350" height ="350" border="0"></td></tr>
		<tr><td colspan="2"><input type = "submit" value ="삭제">
		<input type = "button" value = "취소" onclick="javascript:histroy.go(-1)"></td></tr>
	</table>
</form>
<script type="text/javascript">
	function validate(frm) {
		var password = frm.password.value;
		var pw = frm.pw.value;
		if(password == pw) {
			
		} else {
			alert("암호를 다시 확인해주세요.");
			return false;
		}
		var r = confirm("정말로 삭제하시겠습니까");
		if(r == false) return false;
	}
</script>
</body>
</html>