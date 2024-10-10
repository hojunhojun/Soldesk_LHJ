<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0"><!-- ����Ͽ� �Ҷ��� �̰� �ְ� ���� -->
<title>Sep10</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<%
		// PC �ػ� : 1920 x 1080
		// �� �ػ� : ����� �� ���߶��� ����� ȭ�鿡 ����ȭ��ų �ʿ䰡 ����(viewport ����)
	%>
	<table id="siteTitle">
		<tr>
			<td>
				<a href="HomeController">Sep10</a>
			</td>
		</tr>
	</table>
	<table id="siteContent">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage}"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteMenu">
		<tr>
			<td align="center">
				<a href="JSTLCoreController">����</a>
			</td>
			<td align="center">
				<a href="LottoController">�ζǹ�ȣ�ڵ�������</a>
			</td>
			<td align="center">
				<a href="WeatherController">���û<br>��������</a>
			</td>
		</tr>
	</table>
</body>
</html>