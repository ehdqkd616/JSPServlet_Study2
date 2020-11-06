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
	<h1>jstl core라이브러리</h1>
	<p>
		사용할 태그 라이브러리 선언하기 : taglib 지시자 이용<br>
		prefix : 앞 첨자, 다른 태그와 구별할 수 있는 name space 제공<br>
		uri : 실제 웹 주소가 아니라 태그 라이브러리를 나타내는 식별자
	</p>
	<h2>c:set태그</h2>
	<!-- 변수 선언, 기본 scope는 page -->
	첫 번째 수 : ${param.num1}<br>
	두 번째 수 : ${param.num2}<br>
	<c:set var="no1" value="${param.num1}"></c:set>
	<c:set var="no2" value="${param.num2}"></c:set>
	
	${param.num1} 곱하기 ${param.num2}의 값은? ${param.num1 * param.num2} <br>
	${no1} 곱하기 ${no2}의 값은? {no1 * no2} <br>
	
	<c:set var="result" value="${no1 * no2}"/>
	${no1} 곱하기 ${no2}의 값은? ${result}
	
	<hr>
	
	<h2>c:remove태그</h2>
	<!-- 지정한 변수를 모든 scope에서 검색해 삭제하거나 지정한 scope에서 삭제 -->
	<c:set var="result" value="9999" scope="request"/>
	삭제 전\${result} : ${result}<br>
	삭제 전\${requestScope.result} : ${requestScope.result}<br>
	
	<!-- 모든 scope에서 result라는 이름을 가진 변수를 삭제 -->
<%-- 	<c:remove var="result"/> --%>
	<c:remove var="result" scope="request"/>
	삭제 후\${result} : ${result}<br>
	삭제 후\${requestScope.result} : ${requestScope.result}<br>
	
	
	
	
	

	
	
</body>
</html>