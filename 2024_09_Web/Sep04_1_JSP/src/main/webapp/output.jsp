<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
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
				path, 							// ������ ���ε�� ���� ������
				20 * 1024 * 1024,				// ������ �ִ� ũ��(byte ����)
				"euc-kr",						// ��û �Ķ���� ���ڵ� ���
				new DefaultFileRenamePolicy()	// ���ϸ� �ߺ�ó��	
			);
		String p = mr.getFilesystemName("photo");
		String p2 = URLEncoder.encode(p, "euc-kr"); // ���ڵ� ����
		p2 = p2.replace("+", " ");
		
		
		String n = mr.getParameter("name");
		double h = Double.parseDouble(mr.getParameter("height"));
		double w = Double.parseDouble(mr.getParameter("weight"));		
		
		double bmi = w / ((h /100) * (h/100));
		
		String result = "��ü��";
		if (bmi >= 39) {
     		result = "����";
     	} else if (bmi >= 32) {
     		result = "�ߵ���";
     	} else if (bmi >= 30) {
     		result = "�浵��";
     	} else if (bmi >= 24) {
     		result = "������";
     	} else if (bmi >= 10) {
     		result = "����";
     	}
	%>
	<table>
		<tr>
			<th colspan="2">���</th>
		</tr>
		<tr>
			<td class="picture" colspan="2"><img alt="" src="imggg/<%=p2%>"></td>
		</tr>
		<tr>
			<td class="k" align="center">�̸�&nbsp;:</td>
			<td align="left"><%=n%></td>
		</tr>
		<tr>
			<td class="k" align="center">Ű&nbsp;:</td>
			<td align="left"><%=h%></td>
		</tr>
		<tr>
			<td class="k" align="center">������&nbsp;:</td>
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