<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginedTbl">
		<tr>
			<td rowspan="3"align="center" class="td1">
				<img src="img/${sessionScope.loginMember.photo}">
			</td>
			<td>${sessionScope.loginMember.id}</td>
		</tr>
		<tr>
			<td align="center">${sessionScope.loginMember.name}님 안녕하세요</td>
		</tr>
		<tr>
			<td align="center">
				<button onclick="goMemberInfo();">회원정보</button>&nbsp;&nbsp;
				<button onclick="logOut();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>