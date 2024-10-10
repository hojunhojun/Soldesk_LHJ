<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- ���ξ� �����̶� �ҷ����� ���� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body> <!-- �������߿� ������(���ǹ�) -->
	<c:choose>
		<c:when test="${result % 2 == 1}">
			<h1>${result}</h1>
		</c:when>
		<c:otherwise>
			<h5>${result}</h5>
		</c:otherwise>
	</c:choose>
	<hr> <!-- �̳��� �ݺ���(�⺻�� String) -->
	<c:forEach var="i" begin="0" end="10" step="2">
		${i}
	</c:forEach>
	<hr>
	<table border="1">
		<tr>
			<th>${result}��</th>
		</tr><!-- ��� ��¦ foreach ���� -->
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
		// .jsp���� Java�� ������
		// JSP Model 2 ������ ���� ���߿�
		//		�� �ޱ� : EL
		//		include : JSP ǥ�ؾ׼��±�
		//		�⺻ ���(if, for...)
		
		// CustomTag
		//		JSPǥ�ؾ׼��±� : .jsp���� �׳� �Ǵ°�
		//				<jsp:xxx>
		//		��Ŀ�����±� : .jar���� �ְ� ���°�
		//					<�����:xxx>
		//			JSTL(Jsp Standard Tag Library)
		//				core - ���α׷��� ���(���)
		//				formatting
		//				functions
		//				...
	%>
</body>
</html>