<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
</head>
<body>
	<%
		int zzzz = (Integer) request.getAttribute("zzz"); // setAttribute�� ���� �������ϱ� getAttribute�� �ޱ�
	%>
	<h1>����� : <%=zzzz %></h1>
</body>
</html>