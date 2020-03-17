package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entities.Student;

public class StudentDAOimpl implements StudentDAO{

	public static final String QUARYSQL = "SELECT * FROM mwfj_jdbc.Student";
	public static final String COUNT = "SELECT COUNT(*) totalCount FROM mwfj_jdbc.Student";
	public static final String INSERT = "INSERT INTO mwfj_jdbc.Student(id,name,age) values(?, ?, ?)";
	public static final String DELETE = "delete FROM mwfj_jdbc.Student where id = ?";
	@Override
	//查询数据
	public Student selectStudent(String id) {
		// TODO Auto-generated method stub
		Student student =null;
		Connection connection =null;
		PreparedStatement pstatement = null;
		ResultSet rset  = null;
		String sql ="SELECT * FROM mwfj_jdbc.Student WHERE id = ? ";
		try {
			connection = MySQLConnectUtil.getMySQLConnection();
			System.out.println("connection: "+connection);
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1,id);
			rset = pstatement.executeQuery();
			while(rset.next()){
				student = new Student();
				student.setId(rset.getString(1));
				student.setName(rset.getString(2));
				student.setAge(rset.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MySQLConnectUtil.closeResultset(rset);
			MySQLConnectUtil.closePreparestatement(pstatement);
			MySQLConnectUtil.closeConnection(connection);
		}
		return student;
	}

	@Override
	//查询所有数据
	public List<Student> selectStudents() {
		// TODO Auto-generated method stub
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> sList = new ArrayList<Student>();
		
		try {
			connection = MySQLConnectUtil.getMySQLConnection();
			ps = connection.prepareStatement(QUARYSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("ID"));
				student.setName(rs.getString("NAME"));
				student.setAge(rs.getInt("AGE"));
				sList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MySQLConnectUtil.closeResultset(rs);
			MySQLConnectUtil.closePreparestatement(ps);
			MySQLConnectUtil.closeConnection(connection);
		}
		return sList;
	}

	@Override
	//获得当前数据库的总行数
	public int totalColum() {
		// TODO Auto-generated method stub
		Connection connection = null;
		int total_count = 0;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		
		try {
			connection = MySQLConnectUtil.getMySQLConnection();
			pStatement = connection.prepareStatement(COUNT);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				total_count = rSet.getInt("totalCount");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MySQLConnectUtil.closeResultset(rSet);
			MySQLConnectUtil.closePreparestatement(pStatement);
			MySQLConnectUtil.closeConnection(connection);
		}
		return total_count;
	}

	@Override
	//插入数据
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pStatement = null;		
		try {
			conn = MySQLConnectUtil.getMySQLConnection();
			pStatement = conn.prepareStatement(INSERT);
			
			pStatement.setString(1, student.getId());
			pStatement.setString(2, student.getName());
			pStatement.setInt(3, student.getAge());
			int i =pStatement.executeUpdate();
			System.out.println("影响行数"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MySQLConnectUtil.closePreparestatement(pStatement);
			MySQLConnectUtil.closeConnection(conn);
		}
	}

	@Override
	//删除数据
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pStatment = null;
				
		try {
			conn = MySQLConnectUtil.getMySQLConnection();
			pStatment = conn.prepareStatement(DELETE);
			pStatment.setString(1, id);
			int i = pStatment.executeUpdate();
			System.out.println("删除影响行数:" +i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MySQLConnectUtil.closePreparestatement(pStatment);
			MySQLConnectUtil.closeConnection(conn);
		}
	}

	@Override
	/**
	 * 修改数据
	 * update mwfj_jdbc.Student set paramr=? where id=?
	 */
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}
}
