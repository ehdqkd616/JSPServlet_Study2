<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인" />
	</form>
	
	<br>
	
	<%
		if(request.getAttribute("result") != null){
			int result = (int)request.getAttribute("result");
			
			if(result > 0){
	%>
				이미 사용중인 아이디 입니다.
	<%
			} else{
	%>
				 사용 가능한 아이디입니다.
	<%
			}
		}
	%>
	
	
	<br>
	<br>
	
	<input type="button" id="userId" value="확인" onclick="usedId();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
//			document.getElementById("inputId").value = opener.document.joinForm.joinUserId.value;
			if('<%= request.getAttribute("checkedId") %>' == 'null'){
				document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;				
			} else{
				document.getElementById('inputId').value = "<%= request.getAttribute("checkedId") %>";
			}
		
		}
		
		function usedId(){
			opener.document.joinForm.joinUserId.value = document.getElementById("inputId").value;
			
			self.close();
		}
		
	</script>
	
</body>
</html>


