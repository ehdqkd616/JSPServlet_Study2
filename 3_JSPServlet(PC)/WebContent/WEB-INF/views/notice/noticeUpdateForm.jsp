<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
<% Notice notice = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeUpdateForm</title>
<style type="text/css">
   .outer{
      width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
      margin-left: auto; margin-right: auto; margin-top: 50px;
   }
   .tableArea {width:450px; height:350px; margin-left:auto; margin-right:auto;}
   #updateNoBtn{background: #B2CCFF;}
   #cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
   <%@ include file="../common/menubar.jsp" %>
   <div class="outer">
      <br>
      <h2 align="center">공지사항 수정</h2>
      <div class="tableArea">
         <form action="<%= request.getContextPath() %>/update.no" method="post">
         <input type="hidden" size="50" name="no" value="<%= notice.getNoticeNo() %>">
			<table>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" size="50" name="title" value="<%=notice.getNoticeTitle()%>">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<%=notice.getNickName()%> 
						<input type="hidden" size="50" name="writer" value="<%=notice.getNoticeWriter()%>">
					</td>
					<th>작성일</th>
					<td>
						<input type="date" name="date" value="<%=notice.getNoticeDate()%>">
					</td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="content" cols="60" rows="15" style="resize: none;"><%=notice.getNoticeContent()%></textarea>
					</td>
				</tr>
			</table>
			<br>
           
            <div align="center">
               <input type="submit" id="updateNoBtn" value="저장">
               <input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
            </div>
         </form>
      </div>
   </div>
</body>
</html>