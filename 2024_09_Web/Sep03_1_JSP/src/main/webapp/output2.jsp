<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ���</title>
</head>
<body>
	<% 
	int xxx = Integer.parseInt(request.getParameter("xx"));
	int yyy = Integer.parseInt(request.getParameter("yy"));
	int bigger = (xxx > yyy) ? xxx : yyy;
	int smaller = (xxx > yyy) ? yyy : xxx;
	%> <!-- �ڹ� �ҽ� ���� �ڸ� -->
	
	<h1>�� ū ���� <%=bigger%></h1>
	<h1>�� �� ���� <%=smaller%></h1>
</body>
</html>