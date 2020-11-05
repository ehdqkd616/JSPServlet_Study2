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
	<%
		String[] nameArr = {"신형만", "봉미선", "신짱구", "신짱아"};
		request.setAttribute("family", nameArr);
		
		for(String name : nameArr) {
	%>
		<%= name %>		
	<% 	} %>
	
	<hr>
	
	<c:forEach items="${family}" var="f">
		${f}
	</c:forEach>
	
			
</body>
</html>