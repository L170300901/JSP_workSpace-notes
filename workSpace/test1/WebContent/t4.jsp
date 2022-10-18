<%@page import="a.b.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id=request.getParameter("id");
String pw=request.getParameter("pw");
String addr=request.getParameter("addr");
String tel=request.getParameter("tel");
MemberBean bean=new MemberBean();
bean.setId(id);
bean.setPw(pw);
bean.setAddr(addr);
bean.setTel(tel);
session.setAttribute("member",bean);
%>

<a href="t5.jsp">회원정보보기</a>
</body>
</html>