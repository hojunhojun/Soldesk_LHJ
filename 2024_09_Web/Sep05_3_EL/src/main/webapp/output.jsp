<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// JSP Model2 : �о��Ϸ��� -> �ٵ� �Ϻ����� ����
		// .jsp�� V�� �����̳ʰ� �۾��ϴ� �����ε�
		// Java�ҽ���?
		// -> .jsp���� Java�ҽ��� ���ּ� �о��� �ϼ���Ű��
		
		// JSP Model 2���� .jsp�� Java�ҽ� �� ���� �������
		// EL (Expression Language) 
		// 		1) �� ������ + ����ȯ
		//		������ ��� ����, ����ȯ �ڵ�, import �ʿ����
		//		-> ${...} : .jsp�� Servlet���� �ٲ� Java�ҽ��� �ٲ㼭 ����
		// 			request parameter
		// 			-> ${param.�̸�}
		//			request attribute
		//			-> 	�⺻���� : ${�̸�}
		//			-> 	��ü�� : ${�̸�.name} -> getterȣ��
		//				��üList : ${�̸�[�ε���].���������}
		// CustomTag
		// 		2) if, for���� �⺻ ��� ...?
		// 		3) ��� ���� ...?
		// 		4) �帧 ���� : include forward
	%>
	<h1>Output</h1>
	${param.aa}<p>
	${param.bb} <hr>
	${param.aa + 5} <!-- �̰ŵ� ���� --> <hr>
	${param.bb >= 2} <!-- �̰ŵ� ���� --> <hr>
	${cc} <hr>
	${dd} <hr>
	${ee.name}&nbsp;${ee.age} <hr>
	${ff[0].name} : ${ff[0].age} <hr>
	${ff[1].name} : ${ff[1].age} <hr>
</body>
</html>