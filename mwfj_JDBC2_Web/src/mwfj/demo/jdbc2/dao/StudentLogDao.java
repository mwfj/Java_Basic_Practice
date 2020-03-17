package mwfj.demo.jdbc2.dao;

import java.sql.Connection;

public interface StudentLogDao {
	
	public void insertStudentLog(String message, Connection connection) throws Exception;

}
