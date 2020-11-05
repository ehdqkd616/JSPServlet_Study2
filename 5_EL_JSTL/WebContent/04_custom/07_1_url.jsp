<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="07_2_urlEnd.jsp?pname=lg그램&pcount=30&option=ssd&option=gpu">07_2_urlEnd.jsp(쿼리스트링)</a>
	
	<hr>
	
	<c:url value="07_2_urlEnd.jsp" var="u">
		<c:param name="pname" value="lg그램"/>
		<c:param name="pcount" value="30"/>
		<c:param name="option" value="ssd"/>
		<c:param name="option" value="gpu"/>
	</c:url>
	
	<a href="${u}">07_2_urlEnd.jsp(jstl)</a>
	
</body>
</html>