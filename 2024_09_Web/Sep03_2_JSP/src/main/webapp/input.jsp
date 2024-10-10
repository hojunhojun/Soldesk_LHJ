<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>단위변환</title>
<script type="text/javascript" src="validCheck.js"></script>
<script type="text/javascript" src="leeValidChecker_v1.0.js"></script>
<link rel="stylesheet" href="page.css">
</head>
<body>
	<form action="output.jsp" name="inputForm" onsubmit="return check();">
		<table>
			<tr>
				<th align="center">단위변환</th>
			</tr>
			<tr>
				<td align="center">변환할 값</td>				
			</tr>
			<tr>
				<td align="center"><input type="text" name="num"></td>
			</tr>
			<tr>
				<td align="center">단위</td>
			</tr>
			<tr>
				<td align="center">
					<select name="user">
						<option value="cti">cm → inch</option>
						<option value="mtp">㎥ → 평</option>
						<option value="ctf">℃ → ℉</option>
						<option value="ktm">km/h → mi/h</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center"><button>변환</button></td>
			</tr>
		</table>
	</form>
</body>
</html>