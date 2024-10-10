<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
	<form action="MartController" name="martForm"
		onsubmit="return martCheck();" method="post">
	구매 : <textarea name="martInput" class="martTA"></textarea> <p>
	<button>계산</button>
	</form>
</body>
</html>