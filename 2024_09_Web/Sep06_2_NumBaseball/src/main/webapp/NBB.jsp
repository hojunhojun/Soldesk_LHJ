<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ھ߱�</title>
<script type="text/javascript" src="ValidCheck.js"></script>
<script type="text/javascript" src="leeValidChecker_v1.0.js"></script>
</head>
<body>
	<form action="HomeController" onsubmit="return check();" name="nbbForm">
		�� : <input name="input" maxlength="3" placeholder="${param.input}"> <p>
		<button>����</button> <p>
	</form>
	-----------------------------------<p>
	<h1>${turn } : ${strike }S ${ball }B</h1>
</body>
</html>