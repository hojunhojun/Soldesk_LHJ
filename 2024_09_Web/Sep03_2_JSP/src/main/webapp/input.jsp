<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ȯ</title>
<script type="text/javascript" src="validCheck.js"></script>
<script type="text/javascript" src="leeValidChecker_v1.0.js"></script>
<link rel="stylesheet" href="page.css">
</head>
<body>
	<form action="output.jsp" name="inputForm" onsubmit="return check();">
		<table>
			<tr>
				<th align="center">������ȯ</th>
			</tr>
			<tr>
				<td align="center">��ȯ�� ��</td>				
			</tr>
			<tr>
				<td align="center"><input type="text" name="num"></td>
			</tr>
			<tr>
				<td align="center">����</td>
			</tr>
			<tr>
				<td align="center">
					<select name="user">
						<option value="cti">cm �� inch</option>
						<option value="mtp">�� �� ��</option>
						<option value="ctf">�� �� ��</option>
						<option value="ktm">km/h �� mi/h</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center"><button>��ȯ</button></td>
			</tr>
		</table>
	</form>
</body>
</html>