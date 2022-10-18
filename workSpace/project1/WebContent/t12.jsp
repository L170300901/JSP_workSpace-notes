<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

List<String> list=new ArrayList<String>();

list.add("Java");

list.add("HTML");

list.add("Javascript");

list.add("XML");

list.add("Jsp");

list.add("React");

for(String s:list)

out.print("<input type=checkbox>"+s+"<br>");

%>

</body>
</html>