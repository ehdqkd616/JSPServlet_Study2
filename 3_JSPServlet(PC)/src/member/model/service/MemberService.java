package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import java.sql.Connection;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {

		Connection conn = getConnection();

		Member loginUser = new MemberDAO().loginMember(conn, member);
		close(conn);

		return loginUser;
	}

	public int insertMember(Member member) {

		Connection conn = getConnection();

		int result = new MemberDAO().insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);

		return result;
		
	}
	
	public int checkId(String userId) {

		Connection conn = getConnection();

		int result = new MemberDAO().checkId(conn, userId);
		
		close(conn);

		return result;
		
	}

	public Member selectMember(String loginUserId) {
		
		Connection conn = getConnection();
		
		Member member = new MemberDAO().selectMember(conn, loginUserId);
				
		close(conn);

		return member;
		
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().updateMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int nickCheck(String userNick) {
		
		Connection conn = getConnection();
		
		int result = new MemberDAO().nickCheck(conn, userNick);
		
		close(conn);
		
		return result;
	}
	
}