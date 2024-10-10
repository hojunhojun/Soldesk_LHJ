<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
	JSTL
	core : if/for
	fmt : �������
	functions : ���ڿ� ��(V����?�� ����)
	sql : DB���� ����
	xml : XML�� �� ����
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
				<td>${w.hour}�ñ���</td>
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