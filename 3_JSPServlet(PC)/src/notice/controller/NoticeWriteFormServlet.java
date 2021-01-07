package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/* 
	<servlet>
		<servlet-name>NoticeWriteFormServlet</servlet-name>
		<servlet-class>notice.controller.NoticeWriteFormServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>NoticeWriteFormServlet</servlet-name>
		<url-pattern>/writeNoticeForm.no</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/writeNoticeForm.no")
public class NoticeWriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeWriteFormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/notice/noticeWriteForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}