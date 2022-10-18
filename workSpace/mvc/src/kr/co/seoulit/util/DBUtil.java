package kr.co.seoulit.util;

import java.sql.*;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url, id, pass);
		} catch (SQLException sqle) {
			System.out.println("DBConnection:SQLException");
			throw new RuntimeException(sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DBConnection:ClassNotFoundException");
			throw new RuntimeException(cnfe.getMessage());
		}

		return conn;
	}
}