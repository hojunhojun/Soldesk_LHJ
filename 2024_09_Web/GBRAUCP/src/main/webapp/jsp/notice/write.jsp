<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="NoticeWriteController" name="NoticeWriteForm" onsubmit="return noticeWriteCheck();" method="post">
		<table id="noticeWriteTbl">
			<tr>
				<td align="center">
					<input name="title" maxlength="40" placeholder="����" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" maxlength="456"placeholder="����" autocomplete="off" rows="" cols=""></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>����</button>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>