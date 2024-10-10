<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/page.css">
<script type="text/javascript" src="resources/validCheck.js"></script>
<script type="text/javascript" src="resources/leeValidChecker_v1.0.js"></script>
</head>
<body>
	<form action="unit.convert" name="inputForm" onsubmit="return check();">
		<table>
			<tr>
				<th align="center">단위변환</th>
			</tr>
			<tr>
				<td align="center">변환할 값</td>				
			</tr>
			<tr>
				<td align="center"><input name="num"></td>
			</tr>
			<tr>
				<td align="center">단위</td>
			</tr>
			<tr>
				<td align="center">
					<select name="what">
						<option value="len">cm → inch</option>
						<option value="size">㎥ → 평</option>
						<option value="temp">℃ → ℉</option>
						<option value="speed">km/h → mi/h</option>
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