<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<style type="text/css">
   .outer{
      width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
      margin-left: auto; margin-right: auto; margin-top: 50px;
   }
   #listArea{text-align: center;}
   .tableArea{width:650px; height:350px; margin:auto;}
   th{border-bottom: 1px solid grey;}
   #writeNoBtn{background: #B2CCFF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th>글번호</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th>조회수</th>
					<th width="100px">작성일</th>
				</tr>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr>
				<%
					} else {
					for (Notice n : list) {
				%>
				<tr>
					<td><%=n.getNoticeNo()%></td>
					<td><%=n.getNoticeTitle()%></td>
					<td><%=n.getNickName()%></td>
					<td><%=n.getNoticeCount()%></td>
					<td><%=n.getNoticeDate()%></td>
				</tr>
				<%
					}
				}
				%>
			</table>
		</div>
		<div align="right">
			<%if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
			<input type="button" onclick="location.href='writeNoticeForm.no'"
				id="writeNoBtn" value="글쓰기">
			<% } %>
		</div>
	</div>

	<script>
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

</body>
</html>