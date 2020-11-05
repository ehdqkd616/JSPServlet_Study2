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
	<h2>== 이용</h2>
	<c:if test="${param.str1 == param.str2}">
		${param.str1}와 ${param.str2}는 같습니다.
	</c:if>
	<c:if test="${param.str1 != param.str2}">
		${param.str1}와 ${param.str2}는 다릅니다.
	</c:if>
	
	<hr>
	
	<h2>eq 이용</h2>
	<c:if test="${param.str1 eq param.str2}">
		${param.str1}와 ${param.str2}는 같습니다.
	</c:if>
	<c:if test="${param.str1 ne param.str2}">
		${param.str1}와 ${param.str2}는 다릅니다.
	</c:if>
	
	<hr>
	
	<h2>equals 이용</h2>
	<c:if test="${param.str1.equals(param.str2)}">
		${param.str1}와 ${param.str2}는 같습니다.
	</c:if>
	<c:if test="${!param.str1.equals(param.str2)}">
		${param.str1}와 ${param.str2}는 다릅니다.
	</c:if>

	<hr>

</body>
</html>