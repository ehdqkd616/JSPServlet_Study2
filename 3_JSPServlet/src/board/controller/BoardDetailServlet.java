package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

@WebServlet("/detail.bo")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		Board board = new BoardService().selectBoard(bId);	
		
		String page = null;
		if(board != null) {
			page = "WEB-INF/views/board/boardDetail.jsp";
			request.setAttribute("board", board);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세조회에 실패하였습니다.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
