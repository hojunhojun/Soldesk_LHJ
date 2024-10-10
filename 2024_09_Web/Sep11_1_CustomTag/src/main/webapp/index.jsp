<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// SimpleDateFormat의 그 패턴
	%>
	<fmt:formatDate value="${e}" pattern="yyyy/MM/dd(E)"/>
	<hr>
	<fmt:formatDate value="${e}" type="both" dateStyle="long" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${e}" type="time" timeStyle="short"/>
	<hr>
	<%
		// formatDate는 Java의 Date객체여야함
	%>
	<fmt:formatDate value="${e}" type="date" dateStyle="long"/>
	<hr>
	<%
		// # : 숫자 있으면 출력, 없으면 비워두고 (반올림)
		// 0 : 숫자가 있든말든 그자리는 보장됨
	%>
	<fmt:formatNumber value="${c}" pattern="#.00"/>
	<hr>
	<fmt:formatNumber value="${c}" type="percent"/>
	<hr>
	<!-- 화폐 (근데 이게 의미있나..?) -->
	<fmt:formatNumber value="${b}" type="currency" currencySymbol="\\"/>
	<hr>
	<fmt:formatNumber value="${b}" type="number"/>
	<hr>
	<!-- 종료태그 요약ver -->
	<fmt:formatNumber value="${a}" type="number"/>
	<hr>
	${a}
	<%
		// JSTL
		//		core : 제어문
		//		formatting : 형식 지정
		//			3자리마다 .좀 / 소수점이하 2자리까지만 / 날짜좀..
		//		-> formatting쓰려면 core도 필요 - X
	%>
</body>
</html>