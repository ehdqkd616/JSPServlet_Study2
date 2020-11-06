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

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/update.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
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
		
		Notice notice = new Notice(no, title, content, sqlDate);
		int result = new NoticeService().updateNotice(notice);
		
		if(result>0) {
			response.sendRedirect("list.no");
			request.getSession().setAttribute("msg", "공지사항이 수정되었습니다.");
		} else {
			request.setAttribute("msg", "공지사항 수정에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
