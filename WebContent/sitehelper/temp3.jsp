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
		mssg = "관리자 로그인 성공!!";
	}else{
		if(!id.equals(adm.getId())){
			mssg = "아이디가 틀렸습니다.";
		}
		if(!pw.equals(adm.getPw())){
			mssg = "비밀번호가 틀렸습니다.";
		}
	}
		
	//2.뷰 페이지에서 사용할 정보 저장
	request.setAttribute("1", mssg);
	%>
	<%= mssg %>
</body>
</html>