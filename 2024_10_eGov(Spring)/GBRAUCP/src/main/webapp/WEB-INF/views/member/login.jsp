<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl" >
		<form action="login.do" onsubmit="return loginCheck();" method="post" name="loginForm">
		<tr>
			<td><input name="gm_id" placeholder="id"></td>
		</tr>
		<tr>
			<td><input name="gm_pw" placeholder="pw" type="password"></td>		
		</tr>
		<tr>
			<td align="center">
				<button>로그인</button>
		</form>
				<button onclick="joinGo();">회원가입</button>
			</td>
		</tr>
	</table>
</body>
</html>