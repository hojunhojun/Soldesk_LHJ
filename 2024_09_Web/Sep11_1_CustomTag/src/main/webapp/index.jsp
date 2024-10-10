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
		// SimpleDateFormat�� �� ����
	%>
	<fmt:formatDate value="${e}" pattern="yyyy/MM/dd(E)"/>
	<hr>
	<fmt:formatDate value="${e}" type="both" dateStyle="long" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${e}" type="time" timeStyle="short"/>
	<hr>
	<%
		// formatDate�� Java�� Date��ü������
	%>
	<fmt:formatDate value="${e}" type="date" dateStyle="long"/>
	<hr>
	<%
		// # : ���� ������ ���, ������ ����ΰ� (�ݿø�)
		// 0 : ���ڰ� �ֵ縻�� ���ڸ��� �����
	%>
	<fmt:formatNumber value="${c}" pattern="#.00"/>
	<hr>
	<fmt:formatNumber value="${c}" type="percent"/>
	<hr>
	<!-- ȭ�� (�ٵ� �̰� �ǹ��ֳ�..?) -->
	<fmt:formatNumber value="${b}" type="currency" currencySymbol="\\"/>
	<hr>
	<fmt:formatNumber value="${b}" type="number"/>
	<hr>
	<!-- �����±� ���ver -->
	<fmt:formatNumber value="${a}" type="number"/>
	<hr>
	${a}
	<%
		// JSTL
		//		core : ���
		//		formatting : ���� ����
		//			3�ڸ����� .�� / �Ҽ������� 2�ڸ������� / ��¥��..
		//		-> formatting������ core�� �ʿ� - X
	%>
</body>
</html>