<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%!
	public String getLaugh() {
		return "ㅋ";
	}
%>
</head>
<body>
	<%=getLaugh()%>
	<%
		Random r = new Random();
		int x = r.nextInt(10);
		if (x % 2 == 0) {
	%>
		<h1><%=x%></h1>
	<%
		} else {
	%>
		<marquee><%=x%></marquee>
	<%
		}
	%>
</body>
</html>