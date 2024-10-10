<%@page import="com.lhj051jm2.main.UCResult"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>변환결과</title>
<link rel="stylesheet" href="page.css">
</head>
<body>
	<%	
		UCResult ucr = (UCResult) request.getAttribute("result");
		
	%>
	<table id="<%=ucr.getU() %>">
		<tr>
			<th>변환결과</th>
		</tr>
		<tr>
			<td align="center"><%=ucr.getNum()%>&nbsp;<%=ucr.getUnit1()%></td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><%=ucr.getResult()%>&nbsp;<%=ucr.getUnit2()%></td>
		</tr>
	</table>
</body>
</html>