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
	<h2>String 값으로 비교</h2>
	<c:if test="${param.num1 > param.num2}">
		${param.num1}은 큽니다, ${param.num2}보다
	</c:if>
	<c:if test="${param.num1 < param.num2}">
		${param.num2}은 큽니다, ${param.num1}보다
	</c:if>
	
	<hr>
	
	<h2>int 값으로 비교</h2>
	<c:if test="${Integer.parseInt(param.num1) > Integer.parseInt(param.num2)}">
		${param.num1}은 큽니다, ${param.num2}보다
	</c:if>	
	<c:if test="${Integer.parseInt(param.num1) < Integer.parseInt(param.num2)}">
		${param.num2}은 큽니다, ${param.num1}보다
	</c:if>
	
	<hr>
	
	<h2>==로 비교</h2>
	<c:if test="${param.num1 == param.num2}">
		${param.num1}는 같습니다, ${param.num2} 값과
	</c:if>
	
	
	
</body>
</html>