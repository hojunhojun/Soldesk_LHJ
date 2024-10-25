<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>카테고리</td>
			<td>가격</td>
		</tr>
		<c:forEach items="${snacks}" var="s">
			<tr>
				<td>${s.s_title }</td>
				<td>${s.s_genre }</td>
				<td>${s.s_price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>