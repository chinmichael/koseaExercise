<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "modify.do" method = "post" enctype="multipart/form-data" name ="deleteImageFrm" onSubmit ="return validate(this)">
	<input type = "hidden" name = "id" value = "${result.writing_id }">
	<input type = "hidden" name = "pw" value = "${result.password }">
	<input type = "hidden" name = "originImage" value = "${result.image_name }">
	<table width="100%" border="1">
		<tr><td>글제목</td><td><input type="text" name = "title" value ="${result.title }"></td></tr>
		<tr><td>작성자</td><td><input type="text" name = "name" value ="${result.writer_name }"></td></tr>
		<tr><td>이메일</td><td><input type="text" name = "email" value ="${result.email }"></td></tr>
		<tr><td>암호</td><td><input type = "password" name ="password" size="20"></td></tr>
		<tr><td>이미지</td><td>
		<input type ="file" name ="image_name"><br>
		<img alt="" src="upload/${result.image_name }" width="350" height ="350" border="0"></td></tr>
		<tr><td>내용</td><td><textarea rows="8" cols="100%" name="content">${result.content }</textarea></td><td>
		<tr><td colspan="2"><input type = "submit" value ="수정">
		<input type = "button" value = "취소" onclick="javascript:histroy.go(-1)"></td></tr>
	</table>
</form>
<script type="text/javascript">
	function validate(frm) {
		var password = frm.password.value;
		var pw = frm.pw.value;
		
		if(frm.title.value == '') {
			alert("제목을 입력하세요");
			return false;
		}
		if(frm.name.value == '') {
			alert("닉네임을 입력하세요");
			return false;
		}
		if(frm.email.value == '') {
			alert("이메일을 입력하세요");
			return false;
		}
		
		if(password == pw) {
			
		} else {
			alert("암호를 다시 확인해주세요.");
			return false;
		}
		var r = confirm("정말로 수정하시겠습니까");
		if(r == false) return false;
	}
</script>
</body>
</html>