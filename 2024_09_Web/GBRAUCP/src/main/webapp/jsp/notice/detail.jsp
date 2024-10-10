<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="noticeDetailTbl">
	<form name="noticeUpdateForm" onsubmit="return noticeUpdateCheck();" action="NoticeDetailController" method="post">
		<input name="no" value="${n.no }" type="hidden">
			<tr>
				<th colspan="2">
					<input name="title"value="${n.title }" autocomplete="off">
				</th>
			</tr>
			<tr>
				<td align="center" class="td1" rowspan="2">
					<img alt="" src="img/${photo }">
				</td>
				<td class="td2">
					&nbsp;${n.writer }
				</td>
			</tr>
			<tr>
				<td align="right">
					<fmt:formatDate value="${n.date }" type="both" 
						dateStyle="long" timeStyle="short"/>&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<textarea name="txt" autocomplete="off">${n.txt }</textarea>
				</td>
			</tr>
			<c:choose>
				<c:when test="${n.writer == sessionScope.loginMember.id }">
					<tr>
						<td colspan="2" align="center">
							<button>수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
				</form>
							<button onclick="deleteNotice(${n.no});">삭제</button>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					</form>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="2">
					<c:forEach var="r" items="${replys}">
						${r.writer} - ${r.txt}(${r.date})<br>
					</c:forEach>
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember != null}">
				<tr>
					<td colspan="2">
						<form action="NoticeReplyWriteController" onsubmit="noticeRelplyWriteCheck();" name="noticeReplyWriteForm">	
							<input name="no" value="${n.no }" type="hidden">				
							&nbsp;<input id="noticeReplyInput" name="txt"> <button>쓰기</button>
						</form>
					</td>
				</tr>
			</c:if>
		</table>
</body>
</html>




