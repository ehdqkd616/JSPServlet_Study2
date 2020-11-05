<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="family">신형만, 봉미선, 신짱구, 신짱아</c:set> <!--4개를 잘라줄거야  -->
	<c:forTokens items="${ family }" delims="," var="f"> <!--items:자를 변수 , delims:기준, var:결과  -->
      ${ f }
   	</c:forTokens>

	<hr>

	<c:set var="familiesMultiDelimeter">신형만,봉미선/신짱아.신짱,둘리 도우너,또치/희동이</c:set>
	<c:forTokens items="${ familiesMultiDelimeter }" delims=",/." var="f"> <!--delims는 여러개도 가능하다  -->
      ${ f }
   </c:forTokens>

</body>
</html>