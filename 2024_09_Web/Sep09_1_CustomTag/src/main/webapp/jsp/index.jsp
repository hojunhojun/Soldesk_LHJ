<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Sep09_1_CustomTag</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/calc.css">
<link rel="stylesheet" href="css/mart.css">
<script type="text/javascript" src="js/leeValidChecker_v1.0.js"></script>
<script type="text/javascript" src="js/sep091check.js"></script>
<%
	// �� �������� �������� ���ؼ� ȭ�鿡 ���ö�
	//	-> ����Ǵ� ����
	// JSP Model2(Dynamic Web Project - Tomcat�� ����)
	//		css/js/�׸�/... : ��ΰ� webapp���� ����
	//		include : ��ΰ� index.jsp ����
%>
</head>
<body>
	<table id="t1">
		<tr>
			<td id="siteTitle">Sep09_CustomTag</td>
		</tr>
		<tr>
			<td id="siteMenu">
				<a href="HomeController">Ȩ</a>
				<a href="CalcController">��Ģ����</a>
				<a href="MartController">��Ʈ(���ǰ����)</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center">
			<% 
				// index.jsp�� Servlet���� �ٲ� home.jsp �ҽ��� ����� �־��(���� ��)
			%>
				<jsp:include page="${contentPageee}"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>