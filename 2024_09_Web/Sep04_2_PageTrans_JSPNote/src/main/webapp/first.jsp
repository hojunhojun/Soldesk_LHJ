<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>1번째 페이지</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "second.jsp?a=100&b=200"; // get 방식 요청
	}
</script>
</head>
<body>
<%
	// request(수동 이동)
	//		1) <a>태그 : 텍스트부분 누르면 get 방식 요청
	//		2) form + button : 버튼누르면 원하는 방식으로 요청(get: 주소에 담겨서 / post: 내부적으로 전달)
	//			input에 쓴 내용 가져다가 자동으로 주소 만들어서 요청해주는 시스템
	//		3) JavaScript : ???? 하면 get 방식 요청
%>
	<h1>First</h1>
	<a href="second.jsp?a=10&b=20">second로</a> <!-- get방식이라 주소체계를 만집니다. -->
	<hr>
	<form action="second.jsp" method="post">
		a : <input name="a"> <p>
		b : <input name="b"> <p>
		<button>second로</button>
	</form>
	<hr>
	<h2 onclick="gogogo();">second로</h2>
</body>
</html>