package mwfj.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler {
	
	/**
	 * 数据库的连接
	 * Connection 对象表示和数据库的连接
	 * @return
	 */
	public static Connection getConnection() throws Exception  {
		Connection connection = null;
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zk";
		String user = "root";
		String password = "root";
		// 加载驱动
		Class.forName(driverClassName);
		// 获得连接对象
		connection = DriverManager.getConnection(url, user, password);
		return connection;
		
	}

}
