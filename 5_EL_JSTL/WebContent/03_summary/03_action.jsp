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
	<jsp:useBean id="person" class="action.model.vo.Person">
 		<jsp:setProperty property="name" name="person" param="name"/>
		<jsp:setProperty property="gender" name="person" param="gender"/>
		<jsp:setProperty property="nai" name="person" param="age"/>
	</jsp:useBean>
	
	<h2>개인정보 입력 결과(action)</h2>
	<table>
		<tr>
			<td>성명</td>
			<td><jsp:getProperty property="name" name="person"/></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><jsp:getProperty property="gender" name="person"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><jsp:getProperty property="nai" name="person"/></td>
		</tr>
	</table>
		
</body>
</html>