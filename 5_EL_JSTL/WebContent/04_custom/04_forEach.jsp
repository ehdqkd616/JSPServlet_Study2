<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		for(int i = 1; i <=6; i++){
			로직 기술
		}
	 -->
	<c:forEach var="i" begin="1" end="6">
		<h<c:out value="${i}"/>>반복문</h<c:out value="${i}"/>>
		<h${i}>반복문</h${i}>
	</c:forEach>

	<hr>

	<c:forEach var="i" begin="1" end="6" step="2">
		<h${i}>건너뛰기</h${i}>
	</c:forEach>

	<hr>

	<c:forEach var="i" begin="1" end="6">
		<h${7-i}>역순</h${7-i}>
	</c:forEach>
	
	<hr>
		
	<c:forEach var="i" begin="1" end="6" varStatus="vs">
		vs.first : ${vs.first}<br>
		vs.last : ${vs.last}<br>
		vs.index : ${vs.index}<br>
		vs.count : ${vs.count}<br>
		vs.current : ${vs.current}<br><br>
		
		
	</c:forEach>	
	
	
</body>
</html>