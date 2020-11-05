//package Test;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/binsert")
//public class BoardWriteServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    public BoardWriteServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setCharacterEncoding("UTF-8");
//		
//		HttpSession session = request.getSession();
//		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = ((Member)session.getAttribute("loginUser")).getUserId();
//		
//		int result = new BoardService().insertBoard(title, content, writer);
//		String page = "";
//		
//		if(result > 0) {
//			response.sendRedirect("list.bo");
//		}else {
//			request.setAttribute("msg", "게시글 작성에 실패했습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}
