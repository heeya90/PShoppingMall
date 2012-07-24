<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ADMIN LOGIN PAGE</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginBtn").bind("click", function() {
			if ($("#adminId").val() == '') {
				alert("아이디를 입력하세요");
				$("#adminId").focus();
				return false;
			}
			if ($("#adminPwd").val() == '') {
				alert("패스워드를 입력하세요");
				$("#adminPwd").focus();
				return false;
			}
			$.post("admchk.do", $("form").serialize(), function(data){
				alert(data);
				if (data == 'ok') {
					location.href = '/index.jsp';
				} else if (data == 'id' || data == 'pw') {
					alert('아이디 비번을 확인하세요.');
					return false;
				} else if (data == 'notShop') {
					alert('등록되지 않은 가맹점입니다.');
					return false;
				} else {
					alert(data + '에러가 발생하였습니다.');
					return false;
				}
			});
		});
	});
</script>
</head>
<body>
	<h2 align="center">관리자 로그인</h2>

	<form method="post">
	ID :
	<input type="text" name="adminId" id="adminId" />
	<br /> PW :
	<input type="password" name="adminPwd" id="adminPwd" />
	<br />
	<button id="loginBtn">로그인</button>
	<!-- class="admchk.do" -->
	</form>
</body>
</html>