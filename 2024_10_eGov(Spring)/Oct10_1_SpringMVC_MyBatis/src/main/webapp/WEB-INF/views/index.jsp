<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${result} <p>
	<form action="menu.reg">
		<input name="token" value="${token}" type="hidden"> <p>
		메뉴 등록 <p>
		이름 : <input name="m_name"> <p>
		가격 : <input name="m_price"> <p>
		<button>등록</button>
	</form>
	<hr>
	<c:forEach var="m" items="${menus}">
		${m.m_no} &nbsp; ${m.m_name} &nbsp; ${m.m_price} <br>
	</c:forEach>
</body>
</html>