package com.kh.test.model;

import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
	
	
	public List<Test> selectList(Connection conn) {
		
//		Connection conn = getConnection();
		
		Statement stmt = null;
		ResultSet rset = null;
		Test test = null;
		List<Test> testList = null;
		String query = "SELECT * FROM TEST";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			testList = new ArrayList<Test>();
			
			while(rset.next()) {
				test = new Test(rset.getInt("seq"),
								rset.getString("writer"),
								rset.getString("title"),
								rset.getString("content"),
								rset.getDate("regdate")
						);
				testList.add(test);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return testList;
	}
	
}
