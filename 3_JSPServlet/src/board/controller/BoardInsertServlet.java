//package board.controller;
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
//import javax.websocket.Session;
//
//import board.model.service.BoardService;
//import member.model.vo.Member;
//
///**
// * Servlet implementation class BoardInsertServlet
// */
//@WebServlet("/insert.bo")
//public class BoardInsertServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BoardInsertServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		int cid = Integer.parseInt(request.getParameter("category"));
//		String btitle = request.getParameter("title");
//		String bcontent = request.getParameter("content");
//		String bwriter = ((Member)session.getAttribute("loginUser")).getUserId();
//		
//		int result = new BoardService().insertBoard(cid, btitle, bcontent, bwriter);
//		String page = "";
//		if(result > 0) {
//			response.sendRedirect("list.bo");
//		}else {
//			request.setAttribute("msg", "게시글 작성에 실패했습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
