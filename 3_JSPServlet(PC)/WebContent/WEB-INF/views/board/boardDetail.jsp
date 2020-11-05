<%@page import="board.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Board board = (Board)request.getAttribute("board");
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail</title>
<style>
	.outer{
		width:800px; min-height:500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.tableArea {width: 450px; height:350px; margin-left:auto; margin-right:auto; align: center;}
	table{align: center;}
	#updateBtn{background: #B2CCFF;}
	#menuBtn{background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
	#addReply{background: #FFD8D8;}
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
					<% if(board.getBoardWriter().equals(loginUser.getUserId()) && loginUser != null) { %>
					<input type="submit" id="updateBtn" value="수정">
					<input type="button" onclick="deleteBoard();" id="deleteBtn" value="삭제">
					<% } %>
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.bo'" id="menuBtn" value="메뉴로">
				</div>
			</form>
		</div>
		
		<div class="replyArea">
			<div class="replyWriteArea">
				<table>
					<tr>
						<td>댓글 작성</td>
						<td><textarea rows="3" cols="80" id="replyContent" style="resize: none;"></textarea></td>
						<td><input type="button" id="addReply" value="댓글 등록"></td>
				</table>
			</div>
		</div>
		
		<div id="replySelectArea">
			<table id="replySelectTable">
				<% if(list.isEmpty()){ %>
				<tr><td colspan="3">댓글이 없습니다</td></tr>
				<% } else { %>
					<% for(int i = 0; i < list.size(); i++){ %>
					<tr>
						<td width="100px"><%= list.get(i).getReplyWriter() %></td>
						<td width="400px"><%= list.get(i).getReplyContent() %></td>
						<td width="200px"><%= list.get(i).getCreateDate() %></td>
					</tr>
					<% } %>
				<% } %>
			</table>
		</div>
	</div>
	
	<script>
		$(function(){
			$('#addReply').click(function(){
				var writer = '<%= loginUser.getUserId() %>';
				var bId = <%= board.getBoardId() %>
				var content = $('#replyContent').val();
				
				$.ajax({
					url : 'insertReply.do',
					data : {writer:writer, content:content, bId:bId},
					success: function(data){
						$replyTable = $('#replySelectTable');
						$replyTable.html("");
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].replyWriter).css('width', '100px');
							var $contentTd = $('<td>').text(data[key].replyContent).css('width', '400px');
							var $dateTd = $('<td>').text(data[key].createDate).css('width', '200px');
		
							$tr.append($writerTd);
							$tr.append($contentTd);
							$tr.append($dateTd);
							$replyTable.append($tr);
						
						}
						$("#replyContent").val("");
					}
				});
			});
		});
	</script>
	
</body>
</html>