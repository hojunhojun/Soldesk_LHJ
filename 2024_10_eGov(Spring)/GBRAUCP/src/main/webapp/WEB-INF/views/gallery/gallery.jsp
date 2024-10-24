<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="margin">
		<tr>
			<td>
			</td>
		</tr>
	</table>
	<c:forEach var="p" items="${photos}">
		<table id="galleryArea">
			<tr>
				<td align="center"><img src="resources/imggg/${p.p_photo}">
				</td>
			<tr>
				<td align="center">${p.p_name}</td>
			</tr>
			<c:if test="${p.p_gm_id == sessionScope.loginMember.gm_id}">
				<tr>
					<td align="center" class="buttonArea">
						<button onclick="photoDelete(${p.p_no})">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
	<form id="photoInsertArea" action="photo.insert.do" method="post"
		enctype="multipart/form-data">
		<table id="photoInsertTbl">
			<tr>
				<td align="center"><input type="file" name="p_photo"></td>
				<td rowspan="2" align="center" id="photoInsertTblBtn">
					<button>사진 등록</button>
				</td>
			</tr>
			<tr>
				<td align="center">파일명 : <input name="p_name"> <input
					name="token" type="hidden" value="${token}">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>