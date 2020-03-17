package mwfj.demo.jdbc2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mwfj.demo.jdbc2.dao.StudentLogDao;

public class StudentLogDaoImpl implements StudentLogDao {

	@Override
	public void insertStudentLog(String message, Connection connection) throws Exception {
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO studentlog VALUES(?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, message);
			ps.executeUpdate();
		} finally {
			SQLController.closePreparedStatement(ps);	
		}
		
	}

}
