<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<script type="text/javascript" src="js/move.js"></script>
<body>
	<table id="siteTitleArea">
		<tr>
			<td id="siteMenuArea" align="center">
				<table id="siteMenuArea2">
					<tr>
						<td>
							<a href="NoticeController">��������</a>
							<a href="">�޴�2</a>
							<a href="">�޴�3</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td>
							<a href="HomeController">���� ��� ���� ����Ʈ</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="loginArea" >
				<table>
					<tr>
						<td>
							<jsp:include page="${loginPage}"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage}"></jsp:include>
			</td>
		</tr>
	</table>
	<div id="result">${result}</div>
</body>
</html>