package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.PageInfo;
import member.model.vo.Member;

public class BoardDAO {

	private Properties prop = new Properties();

	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn) {
		// getListCount=SELECT COUNT(*) FROM BOARD WHERE BOARD_TYPE = ? AND STATUS = 'Y'
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCount");

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

		String query = prop.getProperty("selectList");

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
		
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCount");

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
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;

		String query = prop.getProperty("selectBoard");

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
}


