<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
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
 out.write(key +" : ");
 for (String v : map.get(key))
  out.write(v+"&nbsp;&nbsp;&nbsp;");
 out.write("<br/>"); 
}
%>
</body>
</html>