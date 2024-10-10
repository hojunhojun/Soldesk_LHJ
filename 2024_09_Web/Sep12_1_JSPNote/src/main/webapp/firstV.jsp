<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title><base>
<script type="text/javascript">
	function gogogo() {
		location.href = "SecondController?a=20"; // Get방식 요청
	}
</script>
</head>
<body>
	여기는 firstV.jsp임 <p>
	<hr>
	<a href="SecondController?a=10">secondV.jsp로</a> <p> <!-- GET방식 요청 -->
	<hr>
	<h1 onclick="gogogo();">secondV.jsp로</h1>
	<hr>
	<form action="SecondController"> <!-- 이건 GET방식,POST방식 선택 가능 -->
		<input name="a">			 <!-- a에 넣은값을 자동으로 보내줌 와우 ㄷㄷ -->
		<button>secondV.jsp로</button>
	</form>
</body>
</html>