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
		상품명 : <input name="name" maxlength="10"> <p>
		가격 : <input name="price" maxlength="6"> <p>
		<button>등록하기</button>
	</form>
</body>
</html>