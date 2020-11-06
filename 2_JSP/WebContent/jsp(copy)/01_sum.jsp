<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 10까지의 합 구하기</title>
</head>
<body>
	<!-- HTML주석 -->
	<%-- JSP주석 --%>
	<%-- 두 주석의 차이를 적어보자! --%>
	<%-- 차이 : HTML주석은 페이지소스로 볼 수 있고 JSP주석은 페이지소스로 볼 수 없음--%>
	<%
		// <% % > : 스크립틀릿(자바코드 작성)
		/*  */
		
		int total = 0;
		for(int i = 1; i <= 10; i++){
			total += i;
			
	%>
			짜잔<br>
	<%
		}
		
		System.out.println(total);
	%>
	expression 출력 : 1부터 10까지의 합은 
	<%=total %> 입니다.<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); %>입니다.<br>
	
	
	
	
</body>
</html>