<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>계산 결과</title>
</head>
<body>
	<% 
	int xxx = Integer.parseInt(request.getParameter("xx"));
	int yyy = Integer.parseInt(request.getParameter("yy"));
	int bigger = (xxx > yyy) ? xxx : yyy;
	int smaller = (xxx > yyy) ? yyy : xxx;
	%> <!-- 자바 소스 쓰는 자리 -->
	
	<h1>더 큰 수는 <%=bigger%></h1>
	<h1>더 작 수는 <%=smaller%></h1>
</body>
</html>