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
					<input name="title" maxlength="40" placeholder="제목" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" maxlength="456"placeholder="내용" autocomplete="off" rows="" cols=""></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>쓰기</button>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>