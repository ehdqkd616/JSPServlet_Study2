<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page errorPage="error/error.jsp" %>

<%-- <%@ page import="java.util.ArrayList" %> --%>
<!-- page지시어 : 현재 JSP페이지를 컨테이너에서 처리하는데 필요한 각종 속성을 기술하는 부분 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(0,null);
		
		System.out.println(list.get(0).charAt(0));
	%>
	expression 출력 : 1부터 10까지의 합은 
	<%=total %> 입니다.<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); %>입니다.<br>
	
	<%-- <%= exception %> 에러페이지가 아닌데선 사용못함 --%>
	
</body>
</html>