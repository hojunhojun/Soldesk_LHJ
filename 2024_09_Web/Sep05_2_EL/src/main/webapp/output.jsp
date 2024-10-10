<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결과</title>
<link rel="stylesheet" href="page.css">
</head>
<body>
	<%
	
	%>
	<table>
		<tr>
			<th colspan="2">결과</th>
		</tr>
		<tr>
			<td class="picture" colspan="2"><img alt="" src="imggg/${g.photo}"></td>
		</tr>
		<tr>
			<td class="k" align="center">이름&nbsp;:</td>
			<td align="left">${g.name}</td>
		</tr>
		<tr>
			<td class="k" align="center">키&nbsp;:</td>
			<td align="left">${g.height}cm</td>
		</tr>
		<tr>
			<td class="k" align="center">몸무게&nbsp;:</td>
			<td align="left">${g.weight}kg</td>
		</tr>
		<tr>
			<td class="k" align="center">BMI&nbsp;:</td>
			<td align="left">${g.bmi}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">${g.result}</td>
		</tr>
	</table>
</body>
</html>