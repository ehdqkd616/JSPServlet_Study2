<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	Member member = (Member)request.getAttribute("member");

	String userId = member.getUserId();
	String userName = member.getUserName();
	String nickName = member.getNickName();
	String phone = member.getPhone() != null ? member.getPhone() : "-";
	String email = member.getEmail() != null ? member.getEmail() : "-";
	String address = member.getAddress() != null ? member.getAddress() : "-";
	String interest = member.getInterest() != null ? member.getInterest() : "-";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white; color: black;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.outer label, .outer td{color: black;}
	input{margin-top: 2px;}
	#deleteBtn, #goMain, #updateBtn, #pwdUpdateBtn{
		background: #B2CCFF; color: white; border-radius: 5px; width: 110px; heigth: 25px; text-align: center; display:inline-block;
	}
	#deleteBtn:hover, #updateBtn:hover, #goMain:hover, #pwdUpdateBtn:hover {cursor:pointer;}
	#myInfoForm td {text-align: right;}
	#goMain {background: #FFD8D8;}
	#updateBtn {background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
</style>
<title>myPage</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="250px">
						<!-- <input type="text" maxlength="13" id="idid" name="joinUserId" required> -->
						<%= userId %>
						<input type="hidden" name="userId" value="<%= userId %>">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<!-- <input type="text" name="userName" required> -->
						<%= userName %>
						<input type="hidden" name="userName" value="<%= userName %>">
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<!-- <input type="text" maxlength="15" name="nickName" required> -->
						<%= nickName %>
						<input type="hidden" name="nickName" value="<%= nickName %>">
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<!-- <input type="tel" maxlength="11" name="phone" placeholder="(-없이)01012345678"> -->
						<%= phone %>
						<input type="hidden" name="phone" value="<%= phone %>">
						
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<!-- <input type="email" name="email"> -->
						<%= email %>
						<input type="hidden" name="email" value="<%= email %>">
						
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<!-- <input type="text" name="address"> -->
						<%= address %>
						<input type="hidden" name="address" value="<%= address %>">
						
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= interest %>
						<input type="hidden" name="interest" value="<%= interest %>">
					
						<!-- <input type="checkbox" id="sports" name="interest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="interest" value="등산">
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="interest" value="낚시">
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="interest" value="요리">
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="interest" value="게임">
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="interest" value="기타">
						<label for="etc">기타</label> -->
					</td>
				</tr>
			</table>
			
			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				
				<hr width="70%">
				
				<div id="goMain" onclick="location.href='<%= request.getContextPath()%>/index.jsp'">메인으로</div>
				<div id="deleteBtn" onclick="deleteMember();">탈퇴하기</div>
			</div>
		</form>
	</div>
</body>
</html>