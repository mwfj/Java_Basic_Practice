package mwfj.demo.service;

import java.util.List;

import mwfj.demo.entities.Student;

/**
 * 接口：多态
 * 
 */
public interface StudentService {
	
	public Student login(String loginName, String loginPassword) throws Exception;
	
	public List<Student> getStudents(String pageNo) throws Exception;

}
