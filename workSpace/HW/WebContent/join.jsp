<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
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
try{
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
String pw=request.getParameter("pw");
String tel=request.getParameter("addr");
String addr=request.getParameter("tel");

String path = application.getInitParameter("filePath");
String rPath = application.getRealPath(path);

System.out.println(path);
System.out.println(rPath);


FileWriter fw = new FileWriter(rPath ); 
String data = "id: "+id+"<br>"+"pw: "+pw+"<br>"+"addr: "+addr+"<br>"+"tel: "+tel+"<br>";
fw.write(data); 
fw.close(); 
}catch (IOException e) {
    System.out.println(e.toString()); 
}
%>
<a href="info.jsp">회원정보보기</a>
</body>
</html>