<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bmi.calculate" method="post" enctype="multipart/form-data">
		이름 : <input name="n"> <p>
		키 : <input name="h"> <p>
		몸무게 : <input name="w"> <p>
		사진 : <input name="photo" type="file"> <p>
		<button>계산</button>
	</form>
</body>
</html>