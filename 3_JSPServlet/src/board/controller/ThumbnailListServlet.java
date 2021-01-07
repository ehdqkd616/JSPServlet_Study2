package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;

/**
 * Servlet implementation class ThumbnailListServlet
 */
@WebServlet("/list.th")
public class ThumbnailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		BoardService service = new BoardService();
		
		
		ArrayList<Board> bList = service.selectTList(1); // 게시판 리스트 정보 불러오기
		ArrayList<Attachment> fList = service.selectTList(2); // 파일 리스트 정보 불러오기
		
		String page = null;
		if(bList != null && fList != null) {
			request.setAttribute("bList", bList);
			request.setAttribute("fList", fList);
			page = "WEB-INF/views/thumbnail/thumbnailList.jsp";
		}else {
			request.setAttribute("msg", "사진 게시판 조회에 실패했습니다.");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
