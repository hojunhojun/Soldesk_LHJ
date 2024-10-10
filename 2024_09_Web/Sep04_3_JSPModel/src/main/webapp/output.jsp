<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결과</title>
</head>
<body>
	<%
		int zzzz = (Integer) request.getAttribute("zzz"); // setAttribute로 값을 보냇으니까 getAttribute로 받기
	%>
	<h1>결과는 : <%=zzzz %></h1>
</body>
</html>