<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP표준액션 태그 중 useBean을 사용하여 VO클래스의 객체 정보 불러오기</h2>
	<%-- <% action.model.vo.Person person1 = new action.model.vo.Person(); --%>
	<jsp:useBean id="person1" class="action.model.vo.Person" scope="request"></jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="person1"/><br>
	성별 : <jsp:getProperty property="gender" name="person1"/><br>
	나이 : <jsp:getProperty property="age" name="person1"/><br>
	
	<hr>
	
	<h2>JSP표준액션 태그 중 useBean을 사용하여 VO클래스에 데이터 초기화하기</h2>
	
	<jsp:useBean id="person2" class="action.model.vo.Person" scope="request"></jsp:useBean>
	
	<jsp:setProperty property="name" name="person2" value="김연우"/>
	<jsp:setProperty property="gender" name="person2" value="M"/>
	<jsp:setProperty property="age" name="person2" value="24"/>
	
	이름 : <jsp:getProperty property="name" name="person2"/><br>
	성별 : <jsp:getProperty property="gender" name="person2"/><br>
	나이 : <jsp:getProperty property="age" name="person2"/><br>	
	
</body>
</html>