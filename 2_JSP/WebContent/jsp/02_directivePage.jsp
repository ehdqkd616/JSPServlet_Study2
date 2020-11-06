<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %> --%>
    <!--  언어유형 지정,웹자체가 받아올 인코딩 형식,page~:jsp자체가 읽어올 자체의 인코딩 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ page errorPage="error/error.jsp" %>
 
<%@ page import="java.util.ArrayList" %>
<!-- page지시어 : 현재 JSP페이지를 컨테이너에서 처리하는데 필요한 각종 속성을 기술하는 부분 -->
<!-- 임폴트만 밖으로 빼낼수있음 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directivePage</title>
</head>
<body>
   <!-- HTML주석 -->
   <%-- JSP주석 --%>
   <%-- 두 주석의 차이를 적어보자! --%>
   <%-- 차이 : HTML주석은 페이지소스로 볼 수 있고 JSP주석은 페이지소스로 볼 수 없음--%>
   <%
      // 자바 코드 기술 이므로  /* */,  <- 사용가능
    
      // <% % > : 스크립틀릿(자바코드 작성)
      /*  */
      
      int total = 0;
      
         for(int i =1; i<=10; i++){
         total += i;
      %>
         이렇게도 쓸 수 있지롱~~~? <br>
      <%
         }
      
       ArrayList<String> list = new ArrayList<String>();
       list.add(0, null);
         
       System.out.println(list.get(0).charAt(0));
   %>
      
         expression 출력 : 1부터 10까지의 합은
         <span style="color: red; font-size: 16pt;"><%= total %></span>입니다. <br>
      
         scriptlet 출력 : 1부터 10까지의 합은
         <span style="color: blue; font-size: 16pt;"><% out.println(total); %></span>입니다.
      
      <%-- <%= exception %> 에러페이지가 아닌데선 사용못함 --%>
   
</body>
</html>



