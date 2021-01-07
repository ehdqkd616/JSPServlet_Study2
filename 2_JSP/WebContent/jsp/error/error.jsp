<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1 style="color:red;">에러가 났습니다아으아ㅜ아ㅜ아으ㅏ으ㅏ우ㅏ</h1>
	exception : <%= exception %><br>
	exception.getMessage() : <%= exception.getMessage() %><br>
	exception.getClass().getName() : <%= exception.getClass().getName() %><br>
	
</body>
</html>