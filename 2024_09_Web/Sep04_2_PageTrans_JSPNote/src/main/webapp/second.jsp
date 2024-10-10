<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>2번째 페이지</title>
</head>
<body>
<%
	// request parameter(수동 이동)
	//		Get방식 : 주소에 담겨져서 옵니다.
	//		Post방식 : 내부적으로 옵니다.
	//		String
	//		request객체 소속
	//		html에서 만들어진
	
	String aa = request.getParameter("a"); // 기본적으로 String이라
	int aaa = Integer.parseInt(aa); // 필요하면 형변환
	
	int bbb = Integer.parseInt(request.getParameter("b"));
	
	// request.attribute
	//		Object
	//		request객체 소속
	// 		java에서 만들어진
	String cccc = "ㅋㅋㅋ";
	double dddd = 123.445;
	request.setAttribute("c", cccc); // 좌항을 우항으로 만들어서 보냄
	//	STring ccc = (Stirng) cc;
	request.setAttribute("d", dddd);
	// 자동이동 
	//	redirect : 공사중(값을 못가져감)
	// 		response.sendRedirect("third.jsp");
	//	forward : 요청정보를 대상에게 알려줌(값을 가져감) -> 페이지 이동 주력
	//	include : 내용을 포함시켜서 가져감(값도 가져감) -> 위치 조절 불가(우선실행)
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	// 	rd.forward(request, response);
	rd.include(request, response);
%>
	<h1>Second</h1>
	<h2>a = <%=aaa %>, b = <%=bbb %></h2>
</body>
</html>