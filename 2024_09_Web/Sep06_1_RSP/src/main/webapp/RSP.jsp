<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="HomeController?hand=1">
		<img src="img/1.png">
	</a>
	<a href="HomeController?hand=2">
		<img src="img/2.png">
	</a>
	<a href="HomeController?hand=3">
		<img src="img/3.png">
	</a>
	<hr>
	�� : <img alt="" src="img/${userHand}"> <p>
	�� : <img alt="" src="img/${comHand}"> <p>
	${result}<p>
	${win}�� ${draw}�� ${lose}��
</body>
</html>