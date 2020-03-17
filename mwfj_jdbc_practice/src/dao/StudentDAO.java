package dao;

import java.util.List;

import entities.Student;

public interface StudentDAO {

	public  Student selectStudent (String id);
	public List<Student> selectStudents();
	public int totalColum();
	public void insertStudent(Student student);
	public void deleteStudent(String id);
	public void updateStudent(Student student);
}
