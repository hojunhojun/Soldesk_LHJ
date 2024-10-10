<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="infoArea">
	<form action="MemberInfoController" onsubmit="return memberUpdateCheck();" method="post" enctype="multipart/form-data">
			<tr>
				<td align="center">ID : &nbsp;</td>
				<td align="center">${sessionScope.loginMember.id}</td>
			</tr>
			<tr>
				<td align="center">PASSWORD :&nbsp;</td>
				<td class="td1" align="center">
					<input value="${sessionScope.loginMember.pw}" name="pw" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">PASSWORD Ȯ�� :&nbsp;</td>
				<td class="td1" align="center">
					<input value="${sessionScope.loginMember.pw}" name="pwChk" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">�̸� :&nbsp;</td>
				<td align="center" class="td1">
					<input value="${sessionScope.loginMember.name}" name="name" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">������� :&nbsp;</td>
				<td align="center" class="td1">
					<fmt:formatDate value="${sessionScope.loginMember.birthday}" pattern="yyyy�� MM�� dd��(E)"/>
				</td>
			</tr>
			<tr>
				<td align="center">������ ���� :&nbsp;</td>
				<td align="center" class="td1">
					<img src="img/${sessionScope.loginMember.photo}"><br>
					<input name="photo" type="file" class="textType">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>����</button>&nbsp;&nbsp;
	</form>
					<button onclick="bye();">Ż��</button>
				</td>
			</tr>
		</table>
</body>
</html>