<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>2��° ������</title>
</head>
<body>
<%
	// request parameter(���� �̵�)
	//		Get��� : �ּҿ� ������� �ɴϴ�.
	//		Post��� : ���������� �ɴϴ�.
	//		String
	//		request��ü �Ҽ�
	//		html���� �������
	
	String aa = request.getParameter("a"); // �⺻������ String�̶�
	int aaa = Integer.parseInt(aa); // �ʿ��ϸ� ����ȯ
	
	int bbb = Integer.parseInt(request.getParameter("b"));
	
	// request.attribute
	//		Object
	//		request��ü �Ҽ�
	// 		java���� �������
	String cccc = "������";
	double dddd = 123.445;
	request.setAttribute("c", cccc); // ������ �������� ���� ����
	//	STring ccc = (Stirng) cc;
	request.setAttribute("d", dddd);
	// �ڵ��̵� 
	//	redirect : ������(���� ��������)
	// 		response.sendRedirect("third.jsp");
	//	forward : ��û������ ��󿡰� �˷���(���� ������) -> ������ �̵� �ַ�
	//	include : ������ ���Խ��Ѽ� ������(���� ������) -> ��ġ ���� �Ұ�(�켱����)
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	// 	rd.forward(request, response);
	rd.include(request, response);
%>
	<h1>Second</h1>
	<h2>a = <%=aaa %>, b = <%=bbb %></h2>
</body>
</html>