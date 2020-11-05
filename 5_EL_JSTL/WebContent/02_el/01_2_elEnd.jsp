<%@page import="action.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Person person = (Person)request.getAttribute("person");
	String beverage = (String)request.getAttribute("beverage");
	int year = (int)request.getAttribute("year");
	String[] products = (String[])request.getAttribute("products") ;
	String book = (String)session.getAttribute("book");
	String movie = (String)application.getAttribute("movie");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptlet을 request 객체에 저장된 데이터 출력하기</h2>
	<h4>개인정보(<%= year %>)</h4>
	이름 : <%= person.getName() %><br>
	성별 : <%= person.getGender() %><br>
	나이 : <%= person.getNai() %><br>
	<h4>취향 정보</h4>
	<%= person.getName() %>님의 가장 좋아하는 음료 : <%= beverage %><br>
	<%= person.getName() %>님의 가장 좋아하는 물건 : <%= products[0] %>, <%= products[1] %>, <%= products[2] %><br>
	<%= person.getName() %>님의 가장 좋아하는 도서 : <%= book %><br>
	<%= person.getName() %>님의 가장 좋아하는 영화 : <%= movie %><br>
	
	<hr>
	
	<h2>EL의 내장객체 XXXScope을 통해 저장된 데이터 출력하기</h2>
	<h4>개인정보(${requestScope.year})</h4>
	이름 : ${requestScope.person.name}<br>
	성별 : ${requestScope.person.gender}<br>
	나이 : ${requestScope.person.nai}<br>
	<h4>취향 정보</h4>
	${requestScope.person.name}님의 가장 좋아하는 음료 : ${requestScope.beverage}<br>
	${requestScope.person.name}님의 가장 좋아하는 물건 : ${requestScope.products[0]},
												 ${requestScope.products[1]},
												 ${requestScope.products[2]}<br>
	${requestScope.person.name}님의 가장 좋아하는 도서 : ${sessionScope.book}<br>
	${requestScope.person.name}님의 가장 좋아하는 영화 : ${applicationScope.movie}<br>
	
	<hr>
	
	<h2>scope을 생략하여 저장된 데이터 출력하기</h2>
	<p>
		el내장객체 pageScope, requestScope, sessionScope, applicationScope는 생략이 가능
		el은 pageScope -> requestScope -> sessionScope -> applicationScope 순으로 찾음
	</p>
	<h4>개인정보(${year})</h4>
	이름 : ${person.name}<br>
	성별 : ${person.gender}<br>
	나이 : ${person.nai}<br>
	<h4>취향 정보</h4>
	${person.name}님의 가장 좋아하는 음료 : ${beverage}<br>
	${person.name}님의 가장 좋아하는 음료 : ${sessionScope.beverage}<br>
	${person.name}님의 가장 좋아하는 음료 : ${applicationScope.beverage}<br>
	${person.name}님의 가장 좋아하는 물건 : ${products[0]},
									${products[1]},
									${products[2]}<br>
	${person.name}님의 가장 좋아하는 도서 : ${book}<br>
	${person.name}님의 가장 좋아하는 영화 : ${movie}<br>
	
</body>
</html>