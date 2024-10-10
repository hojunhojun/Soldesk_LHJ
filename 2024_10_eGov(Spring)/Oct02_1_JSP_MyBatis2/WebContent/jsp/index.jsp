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
	${result}
	<form action="ImgUploadController" method="post" enctype="multipart/form-data">
		제목 : <input name="title"> <p>
		그림 : <input type="file" name="img"><p>
		<button>업로드</button>
	</form>
	<hr>
	<c:forEach var="i" items="${imgs2}">
		<img src="imggg/${i.o_file}"> <br>
		${i.o_no}) ${i.o_name} - ${i.o_date} <br>
	</c:forEach>
	<c:forEach var="p" begin="1" end="${pageCount}">
		&nbsp;<a href="ImgPageController?page=${p}">${p}</a>&nbsp;
	</c:forEach>
</body>
</html>