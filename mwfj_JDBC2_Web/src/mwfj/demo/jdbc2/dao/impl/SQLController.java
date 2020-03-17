package mwfj.demo.jdbc2.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLController {
	
	public static Connection getConnection() throws Exception {
		/**
		 * java.sql.*
		 * Connection connection 数据库连接
		 * jar 包拷贝
		 * 1） 注册驱动
		 * 2）设置URL，User，Password
		 * 3）DriverManger对象获得连接
		 * 
		 */
		
		Connection connection = null;
//		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		// mysql
		String driverClassName = "com.mysql.jdbc.Driver";
		// JTDS 连接 SQLServer	
//		String driverClassName = "net.sourceforge.jtds.jdbc.Driver";
		
		// 要连接哪个数据库
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// mysql
		String url = "jdbc:mysql://localhost:3306/jdbc_practice";
		// JTDS SQLServer
//		String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=gy";
		// 用户名
		String user = "root";
		// 密码
		String password = "";
		// 加载类：----》 调用类的static静态块代码
		// 注册驱动
		Class.forName(driverClassName);
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static void coloseConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeCallableStatement(CallableStatement cs) {
		if(cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
