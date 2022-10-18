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
String s1=request.getParameter("aa");
String s2=request.getParameter("bb");
out.print(s1);
out.print("</br>");
out.print(s2);
%>

</body>
</html>