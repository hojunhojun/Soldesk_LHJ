<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결과</title>
<link rel="stylesheet" href="page.css">
</head>
<%!
	public String cut(double d) {
		return String.format("%.2f", d);
	}
%>
<body>
	<%
		response.setCharacterEncoding("euc-kr");
		String path = request.getSession().getServletContext().getRealPath("imggg");
		MultipartRequest mr = new MultipartRequest(
				request, 
				path, 							// 파일이 업로드될 폴더 절대경로
				20 * 1024 * 1024,				// 파일의 최대 크기(byte 단위)
				"euc-kr",						// 요청 파라메터 인코딩 방식
				new DefaultFileRenamePolicy()	// 파일명 중복처리	
			);
		String p = mr.getFilesystemName("photo");
		String p2 = URLEncoder.encode(p, "euc-kr"); // 인코딩 ㄱㄱ
		p2 = p2.replace("+", " ");
		
		
		String n = mr.getParameter("name");
		double h = Double.parseDouble(mr.getParameter("height"));
		double w = Double.parseDouble(mr.getParameter("weight"));		
		
		double bmi = w / ((h /100) * (h/100));
		
		String result = "저체중";
		if (bmi >= 39) {
     		result = "고도비만";
     	} else if (bmi >= 32) {
     		result = "중도비만";
     	} else if (bmi >= 30) {
     		result = "경도비만";
     	} else if (bmi >= 24) {
     		result = "과제충";
     	} else if (bmi >= 10) {
     		result = "정상";
     	}
	%>
	<table>
		<tr>
			<th colspan="2">결과</th>
		</tr>
		<tr>
			<td class="picture" colspan="2"><img alt="" src="imggg/<%=p2%>"></td>
		</tr>
		<tr>
			<td class="k" align="center">이름&nbsp;:</td>
			<td align="left"><%=n%></td>
		</tr>
		<tr>
			<td class="k" align="center">키&nbsp;:</td>
			<td align="left"><%=h%></td>
		</tr>
		<tr>
			<td class="k" align="center">몸무게&nbsp;:</td>
			<td align="left"><%=w%></td>
		</tr>
		<tr>
			<td class="k" align="center">BMI&nbsp;:</td>
			<td align="left"><%=cut(bmi)%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><%=result %></td>
		</tr>
	</table>
</body>
</html>