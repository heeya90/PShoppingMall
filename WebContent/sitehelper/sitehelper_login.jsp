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
				alert("���̵� �Է��ϼ���");
				$("#adminId").focus();
				return false;
			}
			if ($("#adminPwd").val() == '') {
				alert("�н����带 �Է��ϼ���");
				$("#adminPwd").focus();
				return false;
			}
			$.post("admchk.do", $("form").serialize(), function(data){
				alert(data);
				if (data == 'ok') {
					location.href = '/index.jsp';
				} else if (data == 'id' || data == 'pw') {
					alert('���̵� ����� Ȯ���ϼ���.');
					return false;
				} else if (data == 'notShop') {
					alert('��ϵ��� ���� �������Դϴ�.');
					return false;
				} else {
					alert(data + '������ �߻��Ͽ����ϴ�.');
					return false;
				}
			});
		});
	});
</script>
</head>
<body>
	<h2 align="center">������ �α���</h2>

	<form method="post">
	ID :
	<input type="text" name="adminId" id="adminId" />
	<br /> PW :
	<input type="password" name="adminPwd" id="adminPwd" />
	<br />
	<button id="loginBtn">�α���</button>
	<!-- class="admchk.do" -->
	</form>
</body>
</html>