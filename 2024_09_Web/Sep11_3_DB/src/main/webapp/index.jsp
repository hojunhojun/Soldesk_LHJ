<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${result}
	<a href="ProductRegController">등록하기</a>
	<hr>
	<table border="1">
		<tr>
			<th>품명</th><th>가격</th>
		</tr>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.name}</td>
					<td>
						\<fmt:formatNumber value="${p.price}" type="number"/>
					</td>
				</tr>
			</c:forEach>
	</table>
	<c:forEach var="p" begin="1" end="${pageCount}">
		<a href="ProductPageController?page=${p}">${p}</a>
	</c:forEach>
</body>
</html>