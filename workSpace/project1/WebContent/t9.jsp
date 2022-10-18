<%@page import="java.util.Map"%>
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

Map<String,String[]> map=request.getParameterMap();

for(String key : map.keySet()){

out.print(key+" : ");

for(String value : map.get(key))

out.print(value+",");

out.print("<br/>");

}

%>

</body>
</html>