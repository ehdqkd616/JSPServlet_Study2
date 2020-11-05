package notice.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.Notice;

public class NoticeDAO {

//	private Properties prop = new Properties();
	
	public NoticeDAO() {}
//		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
//	
//		try {
//			prop.load(new FileReader(fileName));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//	}
	
	public ArrayList<Notice> selectList(Connection conn) {
		// selectList=SELECT * FROM NOTICE JOIN MEMBER ON(USER_ID = NOTICE_WRITER) WHERE NOTICE.STATUS='Y' ORDER BY NOTICE_NO DESC
		
		Statement stmt = null;
		ResultSet rset = null;
		Notice notice = null;
		ArrayList<Notice> list = null;
//		String query = prop.getProperty("selectList");
		String query = "selectList=SELECT * FROM NOTICE JOIN MEMBER ON(USER_ID = NOTICE_WRITER) WHERE NOTICE.STATUS='Y' ORDER BY NOTICE_NO DESC";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				notice = new Notice(rset.getInt("notice_no"),
									rset.getString("notice_title"),
									rset.getString("notice_content"),
									rset.getString("notice_writer"),
									rset.getString("nickname"),
									rset.getInt("notice_count"),
									rset.getDate("notice_date")
						);
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int insertNotice(Connection conn, Notice n) {
		// insertNotice=INSERT INTO NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NOTICE_COUNT, NOTICE_DATE, STATUS) VALUES (SEQ_NNO.NEXTVAL, ?, ?, ?, DEFAULT, ?, DEFAULT)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("insertNotice");
		String query = "INSERT INTO NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, NOTICE_COUNT, NOTICE_DATE, STATUS) VALUES (SEQ_NNO.NEXTVAL, ?, ?, ?, DEFAULT, ?, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeWriter());
			pstmt.setDate(4, n.getNoticeDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Notice selectNotice(Connection conn, int no) {
		// selectNotice=SELECT * FROM NOTICE JOIN MEMBER ON(USER_ID = NOTICE_WRITER) WHERE NOTICE_NO = ? AND NOTICE.STATUS = 'Y'
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		
//		String query = prop.getProperty("selectNotice");
		String query = "SELECT * FROM NOTICE JOIN MEMBER ON(USER_ID = NOTICE_WRITER) WHERE NOTICE_NO = ? AND NOTICE.STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 제목 작성자 작성일 내용
				notice = new Notice(rset.getInt("notice_no"),
									rset.getString("notice_title"),
									rset.getString("notice_content"),
									rset.getString("notice_writer"),
									rset.getString("nickname"),
									rset.getInt("notice_count"),
									rset.getDate("notice_Date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return notice;
	}
	
	public int updateCount(Connection conn, int no) {
		// updateCount=UPDATE NOTICE SET NOTICE_COUNT = NOTICE_COUNT + 1 WHERE NOTICE_NO = ?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("updateCount");
		String query = "UPDATE NOTICE SET NOTICE_COUNT = NOTICE_COUNT + 1 WHERE NOTICE_NO = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateNotice(Connection conn, Notice n) {
		// updateNotice=UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?, NOTICE_DATE = ? WHERE NOTICE_NO = ?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("updateNotice");
		String query = "UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?, NOTICE_DATE = ? WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setDate(3, n.getNoticeDate());
			pstmt.setInt(4, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

}
