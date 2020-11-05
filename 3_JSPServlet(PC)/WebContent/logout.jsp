<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.vo.*"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div>
		<label><%=loginUser.getName()%>님</label>
		<div>
			<button>정보수정</button>
			<button id="logoutBtn" onclick="logout();">로그아웃</button>
		</div>
	</div>
</body>
<script>
	
	function logout(){
		location.href="<%=request.getContextPath()%>/logout";
	}

	$(function(){
	    $("#listArea td").mouseenter(function(){
	       $(this).parent().css({'background':'darkgray','cursor':'pointer'});
	    }).mouseout(function(){
	       $(this).parent().css('background', 'none');
	    }).click(function(){
	       var num = $(this).parent().children().eq(0).text();
	       location.href="<%=request.getContextPath()%>/detail.no?no="+ num;
		});
	    
			var msg = "<%= msg %>";
		
			if(msg != "null"){
			alert(msg);
		}
	});
</script>
</html>