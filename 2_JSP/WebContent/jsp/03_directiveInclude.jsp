<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%--<%	
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>--%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directiveInclude</title>
</head>
<body>
<%-- <%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>
	<h2>오늘 날짜<span style="color:lightgray"><%= today %></span></h2> --%>
	
	<h2>오늘 날짜<span style="color:pink"><%@ include file="today.jsp" %></span></h2>

	<% String today2 = "오늘은 순대국밥을 먹었습니다."; %>
	
	<%= today2 %>
	
	
	
</body>
</html>