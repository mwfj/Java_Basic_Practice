package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;

import entity.Student;

public class StudentDAO {
	public boolean addStudent(Student student) {
		String sql = "insert into student(name,age,sex)values('"
				+ student.getName() + "'," + student.getAge() + ",'"
				+ student.getSex() + "')";
		Connection connection = ConnectionUtil.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConnectionUtil.closeAll(connection, stmt, null,null);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} 
	}

	public boolean delStudentById(int id) {
		String sql ="delete from Student where id="+id;
		Connection connection = ConnectionUtil.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConnectionUtil.closeAll(connection, stmt, null,null);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} 
	}

	public boolean updateStudent(Student student) {
		String sql ="update student set name='"+student.getName()+"',age="+student.getAge()+",sex='"+student.getSex()+"' where id="+student.getId();
		System.out.println(sql);
		Connection connection = ConnectionUtil.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConnectionUtil.closeAll(connection, stmt, null,null);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} 
	}

	public List queryAllStudents() {
//		String sql ="select id,name,age,sex from student";
		String sql ="select id,name from student";
		Connection connection = ConnectionUtil.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List list =new ArrayList();
			while(rs.next()){
				Student student =new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
//				student.setAge(rs.getInt("age"));
//				student.setSex(rs.getString("sex"));
				list.add(student);
			}
			ConnectionUtil.closeAll(connection, stmt, null,rs);
			return list;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} 
	}

	public static void main(String[] args) {
//		Student student = new Student();
//		student.setAge(30);
//		student.setName("abc");
//		student.setSex("男");
//		new StudentDAO().addStudent(student);
		
		List<Student> list = new StudentDAO().queryAllStudents();
		for (Student student : list) {
			System.out.println(student);
		}
		
//		Student student = new Student();
//		student.setId(1);
//		student.setAge(300);
//		student.setName("cba");
//		student.setSex("男");
//		new StudentDAO().updateStudent(student);
		
	
//		new StudentDAO().delStudentById(1);
	}
}
