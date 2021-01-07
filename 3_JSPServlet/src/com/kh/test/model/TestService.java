package com.kh.test.model;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

public class TestService {
	
	
	public List<Test> selectList() {
		Connection conn = getConnection();
		
		List<Test> list = new TestDao().selectList(conn);
		close(conn);
		
		return list;
	}
	
}
