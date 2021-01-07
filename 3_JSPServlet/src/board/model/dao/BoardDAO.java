package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardDAO {

//	private Properties prop = new Properties();

	public BoardDAO() {}
//		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
//
//		try {
//			prop.load(new FileReader(fileName));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public int getListCount(Connection conn) {
		// getListCount=SELECT COUNT(*) FROM BOARD WHERE BOARD_TYPE = ? AND STATUS = 'Y'
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

//		String query = prop.getProperty("getListCount");
		String query = "SELECT COUNT(*) FROM BOARD WHERE BOARD_TYPE = ? AND STATUS = 'Y'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		// selectList=SELECT * FROM BLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TYPE = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;

//		String query = prop.getProperty("selectList");
		String query = "SELECT * FROM BLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TYPE = ?";

		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, 1);
			rset = pstmt.executeQuery();

			list = new ArrayList<Board>();
			while (rset.next()) {
				Board b = new Board(rset.getInt("board_id"), 
									rset.getInt("board_type"), 
									rset.getString("cate_name"),
									rset.getString("board_title"), 
									rset.getString("board_content"), 
									rset.getString("board_writer"),
									rset.getString("nickname"), 
									rset.getInt("board_count"), 
									rset.getDate("create_date"),
									rset.getDate("modify_date"), 
									rset.getString("status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	public int updateCount(Connection conn, int bId) {
		// updateCount=UPDATE BOARD SET BOARD_COUNT = BOARD_COUNT+1 WHERE BOARD_ID = ?
		
		PreparedStatement pstmt = null;
		int result = 0;

//		String query = prop.getProperty("updateCount");
		String query = "UPDATE BOARD SET BOARD_COUNT = BOARD_COUNT+1 WHERE BOARD_ID = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public Board selectBoard(Connection conn, int bId) {
		// selectBoard=SELECT * FROM BDETAIL WHERE BOARD_ID = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;

//		String query = prop.getProperty("selectBoard");
		String query = "SELECT * FROM BDETAIL WHERE BOARD_ID = ?";	

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board(rset.getInt("board_id"), 
								  rset.getInt("board_type"),
								  rset.getString("cate_name"),
								  rset.getString("board_title"),
								  rset.getString("board_content"),
								  rset.getString("board_writer"),
								  rset.getString("nickname"),
								  rset.getInt("board_count"),
								  rset.getDate("create_date"),
								  rset.getDate("modify_date"),
								  rset.getString("status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, int bid) {
		// selectReplyList=SELECT * FROM RLIST WHERE REF_BID = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
//		String sql = prop.getProperty("selectReplyList");
		String sql = "SELECT * FROM RLIST WHERE REF_BID = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rset = pstmt.executeQuery();
			list = new ArrayList<Reply>();
			
			while(rset.next()) {
				list.add(new Reply(
						rset.getInt("reply_id"),
						rset.getString("reply_content"),
						rset.getInt("ref_bid"),
						rset.getString("nickname"),
						rset.getDate("create_date"),
						rset.getDate("modify_date"),
						rset.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertReply(Connection conn, Reply r) {
		// insertReply=INSERT INTO REPLY VALUES(SEQ_RID.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("insertReply");
		String query = "INSERT INTO REPLY VALUES(SEQ_RID.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBid());
			pstmt.setString(3, r.getReplyWriter());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList selectBList(Connection conn) {
		// selectBlist=SELECT * FROM BLIST WHERE BOARD_TYPE=2
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
//		String query = prop.getProperty("selectBList");
		String query = "SELECT * FROM BLIST WHERE BOARD_TYPE=2";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("board_id"),
								   rset.getInt("board_type"),
								   rset.getString("cate_name"),
								   rset.getString("board_title"),
								   rset.getString("board_content"),
								   rset.getString("board_writer"),
								   rset.getString("nickname"),
								   rset.getInt("board_count"),
								   rset.getDate("create_date"),
								   rset.getDate("modify_date"),
								   rset.getString("status")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
				
		return list;
	}

	public ArrayList selectFList(Connection conn) {
		// selectFlist=SELECT * FROM ATTACHMENT WHERE STATUS='Y' AND FILE_LEVEL=0
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
//		String query = prop.getProperty("selectBList");
		String query = "SELECT * FROM ATTACHMENT WHERE STATUS='Y' AND FILE_LEVEL=0";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				list.add(new Attachment(rset.getInt("board_id"),
									   (rset.getString("change_name"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int insertThBoard(Connection conn, Board b) {
		// insertThBoard = INSERT INTO BOARD VALUES (SEQ_BID.NEXTVAL, 2, 10, ?, ?, ?, DEFAULT, SYSDATE, SYSDATE, DEFAULT)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("insertThBoard");
		String query = "INSERT INTO BOARD VALUES (SEQ_BID.NEXTVAL, 2, 10, ?, ?, ?, DEFAULT, SYSDATE, SYSDATE, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		// insertAttachment = INSERT INTO ATTACHMENT VALUES(SEQ_FID.NEXTVAL, SEQ_BID.CURRVAL, ?, ?, ?, SYSDATE, ?, DEFAULT, DEFAULT)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("insertAttachment");
		String query = "INSERT INTO ATTACHMENT VALUES(SEQ_FID.NEXTVAL, SEQ_BID.CURRVAL, ?, ?, ?, SYSDATE, ?, DEFAULT, DEFAULT)";
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				Attachment a = fileList.get(i);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, a.getOriginName());
				pstmt.setString(2, a.getChangeName());
				pstmt.setString(3, a.getFilePath());
				pstmt.setInt(4, a.getFileLevel());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bId) {
		// selectThumbnail = SELECT * FROM ATTACHMENT WHERE BOARD_ID = ? AND STATUS = 'Y' ORDER BY FILE_ID
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
//		String query = prop.getProperty("selectThumbnail");
		String query = "SELECT * FROM ATTACHMENT WHERE BOARD_ID = ? AND STATUS = 'Y' ORDER BY FILE_ID";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setFileId(rset.getInt("file_id"));
				a.setOriginName(rset.getString("origin_name"));
				a.setChangeName(rset.getString("change_name"));
				a.setFilePath(rset.getString("file_path"));
				a.setUploadDate(rset.getDate("upload_date"));
				
				list.add(a);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
}


