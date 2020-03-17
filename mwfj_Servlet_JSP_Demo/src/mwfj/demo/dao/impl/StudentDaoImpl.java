package mwfj.demo.dao.impl;

import java.util.List;

import mwfj.demo.dao.StudentDao;
import mwfj.demo.entities.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getStudent(String loginName, String loginPassword)
			throws Exception {

		if (loginName.equals("tom") && loginPassword.equals("1234")) {
			Student student = new Student();
			student.setLoginName("tom");
			student.setLoginPassword("1234");
			student.setNickName("汤姆");
			return student;
		}

		return null;
	}

	@Override
	public List<Student> selectStudents() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
