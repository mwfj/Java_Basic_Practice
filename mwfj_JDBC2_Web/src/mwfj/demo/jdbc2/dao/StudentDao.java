package mwfj.demo.jdbc2.dao;

import java.sql.Connection;
import java.util.List;

import mwfj.demo.jdbc2.commons.Pager;
import mwfj.demo.jdbc2.entities.Student;

public interface StudentDao {
	
	public void insertStudent(Student student, Connection connection) throws Exception;
	
	public void updateStudent(Student student) throws Exception;
	
	/**
	 * JDBC 批量操作 Batch 操作
	 * @param ids
	 * @throws Exception
	 */
	public void deleteStudents(Long[] ids) throws Exception;
	
	/**
	 * delete from student where s_id in (1,2,3);
	 * @param ids
	 * @throws Exception
	 */
	public void deleteStudents(String ids) throws Exception;
	
	public Student selectStudent(String id) throws Exception;
	
	public List<Student> selectStudents() throws Exception;
	
	public int countStudent() throws Exception;
	
	public List<Student> selectStudents(Pager pager) throws Exception;
	
	// 批量操作：一次连接要执行多条语句
	/**
	 * 1) 批量怎么写
	 * 2) a) 对一张表执行多条语句 b) 操作两张表
	 * 3) 事务控制
	 * @param ids
	 * @throws Exception
	 */
	public void deleteStudents(String[] ids) throws Exception;
	
	public int countStudent(String keywords) throws Exception;
	public List<Student> selectStudents(Pager pager, String keywords) throws Exception;
	
	

}
