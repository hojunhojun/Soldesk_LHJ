<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="noticeBBSArea" border="1">
		<tr>
			<td colspan="2" align="right">&nbsp; 
				<c:if test="${sessionScope.loginMember != null}">
					<a href="NoticeWriteController">글쓰기</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<th class="title" style="width: 450px;">제목</th>
			<th class="title">날짜</th>
		</tr>
		<c:forEach var="n" items="${notices}">
			<tr onclick="goNoticeDetail(${n.no});">
				<td>
					&nbsp;${n.title}
				</td>
				<td align="center">
						<fmt:formatDate value="${n.date}" type="date" dateStyle="short" />					
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="2" style="padding: 5px;">
				<c:forEach var="p" begin="1" end="${pageCount}">
					&nbsp;<a href="NoticePageController?page=${p}">${p}</a>&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<form action="NoticeController" method="post">
					<input name="search" id="noticeSearchInput">
					<button id="noticeSearchBtn">검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>