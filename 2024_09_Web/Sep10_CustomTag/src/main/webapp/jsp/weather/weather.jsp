<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
	JSTL
	core : if/for
	fmt : 출력형식
	functions : 문자열 비교(V에서?왜 ㅋㅋ)
	sql : DB를왜 ㅋㅋ
	xml : XML도 왜 ㅋㅋ
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="w" items="${weathers}">
		<table border="1">
			<tr>
				<td rowspan="3">
					<img alt="" src="${w.img}">
				</td>
				<td>${w.hour}시까지</td>
			</tr>
			<tr>
				<td>${w.wfKor}</td>
			</tr>
			<tr>
				<td align="right">${w.temp}</td>
			</tr>
		</table>
		<c:if test="${w.hour == 24}">
			<hr>
		</c:if>
	</c:forEach>
</body>
</html>