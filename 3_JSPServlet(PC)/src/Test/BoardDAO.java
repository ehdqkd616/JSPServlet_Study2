//package Test;
//
//import static common.JDBCTemplate.close;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import board.model.vo.Board;
//import notice.model.vo.Notice;
//
//public class BoardDAO {
//
//	public int updateBoard(Connection conn, Board b) {
//		
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = "UPDATE NOTICE SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_WRITER = ? WHERE NOTICE_NO = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, b.getBoardTitle());
//			pstmt.setString(2, b.getBoardContent());
//			pstmt.setString(3, b.getBoardWriter());
//			pstmt.setInt(4, b.getBoardId());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//}
