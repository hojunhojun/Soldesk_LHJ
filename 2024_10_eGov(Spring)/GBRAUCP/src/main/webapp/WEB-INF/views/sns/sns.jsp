<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${page != 1}">
		<div id="snsPageLeft">
			<img src="resources/imggg/arrowleft.png"
				onClick="snsPageTest(${page - 1});">
		</div>
	</c:if>
	<c:if test="${page != pageCount }">
		<div id="snsPageRight">
			<img src="resources/imggg/arrowright.png"
				onClick="snsPageTest(${page + 1});">
		</div>
	</c:if>
	<div id="blank1"></div>
	<c:forEach var="sp" items="${posts}">
		<table class="aSNSPost">
			<tr>
				<td rowspan="5" class="td1" align="center"><img
					src="resources/imggg/${sp.gm_photo}"></td>

				<td align="center">${sp.gs_writer}</td>
			</tr>
			<tr>
				<td align="center">${sp.gs_date}</td>
			</tr>
			<tr>
				<td align="center">${sp.gs_txt}</td>
			</tr>
			<tr>
				<td align="center">
					<hr>
					<c:forEach var="sr" items="${sp.gs_replys}">
						(ID : ${sr.gsr_writer}) <fmt:formatDate value="${sr.gsr_date}" type="both" dateStyle="short" timeStyle="short"/><br>
						(Text : ${sr.gsr_txt})<br>
						<c:if test="${sr.gsr_writer == sessionScope.loginMember.gm_id}">
							<button onclick="snsReplyUpdate(${sr.gsr_no}, '${sr.gsr_txt}')">댓글수정</button>
							<button onclick="snsReplyDelete(${sr.gsr_no})">댓글삭제</button><hr>
						</c:if>
					</c:forEach>
					<form action="sns.reply.write" name="snsReplyWriteForm"
						onsubmit="return snsReplyWriteCheck(this);">
						<!-- this == 해당폼 -->
						<input name="token" value="${token}" type="hidden"> <input
							name="gsr_gs_no" value="${sp.gs_no}" type="hidden"> <span
							class="srWriter">${sessionScope.loginMember.gm_id}</span>&nbsp; <input
							class="srTxt" name="gsr_txt">&nbsp;
						<button class="srButton">쓰기</button>
					</form></td>
			</tr>
			<c:if test="${sp.gs_writer == sessionScope.loginMember.gm_id}">
				<tr>
					<td colspan="2" align="right">
						<button
							onclick="snsPostUpdate(${sp.gs_no}, '${sp.gs_txt}', ${page})">수정</button>
						<button onclick="snsPostDelete(${sp.gs_no}, ${page})">삭제</button>
					</td>
				</tr>

			</c:if>
		</table>
	</c:forEach>
	<form action="sns.search">
		<table id="snsSearchArea">
			<tr>
				<td class="td1" align="center"><input name="search"
					placeholder="검색"></td>
				<td class="td1" align="center">
					<button>검색</button>
				</td>
			</tr>
		</table>
	</form>
	<form action="sns.post.write" name="snsWriteForm"
		onsubmit="return snsWriteCheck();" method="post">
		<input name="token" value="${token}" type="hidden">
		<table id="snsWriteArea">
			<tr>
				<td align="center"><textarea name="gs_txt" maxlength="456"
						placeholder="내용" autocomplete="off" rows="" cols=""></textarea></td>
			</tr>
			<tr>
				<td align="center">
					<button>작성하기</button>
				</td>
			</tr>
		</table>
	</form>
	<div id="blank2"></div>
</body>
</html>