<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/page.css">
</head>
<body>
	<table id="${result.what}>">
		<tr>
			<th>변환결과</th>
		</tr>
		<tr>
			<td align="center"><fmt:formatNumber value="${result.num}" pattern="#.0" /> ${result.unit1}</td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><fmt:formatNumber value="${result.result}" pattern="#.0" /> ${result.unit2}</td>
		</tr>
	</table>
</body>
</html>