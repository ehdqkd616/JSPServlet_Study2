//package Test;
//
//import static common.JDBCTemplate.close;
//import static common.JDBCTemplate.commit;
//import static common.JDBCTemplate.getConnection;
//import static common.JDBCTemplate.rollback;
//
//import java.sql.Connection;
//
//import board.model.vo.Board;
//import notice.model.dao.NoticeDAO;
//import notice.model.vo.Notice;
//
//public class BoardService {
//	
//	public int updateNotice(Board board) {
//		
//		Connection conn = getConnection();
//		
//		int result = new BoardDAO().updateBoard(conn, board);
//		
//		if(result > 0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
//		close(conn);
//		return result;
//	}
//	
//}
