package mwfj.demo.dao;

import java.util.List;

import mwfj.demo.entities.Student;

public interface StudentDao {
	
	public Student getStudent(String loginName, String loginPassword) throws Exception;
	
	public List<Student> selectStudents() throws Exception;

}
