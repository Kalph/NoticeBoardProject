package common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLJDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(SQLJDBCTemplate.class.getResource("/sql/driver.properties").getPath()));
			Class.forName(prop.getProperty("driver2"));
			con = DriverManager.getConnection(prop.getProperty("url2"), prop.getProperty("user2"), prop.getProperty("password2"));
			con.setAutoCommit(false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void close(Statement stmt) {
		try { 
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
		}
		
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
		}
		
	}
	
}
