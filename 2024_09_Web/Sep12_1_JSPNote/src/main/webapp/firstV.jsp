<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title><base>
<script type="text/javascript">
	function gogogo() {
		location.href = "SecondController?a=20"; // Get��� ��û
	}
</script>
</head>
<body>
	����� firstV.jsp�� <p>
	<hr>
	<a href="SecondController?a=10">secondV.jsp��</a> <p> <!-- GET��� ��û -->
	<hr>
	<h1 onclick="gogogo();">secondV.jsp��</h1>
	<hr>
	<form action="SecondController"> <!-- �̰� GET���,POST��� ���� ���� -->
		<input name="a">			 <!-- a�� �������� �ڵ����� ������ �Ϳ� ���� -->
		<button>secondV.jsp��</button>
	</form>
</body>
</html>