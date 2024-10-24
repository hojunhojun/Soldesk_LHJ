<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="infoArea">
	<form action="member.update" onsubmit="return memberUpdateCheck();" method="post" enctype="multipart/form-data">
			<tr>
				<td align="center">ID : &nbsp;</td>
				<td align="center">${sessionScope.loginMember.gm_id}</td>
			</tr>
			<tr>
				<td align="center">PASSWORD :&nbsp;</td>
				<td class="td1" align="center">
					<input value="${sessionScope.loginMember.gm_pw}" name="gm_pw" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">PASSWORD 확인 :&nbsp;</td>
				<td class="td1" align="center">
					<input value="${sessionScope.loginMember.gm_pw}" name="gm_pwChk" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">생년월일 :&nbsp;</td>
				<td align="center" class="td1">
					<fmt:formatDate value="${sessionScope.loginMember.gm_birthday}" pattern="yyyy년 MM월 dd일(E)"/>
				</td>
			</tr>
			<tr>
				<td align="center">프로필 사진 :&nbsp;</td>
				<td align="center" class="td1">
					<img src="resources/imggg/${sessionScope.loginMember.gm_photo}"><br>
					<input name="gm_photo" type="file" class="textType">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>&nbsp;&nbsp;
	</form>
					<button onclick="bye();">탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>