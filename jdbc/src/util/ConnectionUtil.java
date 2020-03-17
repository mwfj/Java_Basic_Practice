package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		try {
			// 加载驱动 （把驱动包里面的驱动类加载到Java VM中）
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager
					.getConnection(URL, USER_NAME, PASSWORD);
			return c;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void closeAll(Connection connection, Statement stmt,
			PreparedStatement pstmt, ResultSet rs) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("数据库关闭发生异常");
		}

	}

	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}
}
