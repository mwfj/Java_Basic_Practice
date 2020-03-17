package mwfj.demo.jdbc2.dao.impl;

import java.sql.Connection;
import java.util.List;

import mwfj.demo.jdbc2.commons.Pager;
import mwfj.demo.jdbc2.dao.StudentDao;
import mwfj.demo.jdbc2.entities.Student;

public class StudentDaoImpl2 implements StudentDao {

//	@Override
//	public void insertStudent(Student student) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudents(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudents(String ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student selectStudent(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectStudents() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStudent(Student student, Connection connection)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countStudent() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> selectStudents(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudents(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countStudent(String keywords) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> selectStudents(Pager pager, String keywords)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
