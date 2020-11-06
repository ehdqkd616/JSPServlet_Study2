package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 게시글의 총 개수
		// 2. 각 페이지(1, 2, ...) 게시글 목록
		
		BoardService bService = new BoardService(); 
		
		/*
			ㅡㅡㅡㅡㅡ게시글 1ㅡㅡㅡㅡㅡ
			ㅡㅡㅡㅡㅡ게시글 2ㅡㅡㅡㅡㅡ
			ㅡㅡㅡㅡㅡ게시글 3ㅡㅡㅡㅡㅡ	boardLimit
			ㅡㅡㅡㅡㅡ게시글 4ㅡㅡㅡㅡㅡ
			ㅡㅡㅡㅡㅡ게시글 5ㅡㅡㅡㅡㅡ

		currentPage
			 ↓
	  <	1	[2]	3	4	5	6	7	8	9	10 >
	startPage								endPage
	  <	11	12	13	14	15	16	17	18	19	20 >
	  					pageLimit
		.....
											41 maxPage
		1  5  10
		11 12 10
		*/
		
		int listCount;				// 총 게시글 개수
		int currentPage;			// 현재 페이지
		int pageLimit = 10;			// 한 페이지에 표시될 페이징 수
		int maxPage;				// 전체 페이지중 마지막 페이지
		int startPage;				// 페이징된 페이지 중 시작페이지
		int endPage;				// 페이징된 페이지 중 마지막페이지
		int boardLimit = 10;		// 한 페이지에 보일 게시글 수
		
		listCount = bService.getListCount();
		System.out.println(listCount);
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		/*
		 	listCount = 100, boardLimit = 10
		 	100 / 10 = 10.0		=>	10페이지
		 	101 / 10 = 10.1		=>	11페이지
		 	103 / 10 = 10.3		=>	11페이지
		 	109 / 10 = 10.9		=>	11페이지
		 	110 / 10 = 11.0		=>	11페이지
		 	111 / 10 = 11.1		=>	12페이지
		 */
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);		
		
		/*	
		 	<  1  2  3  4  5  6  7  8  9 10>
		 	< 11 12 13 14 15 16 17 18 19 20 >
		 	< 21 22 23 24 25 26 27 28 29 30 >
		 	1, 11, 21, 31, ... => 10 * n + 1 (n >= 0)
		 	
		 	 1 ~ 10 : n = 0
		 	11 ~ 20 : n = 1
		 	21 ~ 30 : n = 2
		 	31 ~ 40 : n = 3
		 	...
		 	n = (currentPage - 1) / pageLimit
		 */
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;	
		
		// 10, 20, 30, 40, ...
		endPage = startPage + pageLimit -1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = bService.selectList(pi);
	
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		}else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


