<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>변환결과</title>
<link rel="stylesheet" href="page.css">
<%!
	public String cut(double d) {
		return String.format("%.1f", d);
	}
%>
</head>
<body>
	<%
		double n = Double.parseDouble(request.getParameter("num"));
		String u = request.getParameter("user");
		
		HashMap<String, String[]> units = new HashMap<String, String[]>();
		units.put("cti", new String[]{"cm", "inch"});
		units.put("mtp", new String[]{"㎥", "평"});
		units.put("ctf", new String[]{"℃", "℉"});
		units.put("ktm", new String[]{"km/h", "mi/h"});
		
		double result = n * 0.621371;
		if (u.equals("cti")) {
			result = n * 0.393701;
		} else if (u.equals("mtp")) {
			result = n * 0.3025;
		} else if (u.equals("ctf")) {
			result = n * 1.8 + 32;
		}
	%>
	<table id="<%=u %>">
		<tr>
			<th>변환결과</th>
		</tr>
		<tr>
			<td align="center"><%=cut(n)%>&nbsp;<%=units.get(u)[0]%></td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><%=cut(result)%>&nbsp;<%=units.get(u)[1]%></td>
		</tr>
	</table>
</body>
</html>