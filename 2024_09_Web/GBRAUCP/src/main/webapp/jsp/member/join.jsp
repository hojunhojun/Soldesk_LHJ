<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/leeValidChecker_v1.0.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<form action="JoinController" onsubmit="return joinCheck();" name="JoinForm"
				method="post" enctype="multipart/form-data">
		<table id="joinTbl">
			<tr>
				<td align="center">ID :&nbsp;</td>
				<td>
					<input name="id" maxlength="10" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">PASSWORD :&nbsp;</td>
				<td>
					<input name="pw" type="password" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">PASSWORD 확인 :&nbsp;</td>
				<td>
					<input name="pwChk" type="password" maxlength="10">
				</td>
			</tr>
			<tr>
				<td align="center">이름 :&nbsp;</td>
				<td>
					<input name="name" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">생년월일 :&nbsp;</td>
				<td>
					<select name="y">
						<c:forEach var="y" begin="${curYear-100}" end="${curYear}">
							<option>${y}</option>
						</c:forEach>
					</select>년&nbsp;&nbsp;
					<select name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m}</option>
						</c:forEach>
					</select>월&nbsp;&nbsp;
					<select name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d}</option>
						</c:forEach>
					</select>일
				</td>
			</tr>
			<tr>
				<td align="center">프로필 사진 :&nbsp;</td>
				<td>
					<input name="photo" type="file">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>가입</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>