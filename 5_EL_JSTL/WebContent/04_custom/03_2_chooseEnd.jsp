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
	<h2>나머지가 0 ==> 인형, 1 == > 오토바이 장난감, 2 ==> 라이터</h2><br>
	<c:choose>
		<c:when test="${Integer.parseInt(param.num1) % 5 == 0}">
			인형을 뽑았습니다.
		</c:when>
		<c:when test="${Integer.parseInt(param.num1) % 5 == 1}">
			오토바이 장난감을 뽑았습니다.
		</c:when>
		<c:when test="${Integer.parseInt(param.num1) % 5 == 2}">
			라이터를 뽑았습니다.
		</c:when>				
		<c:otherwise>
			꽝입니다.
		</c:otherwise>
		
		
	</c:choose>
	
	
	
</body>
</html>