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
<h2 align="center">야구 선수 등록</h2>
<form action = "putPlayerInfo" method = "post" onsubmit="return check()" name = "player">
<fieldset>
	<legend>상세 정보 입력</legend>
	선수번호 : <input type = "text" name = "ID">&nbsp;
	<input type = "button" onclick = "checkPlayer()" value ="중복검사"><br>
	선수이름 : <input type = "text" name = "NAME"><br>
	팀이름 : <select name = "TEAM">
		<option>선택하세요</option>
		<c:forEach var = "teamList" items = "${teamList }">
			<option value = "${teamList.getId() }">${teamList.getName() }</option>
		</c:forEach>
	</select><br>
	포지션 : <select name = "POS">
		<option>선택하세요</option>
		<option>투수</option><option>포수</option><option>1루수</option><option>2루수</option><option>3루수</option>
		<option>유격수</option><option>중견수</option><option>좌익수</option><option>우익수</option><option>지명타자</option>
	</select><br>
	성별 : 남<input type = "radio" name = "GEN" value = "M">
			&nbsp;여<input type = "radio" name = "GEN" value = "W"><br>
	등록일 : <input type = "date" name = "JOINDATE"><br>
	탈퇴일 : <input type = "date" name = "DROPDATE"><br>
	주소 : <input type = "text" name = "PHONE" size="30"><br>
	선수 소개 (아래) : <br>
	<textarea rows="5" cols="80" name="INTRO"></textarea>
</fieldset>
<div align="center">
<input type="submit" value="등록"><input type = "reset" value = "취소">
</div>
</form>
<script type = "text/javascript">
	function check() {
		if(document.team.NAME.value=='') {
			alert("선수명 입력하세요");
			return false;
		}
		if(document.team.TEAM.selectedIndex < 1) {
			alert("등록팀을 선택하세요");
			return false;
		}
		if(document.team.POS.selectedIndex < 1) {
			alert("포지션을 선택하세요");
			return false;
		}
		if(document.team.JOINDATE.value=='') {
			alert("등록일을 선택하세요");
			return false;
		}
		if(document.team.INTRO.value=='') {
			alert("자기소개를 입력하세요");
			return false;
		}
		if(confirm("입력한 내용이 맞습니까")) {
			
		} else {
			return false;
		}
	}
</script>
</body>
</html>