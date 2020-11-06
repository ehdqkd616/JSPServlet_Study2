<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jstl fmt</h2>
	<p>날짜, 시간, 숫자 데이터에 출력 형식을 지정하고 싶을 때 사용</p>
	
	<h3>숫자 데이터 포맷 지정 : formatNumber 태그</h3>
	숫자 그대로 출력 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	천단위 구분 기호 : <fmt:formatNumber value="123456789" groupingUsed="true"/><br>	<!-- groupingUsed은 Default가 true -->
	
	<b>실수 값 소숫점 아래 자릿수 지정 : pattern사용</b><br>
	<fmt:formatNumber value="1.234567"/><br>
	#을 사용한 경우 : <fmt:formatNumber value="1.234567" pattern="#.##"/><br>
	#을 사용한 경우 : <fmt:formatNumber value="1.2" pattern="#.##"/><br>
	0을 사용한 경우 : <fmt:formatNumber value="1.2" pattern="#.00"/><br>
	
	
	<br><br>
	
	<b>type속성으로 백분율, 통화기호 표시</b>
	<fmt:formatNumber value="0.12" type="percent"/><br>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>
	
	
	
</body>
</html>