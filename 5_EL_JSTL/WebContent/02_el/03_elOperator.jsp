<%@page import="java.util.ArrayList"%>
<%@page import="action.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String str1 = "안녕";
	String str2 = new String("안녕");
	
	int big = 10;
	int small = 3;
	
	Person p1 = new Person("김연우", '남', 24);
	Person p2 = new Person("김연우", '남', 24);
	
	pageContext.setAttribute("str1", str1);
	pageContext.setAttribute("str2", str2);
	pageContext.setAttribute("big", big);
	pageContext.setAttribute("small", small);
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	
	ArrayList<String> list = new ArrayList<String>();
	list.add(str1);
	pageContext.setAttribute("list", list);
	
%>

	<h2>EL연산</h2>
	<p>
		el을 가지고 어떠한 연산 처리를 하는 것이 아닌 속성 값들르 화면에 뿌리는 용도<br>
		하지만 산술 연산 및 논리 연산은 지원하므로 간단한 논리 연산은 자주 사용
	</p>
	
	<h3>산술연산</h3>
	10 * 7 = ${10 * 7}<br>
	100 / 3 = ${100 /3} = ${100 div 3}<br>
	15 % 4 = ${15 % 4} = ${15 mod 4}<br>
	
	<hr>
	
	<h3>비교연산</h3>
	<b>str1 == str2</b><br>
	&emsp; 스크립팅 : <%= str1 == str2 %><br>
	&emsp; el : ${str1 == str2} = ${str1 eq str2}<br>
		
	<br>
		
	<b>str1 != str2</b><br>
	&emsp; 스크립팅 : <%= str1 != str2 %><br>
	&emsp; el : ${str1 != str2} = ${str1 eq str2}<br>
	
	
	<br>
	
	<b>숫자형은 자동 형변환 후 처리</b><br>
	&emsp; big > small : ${ big > small} = ${big gt small}<br>
	&emsp; big < small : ${ big < small} = ${big lt small}<br>
	&emsp; big >= small : ${ big >= small} = ${big ge small}<br>
	&emsp; big <= small : ${ big <= small} = ${big le small}<br>
	
	<br>
	
	<b>객체 비교 p1 == p2</b><br>
	&emsp; 스크립팅 : <%= p1 == p2 %><br>
	&emsp; el : ${p1 == p2} = ${p1 eq p2}<br>
	
	<br>
	
	<b>객체가 null ?또는 비어있는지 체크하는 연산자</b><br>
	&emsp; \${ empty list } = ${ empty list }
	
	<br>
	
	&emsp; ${true and true} = ${true && true}<br>
	&emsp; ${true or false} = ${false || false}<br>
	&emsp; ${ !(big < small) }<br>
	
	
	
</body>
</html>