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
<h1>::: 회원정보 :::</h1>
<%
MemberBean bean=(MemberBean)session.getAttribute("member");
%>
id: <%out.print(bean.getId());  %> <br/>
pw: <% out.print(bean.getPw()); %><br/>
addr: <% out.print(bean.getAddr()); %><br/>
tel: <% out.print(bean.getTel()); %><br/>

</body>
</html>