<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getParameter("name");
	char gender = request.getParameter("gender").charAt(0);
	int age = Integer.parseInt(request.getParameter("age"));
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인정보 입력 결과(scriptlet)</h2>
	<table>
		<tr>
			<td>성명</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%= gender %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%= age %></td>
		</tr>
	</table>
</body>
</html>