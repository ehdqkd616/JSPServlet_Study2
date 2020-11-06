package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTemplate {

	private JDBCTemplate() {}
	
//    public static Connection getConnection2() throws ClassNotFoundException, SQLException {
//        
//    	Connection conn = null;
//    	
//    	String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@localhost:1521:xe";
//        String user = "JSP_Servlet";
//        String password = "JSP_Servlet";
//        Class.forName(driver);
//        
//        conn = DriverManager.getConnection(url, user, password);
//        
//        return conn;
//        
//    }
	
	
	public static Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();
		
		String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			Class.forName(prop.getProperty("driver")); // 오라클 11g
//			Class.forName(prop.getProperty("driverClassName")); // 오라클 18c
			conn = DriverManager.getConnection(prop.getProperty("url"), 
												prop.getProperty("user"),
												prop.getProperty("password"));
			conn.setAutoCommit(false);
			System.out.println("jdbc loading complete");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("jdbc loading failed");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("jdbc loading failed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("jdbc loading failed");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("jdbc loading failed");
		}
		
		return conn;
	}


	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}