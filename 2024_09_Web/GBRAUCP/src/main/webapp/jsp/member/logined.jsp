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
			<td align="center">${sessionScope.loginMember.name}�� �ȳ��ϼ���</td>
		</tr>
		<tr>
			<td align="center">
				<button onclick="goMemberInfo();">ȸ������</button>&nbsp;&nbsp;
				<button onclick="logOut();">�α׾ƿ�</button>
			</td>
		</tr>
	</table>
</body>
</html>