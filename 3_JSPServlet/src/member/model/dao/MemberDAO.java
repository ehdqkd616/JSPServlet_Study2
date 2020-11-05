package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {

	private Properties prop = new Properties();

	public MemberDAO() {
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Connection conn, Member member) {
		// loginMember = SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;

		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginUser = new Member(rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), rset.getString("NICKNAME"), rset.getString("PHONE"),
						rset.getString("EMAIL"), rset.getString("ADDRESS"), rset.getString("INTEREST"),
						rset.getDate("ENROLL_DATE"), rset.getDate("MODIFY_DATE"), rset.getString("STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUser;
	}

	public int insertMember(Connection conn, Member member) {
		// insertMember = INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getInterest());			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}

	public int checkId(Connection conn, String userId) {
		// idCheck = SELECT COUNT(*) FROM MEMBER WHERE USER_ID = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("idCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

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

	public Member selectMember(Connection conn, String loginUserId) {
		// selectMember = SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;

		String query = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginUserId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				member = new Member(rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), rset.getString("NICKNAME"), rset.getString("PHONE"),
						rset.getString("EMAIL"), rset.getString("ADDRESS"), rset.getString("INTEREST"),
						rset.getDate("ENROLL_DATE"), rset.getDate("MODIFY_DATE"), rset.getString("STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}
	
	public int updateMember(Connection conn, Member member) {
		// updateMember = UPDATE MEMBER SET USER_NAME=?, NICKNAME=?, PHONE=?, EMAIL=?, ADDRESS=?, INTEREST=?, MODIFY_DATE=SYSDATE WHERE USER_ID=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getNickName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getInterest());
			pstmt.setString(7, member.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int nickCheck(Connection conn, String userNick) {
		// nickCheck = SELECT COUNT(*) FROM MEMBER WHERE NICKNAME = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("nickCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNick);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
	
}