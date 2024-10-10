<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>first</h1>
	<%
		// .jsp : v
		//		-> �����̳ʰ� �۾�
		
		// CustomTag
		//		������ Java�� �ϴ��� DOM��ü ���·� �ϴ°�
		//		�۾����� : DOM��ü -> Java�� �ٲ� ����
		//		����
		//			<���ξ�:XXX></XXX>
		//		����
		//			JSPǥ�ؾ׼��±� : (��ǰ).jsp���� �⺻ ��� ���� (���ξ� : jsp)
		//			CustomTag : �ܺ� .jar���� �ְ� ����
		
		//	�ڵ��̵�
		//		redirect : Ŀ�����±�
		//		forward
		//		-> request.getRequestDispatcher("second.jsp").forward(request, response);
		//		include
		//		-> request.getRequestDispatcher("second.jsp").include(request, response); : second�� ������ first�� ���Խ�Ŵ
	%>
	<jsp:forward page="second.jsp"></jsp:forward> <!-- �̰ŷ� forward �Ҽ� ���� -> �̰� ���� java�ҽ��� �ٲ� �����(���̿� �̻��Ѱ� ��������) -->
	<jsp:include page="second.jsp"></jsp:include> <!-- �̰ŷ� include �Ҽ� ����(����) -> �̰� ���� java�ҽ��� �ٲ� �����(���̿� �̻��Ѱ� ��������) -->
</body>
</html>