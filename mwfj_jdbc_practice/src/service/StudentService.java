package service;

import java.util.List;

import entities.Student;

public interface StudentService {
		public Student getStudent(String id);
		public List<Student> getStudents();

}
