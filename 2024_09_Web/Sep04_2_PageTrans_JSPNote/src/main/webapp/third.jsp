<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>3번째 페이지</title>
</head>
<body>
	<%
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		Object cc = request.getAttribute("c");
		Object d = request.getAttribute("d");
		
		String ccc = (String) request.getAttribute("c");
		
		// Object dd = request.getAttribute("d");
		// Double ddd = (Double) dd;
		double dddd = (Double)request.getAttribute("d");
	%>
	<h1>Third</h1>
	<%=a %><br>
	<%=b %><br>
	<%=ccc%><br>
	<%=dddd%>
</body>
</html>