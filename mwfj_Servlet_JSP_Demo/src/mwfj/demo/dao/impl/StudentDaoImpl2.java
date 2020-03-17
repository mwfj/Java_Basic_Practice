package mwfj.demo.dao.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mwfj.demo.dao.StudentDao;
import mwfj.demo.entities.Student;

public class StudentDaoImpl2 implements StudentDao {

	@Override
	public Student getStudent(String loginName, String loginPassword)
			throws Exception {

		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream("student.properties");
			Properties properties = new Properties();
			properties.load(in);

			String configLoginName = properties.getProperty("LoginName");
			String configLoginPassword = properties
					.getProperty("LoginPassword");

			if (loginName.equals(configLoginName)
					&& loginPassword.equals(configLoginPassword)) {
				Student student = new Student(configLoginName, loginPassword,
						properties.getProperty("NickName"));
				return student;
			}
			
		} finally {
			if (in != null) {
				in.close();
			}
		}
		
		return null;

	}

	@Override
	public List<Student> selectStudents() throws Exception {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("王敬东", 1L, 21));
		students.add(new Student("马吴方杰", 2L, 21));
		students.add(new Student("王欣宇", 3L, 21));
		students.add(new Student("孟凡颍", 4L, 22));
		students.add(new Student("吴倩", 5L, 20));
		students.add(new Student("王树政", 6L, 22));
		students.add(new Student("马克功", 7L, 21));
		students.add(new Student("王昌昊", 8L, 21));
		students.add(new Student("林玲", 9L, 21));
	
		return students;
	}

}
