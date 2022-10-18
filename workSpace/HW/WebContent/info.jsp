<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
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
String path = application.getInitParameter("filePath");
String rPath = application.getRealPath(path);

FileReader fr = new FileReader(rPath); 
BufferedReader br = new BufferedReader(fr); 

String line = null;
while((line=br.readLine())!=null){ 
  out.println(line + "<br>");
}

}catch (IOException e) {
    System.out.println(e.toString()); 
}
%>

</body>
</html>