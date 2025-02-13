<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function nickValue(){
		// 회원가입 페이지에 있는 joinUserId value를 팝업창에 inputId value 공간에 집어넣음
		if('<%=request.getAttribute("checkedNick") %>' == 'null'){
			document.getElementById('inputNick').value
				= opener.document.joinForm.nickName.value;
			// 나를 불러들인 페이지를 호출하는 코드 opener
			// name을 따라가기 때문에 id로 호출하면안됨
		} else{
			document.getElementById('inputNick').value = '<%=request.getAttribute("checkedNick") %>';
		}

	}
	
	function usedNick(){
		opener.document.joinForm.nickName.value = 
			document.getElementById('inputNick').value;
		self.close();
	}
</script>
</head>
<body onload="nickValue();">
	<b>닉네임 중복 체크</b>
	<br>
	<form action="<%= request.getContextPath() %>/nickCheck.me" id="nickCheckForm">
		<input type="text" id="inputNick" name="inputNick">
		<input type="submit" value="중복확인">
	</form>
	
	<br>
	
	<%
		if(request.getAttribute("result") != null){
			int result = (int)request.getAttribute("result");
			
			if(result > 0){
	%>
				이미 사용 중인 닉네임입니다.
	<%	
			}else{
	%>
				사용 가능한 닉네임입니다.
	<%
			}
		}
	%>
	
	<br>
	<br>
	
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	<input type="button" id="usedId" value="확인" onclick="usedNick();">

</body>
</html>