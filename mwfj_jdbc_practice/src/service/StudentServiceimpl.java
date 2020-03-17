package service;

import java.util.List;

import dao.StudentDAO;
import dao.StudentDAOimpl;
import entities.Student;

public class StudentServiceimpl implements StudentService{
	private StudentDAO studentDao = new StudentDAOimpl();

	@Override
	public Student getStudent(String id) {
		// TODO Auto-generated method stub
		return this.studentDao.selectStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return this.studentDao.selectStudents();
	}



}
