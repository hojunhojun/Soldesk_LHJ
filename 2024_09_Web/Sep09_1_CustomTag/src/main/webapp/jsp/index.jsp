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
	// 이 페이지가 웹브라우저 통해서 화면에 나올때
	//	-> 실행되는 시점
	// JSP Model2(Dynamic Web Project - Tomcat이 관리)
	//		css/js/그림/... : 경로가 webapp폴더 기준
	//		include : 경로가 index.jsp 기준
%>
</head>
<body>
	<table id="t1">
		<tr>
			<td id="siteTitle">Sep09_CustomTag</td>
		</tr>
		<tr>
			<td id="siteMenu">
				<a href="HomeController">홈</a>
				<a href="CalcController">사칙연산</a>
				<a href="MartController">마트(물건값계산)</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center">
			<% 
				// index.jsp가 Servlet으로 바뀔때 home.jsp 소스를 여기다 넣어라(실행 전)
			%>
				<jsp:include page="${contentPageee}"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>