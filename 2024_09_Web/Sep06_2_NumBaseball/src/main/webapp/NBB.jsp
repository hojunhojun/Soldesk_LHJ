<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>숫자야구</title>
<script type="text/javascript" src="ValidCheck.js"></script>
<script type="text/javascript" src="leeValidChecker_v1.0.js"></script>
</head>
<body>
	<form action="HomeController" onsubmit="return check();" name="nbbForm">
		답 : <input name="input" maxlength="3" placeholder="${param.input}"> <p>
		<button>제출</button> <p>
	</form>
	-----------------------------------<p>
	<h1>${turn } : ${strike }S ${ball }B</h1>
</body>
</html>