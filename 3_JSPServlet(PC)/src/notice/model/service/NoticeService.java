package notice.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDAO().selectList(conn);
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result = new NoticeDAO().insertNotice(conn, notice);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Notice selectNotice(int no) {
		Connection conn = getConnection();
		Notice notice = new NoticeDAO().selectNotice(conn, no);
		close(conn);
		return notice;
	}
	
	public int updateCount(int no) {
		Connection conn = getConnection();
		int result = new NoticeDAO().updateCount(conn, no);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		int result = new NoticeDAO().updateNotice(conn, notice);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
