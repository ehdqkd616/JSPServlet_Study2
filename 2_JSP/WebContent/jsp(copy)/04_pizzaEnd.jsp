<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String select = (String)request.getAttribute("select");
	String side = (String)request.getAttribute("side");
	String topping = (String)request.getAttribute("topping");
	int price = (int)request.getAttribute("price");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>주문 내역</h2>
<h3>피자는 <b style="color: red;"><%=select %></b>, 토핑은 <b style="color: green;"><%=topping %></b>, 사이드는 <b style="color: blue;"><%=side %></b> 주문하셨습니다.</h3>
<br><br><br>
<h3>총합 : <b style="text-decoration:underline;"><%=price %>원</b></h3>
<br><br>
<h1 style="color: pink;">즐거운 식사시간 되세요~</h1>
</body>
</html>