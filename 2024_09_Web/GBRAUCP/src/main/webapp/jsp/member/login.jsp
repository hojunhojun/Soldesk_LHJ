<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl">
		<form action="LoginController" name="loginForm" onsubmit="return loginCheck();" method="post">
			<tr>
				<td align="center">
					ID : <input name="id" placeholder="ID" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">
					PASSWORD : <input name="pw" placeholder="PASSWORD" maxlength="10" type="password"> <P>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>�α���</button> &nbsp;
		</form>
					<button onclick="goJoin();">ȸ������</button>
				</td>
			</tr>
		</table>
</body>
</html>