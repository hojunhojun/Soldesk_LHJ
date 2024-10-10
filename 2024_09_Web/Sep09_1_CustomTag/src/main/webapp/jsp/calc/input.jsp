<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CalcController" name="calcForm" onsubmit="return calcCheck();" method="post">
		X : <input name="xx" class="calcInput"> <p>
		Y : <input name="yy" class="calcInput"> <p>
		<button>계산하기</button>
	</form>
</body>
</html>