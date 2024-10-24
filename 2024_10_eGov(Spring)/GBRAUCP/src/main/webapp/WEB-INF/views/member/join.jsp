<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" method="post" enctype="multipart/form-data" name="joinForm" onsubmit="return joinCheck();">
		<table id="joinTbl">
			<tr>
				<td class="td2" align="center">
					ID : <input class="i1" name="gm_id">
				</td>
			</tr>
			<tr>
				<td class="td2" align="center">
					PW : <input class="i1" name="gm_pw" type="password">
				</td>
			</tr>
			<tr>
				<td class="td2" align="center">
					PW 확인 :<input class="i1" name="gm_pwchk" type="password">
				</td>
			</tr>
			<tr>
				<td class="td2" align="center">
					주민번호 : <input name="gm_jumin1" class="i2" placeholder="XXXXXX" maxlength="6">
					&nbsp;-&nbsp;<input name="gm_jumin2" class="i3" placeholder="X" maxlength="1">XXXXXX
				</td>
			</tr>
			<tr>
				<td class="td2" align="center">
					Photo : <input class="i1" name="gm_photo" type="file">
				</td>
			</tr>
			<tr>
				<td class="td2" align="center">
					<button>가입하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>