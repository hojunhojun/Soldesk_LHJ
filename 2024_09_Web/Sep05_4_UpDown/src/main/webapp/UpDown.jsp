<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController">
		Number : <input name="no" placeholder="${param.no}"> <p>
		<button>Ȯ��</button>
	</form>
	<h1>${result}</h1>
	<hr>
</body>
</html>