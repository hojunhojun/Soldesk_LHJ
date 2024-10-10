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
		//		-> 디자이너가 작업
		
		// CustomTag
		//		기존에 Java로 하던거 DOM객체 형태로 하는거
		//		작업형태 : DOM객체 -> Java로 바뀌어서 실행
		//		문법
		//			<접두어:XXX></XXX>
		//		종류
		//			JSP표준액션태그 : (정품).jsp에서 기본 사용 가능 (접두어 : jsp)
		//			CustomTag : 외부 .jar파일 넣고 쓰는
		
		//	자동이동
		//		redirect : 커스텀태그
		//		forward
		//		-> request.getRequestDispatcher("second.jsp").forward(request, response);
		//		include
		//		-> request.getRequestDispatcher("second.jsp").include(request, response); : second로 가지만 first를 포함시킴
	%>
	<jsp:forward page="second.jsp"></jsp:forward> <!-- 이거로 forward 할수 있음 -> 이게 위의 java소스로 바뀌어서 실행됨(사이에 이상한거 쓰지마셈) -->
	<jsp:include page="second.jsp"></jsp:include> <!-- 이거로 include 할수 있음(유용) -> 이게 위의 java소스로 바뀌어서 실행됨(사이에 이상한거 쓰지마셈) -->
</body>
</html>