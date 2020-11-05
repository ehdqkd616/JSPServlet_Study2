//package Test;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.util.GregorianCalendar;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import notice.model.vo.Notice;
//
//
//@WebServlet("/bdetail")
//public class BoardUpdateServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//
//    public BoardUpdateServlet() {
//        super();
//    }
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		int bId = Integer.parseInt(request.getParameter("bId"));
//		String title = request.getParameter("title");
//		String writer = request.getParameter("wrtier");
//		String content = request.getParameter("content");
//		
//		Board board = new Board(bId, title, writer, content);		
//		int result = new BoardService().updateBoard(board);
//		
//		if(result>0) {
//			response.sendRedirect("list.bo");
//			request.getSession().setAttribute("msg", "공지사항이 수정되었습니다.");
//		} else {
//			request.setAttribute("msg", "공지사항 수정에 실패했습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
