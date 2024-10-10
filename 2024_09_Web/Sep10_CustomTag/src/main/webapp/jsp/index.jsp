<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0"><!-- 모바일용 할때는 이거 넣고 시작 -->
<title>Sep10</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<%
		// PC 해상도 : 1920 x 1080
		// 폰 해상도 : 모바일 웹 개발때는 모바일 화면에 최적화시킬 필요가 잇음(viewport 지정)
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
				<a href="JSTLCoreController">랜덤</a>
			</td>
			<td align="center">
				<a href="LottoController">로또번호자동생성기</a>
			</td>
			<td align="center">
				<a href="WeatherController">기상청<br>날씨예보</a>
			</td>
		</tr>
	</table>
</body>
</html>