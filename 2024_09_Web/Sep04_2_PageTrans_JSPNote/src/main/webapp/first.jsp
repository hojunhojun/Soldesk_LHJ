<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>1��° ������</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "second.jsp?a=100&b=200"; // get ��� ��û
	}
</script>
</head>
<body>
<%
	// request(���� �̵�)
	//		1) <a>�±� : �ؽ�Ʈ�κ� ������ get ��� ��û
	//		2) form + button : ��ư������ ���ϴ� ������� ��û(get: �ּҿ� ��ܼ� / post: ���������� ����)
	//			input�� �� ���� �����ٰ� �ڵ����� �ּ� ���� ��û���ִ� �ý���
	//		3) JavaScript : ???? �ϸ� get ��� ��û
%>
	<h1>First</h1>
	<a href="second.jsp?a=10&b=20">second��</a> <!-- get����̶� �ּ�ü�踦 �����ϴ�. -->
	<hr>
	<form action="second.jsp" method="post">
		a : <input name="a"> <p>
		b : <input name="b"> <p>
		<button>second��</button>
	</form>
	<hr>
	<h2 onclick="gogogo();">second��</h2>
</body>
</html>