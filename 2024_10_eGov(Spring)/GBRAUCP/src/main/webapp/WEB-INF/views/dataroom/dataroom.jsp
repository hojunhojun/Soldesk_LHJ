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
	<table id="dataroomtbl">
		<tr>
			<td align="center">
				<table id="dataArea">
					<tr>
							<td align="center">
						<c:forEach var="d" items="${datas}">
							<table class="dataTbl">
								<tr>
									<td align="center" class="td1">
										<a href="resources/data/${d.gd_data}">
										<img src="resources/imggg/folder.png">
										</a> <br>
										${d.gd_name}									
									</td>
									<c:if test="${d.gd_gm_id == sessionScope.loginMember.gm_id}">
									<tr>
										<td align="center">
											<button id="deleteBtn" onclick="dataDelete(${d.gd_no})">삭제하기</button>
										</td>
										</tr>
									</c:if>
								</tr>
							</table>
						</c:forEach>
							</td>						
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<form id="dataInsertArea" action="data.insert.do" method="post"
		enctype="multipart/form-data">
		<table id="dataInsertTbl">
			<tr>
				<td align="center">
					<input type="file" name="gd_data">
				</td>
				<td rowspan="2" align="center" id="dataInsertBtn">
					<button>등록</button>
				</td>
			</tr>
			<tr>
				<td align="center">
					파일명 : <input name="gd_name"> 
					<input name="token" type="hidden" value="${token}">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>