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
		// JSP Model2 : 분업하려고 -> 근데 완벽하지 않음
		// .jsp는 V라서 디자이너가 작업하는 파일인데
		// Java소스가?
		// -> .jsp에서 Java소스를 없애서 분업을 완성시키자
		
		// JSP Model 2에서 .jsp에 Java소스 쓸 일이 없어야함
		// EL (Expression Language) 
		// 		1) 값 받을때 + 형변환
		//		연산자 사용 가능, 형변환 자동, import 필요없음
		//		-> ${...} : .jsp가 Servlet으로 바뀔때 Java소스로 바꿔서 실행
		// 			request parameter
		// 			-> ${param.이름}
		//			request attribute
		//			-> 	기본형급 : ${이름}
		//			-> 	객체급 : ${이름.name} -> getter호출
		//				객체List : ${이름[인덱스].멤버변수명}
		// CustomTag
		// 		2) if, for같은 기본 제어문 ...?
		// 		3) 출력 형식 ...?
		// 		4) 흐름 제어 : include forward
	%>
	<h1>Output</h1>
	${param.aa}<p>
	${param.bb} <hr>
	${param.aa + 5} <!-- 이거도 가능 --> <hr>
	${param.bb >= 2} <!-- 이거도 가능 --> <hr>
	${cc} <hr>
	${dd} <hr>
	${ee.name}&nbsp;${ee.age} <hr>
	${ff[0].name} : ${ff[0].age} <hr>
	${ff[1].name} : ${ff[1].age} <hr>
</body>
</html>