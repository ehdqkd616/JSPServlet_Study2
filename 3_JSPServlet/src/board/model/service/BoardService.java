package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardService {

	
	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDAO().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public int updateCount(int bId) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateCount(conn, bId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);		
		}
		close(conn);
		
		return result;
	}

	public Board selectBoard(int bId) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateCount(conn, bId);
		
		Board board = null;
		if(result > 0) {
			board = dao.selectBoard(conn, bId);
			if(board != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);		
		}
		close(conn);
		
		return board;
	}
	
	public ArrayList<Reply> selectReplyList(int bId) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new BoardDAO().selectReplyList(conn, bId);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.insertReply(conn, r);
		
		ArrayList<Reply> list = null;
		if(result > 0) {
			commit(conn);
			list = dao.selectReplyList(conn, r.getRefBid());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}
	
	public ArrayList selectTList(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		BoardDAO dao = new BoardDAO();
		
		if(i == 1) {
			list = dao.selectBList(conn);
		}else {
			list = dao.selectFList(conn);
		}
		
		close(conn);
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.insertThBoard(conn, b);
		int result2 = dao.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

//	public ArrayList<Attachment> selectThumbnail(int bId) {
//		Connection conn = getConnection();
//		
//		int result = new BoardDAO().updateCount(conn, bId);
//		
//		ArrayList<Attachment> list = null;
//		if(result > 0) {
//			list = new BoardDAO().selectThumbnail(conn, bId);
//		
//			if(list != null) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		} else {
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return list;
//	}
	
	
	public ArrayList<Attachment> selectThumbnail(int bId) {
		Connection conn = getConnection();
				
		ArrayList<Attachment> list = null;
		list = new BoardDAO().selectThumbnail(conn, bId);

		if(list != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
			
		close(conn);
		
		return list;
	}
	
	
}
