<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/leeValidChecker_v1.0.js"></script>
<script type="text/javascript" src="js/sep113check.js"></script>
<body>
	<form action="ProductRegController" name="productRegForm" 
		method="post" onsubmit="return productRegCheck();">
		��ǰ�� : <input name="name" maxlength="10"> <p>
		���� : <input name="price" maxlength="6"> <p>
		<button>����ϱ�</button>
	</form>
</body>
</html>