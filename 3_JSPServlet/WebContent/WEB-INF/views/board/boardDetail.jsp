<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail</title>
<style>
	.outer{
		width:800px; height:500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.tableArea {width: 450px; height:350px; margin-left:auto; margin-right:auto; align: center;}
	table{align: center;}
	#updateBtn{background: #B2CCFF;}
	#menuBtn{background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세보기</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/boardUpdateForm.bo" id="detailForm" method="post">
				<table>
					<tr>
						<th>분야</th>
						<td><%= board.getCategory() %></td>
						<th>제목</th>
						<td colspan="3"><%= board.getBoardTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%= board.getBoardWriter() %></td>
						<th>조회수</th>
						<td><%= board.getBoardCount() %></td>
						<th>작성일</th>
						<td><%= board.getCreateDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="6">
							<textarea cols="60" rows="15" style="resize:none;" readonly><%= board.getBoardContent() %></textarea>
						</td>
					</tr>
				</table>
				
				<div align="center">
					<input type="submit" id="updateBtn" value="수정">
					<input type="button" onclick="deleteBoard();" id="deleteBtn" value="삭제">
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.bo'" id="menuBtn" value="메뉴로">
				</div>
			</form>
		</div>
	</div>
</body>
</html>