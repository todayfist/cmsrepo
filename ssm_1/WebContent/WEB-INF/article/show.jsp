<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${path}/userheadlines/bootstrap/css/bootstrap.css" />
<title>Insert title here</title>
<style type="text/css">
.out {
	width: 768px;
	margin: auto;
	/* text-align: center; */
}

.title {
	margin-bottom: 60px;
}
</style>
</head>
<body >
	
	<c:forEach var="ll" items="${articlelist}">
		<div class="out">
			<div  class="title"
				style="background-color: #999999; border-radius: 25px;text-align: center;">
				<h1>${ll.headline}</h1>
			</div>
			<div>${ll.content}</div>
			<div><a href="${path }/article/articledelete?id=${ll.id}">删除</a></div>
			<div><a href="${path }/article/articlebyid?id=${ll.id}">更改</a></div>
		</div>
	</c:forEach>
</body>
</html>