<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 접두어 설정이랑 불러오기 세팅 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body> <!-- 여러개중에 고르세요(조건문) -->
	<c:choose>
		<c:when test="${result % 2 == 1}">
			<h1>${result}</h1>
		</c:when>
		<c:otherwise>
			<h5>${result}</h5>
		</c:otherwise>
	</c:choose>
	<hr> <!-- 이놈이 반복문(기본형 String) -->
	<c:forEach var="i" begin="0" end="10" step="2">
		${i}
	</c:forEach>
	<hr>
	<table border="1">
		<tr>
			<th>${result}단</th>
		</tr><!-- 얘는 살짝 foreach 버전 -->
		<c:forEach var="g" items="${gugu}">
			<tr>
				<td>${g}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<c:forEach var="s" items="${snacks}">
		<h2>${s.name} : ${s.price}</h2>
	</c:forEach>
	<%
		// .jsp에서 Java를 없애자
		// JSP Model 2 구조를 쓰는 와중에
		//		값 받기 : EL
		//		include : JSP 표준액션태그
		//		기본 제어문(if, for...)
		
		// CustomTag
		//		JSP표준액션태그 : .jsp에서 그냥 되는거
		//				<jsp:xxx>
		//		찐커스텀태그 : .jar파일 넣고 쓰는건
		//					<맘대로:xxx>
		//			JSTL(Jsp Standard Tag Library)
		//				core - 프로그래밍 언어(제어문)
		//				formatting
		//				functions
		//				...
	%>
</body>
</html>