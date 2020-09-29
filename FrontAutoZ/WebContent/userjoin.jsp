<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "join.do" method = "post" name = "joinFrm" onSubmit = "return formCheck(this)">
<input type = "hidden" name = "IDCHK">
이름 : <input type = "text" name = "NAME"><br>
아이디 : <input type = "text" name = "ID">
		<input type = "button" value = "중복검사" onClick = "idCheck()"><br>
암호 : <input type = "password" name = "PWD"><br>
암호확인 : <input type = "password" name = "confirm"><br>
닉네임 : <input type = "text" name = "NICK"><br>
연락처 : <input type = "text" name = "PHONE"><br>

<input type = "submit" value = "회원가입" class = "btn">
<input type = "reset" value = "취소">
</form>

<script type = "text/javascript">
	function formCheck(frm) {
		if(frm.IDCHK.value == '') {
			alert("ID중복검사를 해주세요");
			return false;
		}
		if(frm.IDCHK.value != frm.ID.value) {
			alert("ID중복검사를 해주세요");
			return false;
		}
		if(frm.NAME.value == '') {
			alert("이름을 입력하세요");
			return false;
		}
		if(frm.ID.value == '') {
			alert("ID를 입력하세요");
			return false;
		}
		if(frm.PWD.value == '') {
			alert("암호 입력하세요");
			return false;
		}
		if(frm.PWD.value != frm.CONFIRM.value) {
			alert("암호가 일치하지 않습니다");
			return false;
		}
		
		if(confirm("입력한 내용이 맞습니까")) {
			
		} else {
			return false;
		} 

	}
	
	function idCheck() {
		if(document.joinFrm.ID.value == '') {
			alert("ID를 입력하세요");
			document.joinFrm.ID.focus();
			return;
		}
		
		window.open("idCheck.do?ID=" + document.joinFrm.ID.value, "_blank", "width=450, height=300")
		
	}
</script>
</body>
</html>