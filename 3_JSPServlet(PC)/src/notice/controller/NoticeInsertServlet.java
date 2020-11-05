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
		<servlet-name>NoticeInsertServlet</servlet-name>
		<servlet-class>notice.controller.NoticeInsertFormServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>NoticeInsertServlet</servlet-name>
		<url-pattern>/insert.no</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/insert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		
		Date sqlDate = null;
		if(date.equals("")) {
			 System.out.println("안들어왔다");
			sqlDate = new Date(new GregorianCalendar().getTimeInMillis());
		} else {
			 System.out.println("들어왔다");
			String[] dateArr = date.split("-");
			int year = Integer.parseInt(dateArr[0]);
			int month = Integer.parseInt(dateArr[1])-1;
			int day = Integer.parseInt(dateArr[2]);
			sqlDate = new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
		}
		
		Notice n = new Notice(title, content, userId, sqlDate);
		int result = new NoticeService().insertNotice(n);
		
		if(result>0) {
			response.sendRedirect("list.no");
		} else {
			request.setAttribute("msg", "공지사항 등록에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
