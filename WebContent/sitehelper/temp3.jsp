<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.database.dao.*" %>
<%@ page import="model.database.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	AdminDao adminDao = new AdminDao();
	Admin adm = adminDao.selectAdmin();
	String mssg=null;
	
	System.out.println(adm.getId() + adm.getPw());
	if( id.equals(adm.getId()) && pw.equals(adm.getPw())){
		mssg = "������ �α��� ����!!";
	}else{
		if(!id.equals(adm.getId())){
			mssg = "���̵� Ʋ�Ƚ��ϴ�.";
		}
		if(!pw.equals(adm.getPw())){
			mssg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
		}
	}
		
	//2.�� ���������� ����� ���� ����
	request.setAttribute("1", mssg);
	%>
	<%= mssg %>
</body>
</html>