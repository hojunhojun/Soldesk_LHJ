<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/home.css">
	<link rel="stylesheet" href="resources/css/index.css">
	<link rel="stylesheet" href="resources/css/member.css">
	<link rel="stylesheet" href="resources/css/sns.css">
	<link rel="stylesheet" href="resources/css/gallery.css">
	<link rel="stylesheet" href="resources/css/dataroom.css">
	<script type="text/javascript" src="resources/js/move.js"></script>
	<script type="text/javascript" src="resources/js/validCheck.js"></script>
	<script type="text/javascript" src="resources/js/leeValidChecker_v1.0.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td colspan="3" align="center" id="siteTitle">
				<a href="index.do">GBRAUCP</a>
			</td>
		</tr>
		<tr>
			<td align="center" class="td1">
				<a href="sns.go">SNS</a>
			</td>
			<td align="center" class="td1">
				<a href="gallery.go">갤러리</a>
			</td>
			<td align="center" class="td1">
				<a href="dataroom.go">자료실</a>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right" id="siteLoginArea">
				<jsp:include page="${loginPage}"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
			<jsp:include page="${contentPage}"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>