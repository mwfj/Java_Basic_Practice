package mwfj.demo.jdbc2.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mwfj.demo.jdbc2.commons.Pager;
import mwfj.demo.jdbc2.dao.StudentDao;
import mwfj.demo.jdbc2.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	static final String  INSERT_SQL = "INSERT INTO student(s_name, s_age) VALUES(?, ?)";
	static  final String QUERYS_SQL = "SELECT * FROM student";
	static final String QUERYS_PAGER_SQL =  " SELECT * FROM ( "
			 + " SELECT ROWNUM M, s_id, s_name, s_age FROM student "
			    + " WHERE ROWNUM <= ? "
			    + " ) TEMP WHERE TEMP.M > ? ";
	

	/**
	 * List<Student> students
	 * for(Student student : students) {
	 * 		ps.setString(......student.getName())
	 * 		ps.addBatch();
	 * }
	 * ps.executeBatch();
	 */
	@Override
	public void insertStudent(Student student, Connection connection) throws Exception {	
		
		
		/**
		 * 1) 不能写占位符号?
		 * 2) 性能不高
		 */
//		Statement stmt = null;
		PreparedStatement ps = null;

//		String sql = "INSERT INTO student(s_name, s_age) VALUES(" 
//				+ "'" + student.getName() + "'," + student.getAge()
//				+ ")";
		
		try {
			ps = connection.prepareStatement(INSERT_SQL);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			int i = ps.executeUpdate();
			System.out.println("影响行数：= " + i);
		} finally {
			SQLController.closePreparedStatement(ps);
			//UUID.randomUUID(); ///AHKFJAKLFJ8990087
		}
	}

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
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM student WHERE s_id in (" + ids + ")";
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(sql);
			int i = ps.executeUpdate();
			System.out.println("影响行数：= " + i);
		} finally {
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		
	}

	@Override
	public Student selectStudent(String id) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		String sql = "SELECT * FROM student WHERE s_id = ?";
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
			}
		} finally {
			SQLController.closeResultSet(rs);
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		
		return student;
	}

	@Override
	public List<Student> selectStudents() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> students = new ArrayList<Student>();
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(QUERYS_SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				/**
				 * 按位查询
				 */
//				Student student = new Student();
//				student.setId(rs.getString(1));
//				student.setName(rs.getString(2));
//				student.setAge(rs.getInt(3));
				
				/**
				 * 按名查询
				 */
				Student student = new Student(
						rs.getString("S_ID"), 
						rs.getString("S_NAME"), 
						rs.getInt("S_AGE"));
				
				students.add(student);
			}
		} finally {
			SQLController.closeResultSet(rs);
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		
		return students;
	}

	@Override
	public int countStudent() throws Exception {
		int totalCount = 0;
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = SQLController.getConnection();
			cs = connection.prepareCall("{CALL p_student_count(?,?)}");
			// 输入参数
			cs.setString(1, "成都学院您好");
			// 输出参数注册
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			// 存储过程调用执行
			cs.executeUpdate();
			// 反拿到输出参数的值
			totalCount = cs.getInt(2);
			System.out.println("统计行数：" + totalCount);
		} finally {
			SQLController.closeCallableStatement(cs);
			SQLController.coloseConnection(connection);
		}
		return totalCount;
	}

	@Override
	public List<Student> selectStudents(Pager pager) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> students = new ArrayList<Student>();
		/*String sql = " SELECT * FROM ( "
						 + " SELECT ROWNUM M, s_id, s_name, s_age FROM student "
					    + " WHERE ROWNUM <= ? "
					    + " ) TEMP WHERE TEMP.M > ? ";*/
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(QUERYS_PAGER_SQL);
			System.out.println("----" + pager.getPagerSize());
			ps.setInt(1, pager.getPagerNO() * pager.getPagerSize());
			ps.setInt(2, (pager.getPagerNO() - 1 ) * pager.getPagerSize());
			rs = ps.executeQuery();
			while(rs.next()) {
				/**
				 * 按位查询
				 */
//				Student student = new Student();
//				student.setId(rs.getString(1));
//				student.setName(rs.getString(2));
//				student.setAge(rs.getInt(3));
				
				/**
				 * 按名查询
				 */
				Student student = new Student(
						rs.getString("S_ID"), 
						rs.getString("S_NAME"), 
						rs.getInt("S_AGE"));
				
				students.add(student);
			}
		} finally {
			SQLController.closeResultSet(rs);
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		return students;
	}

	/**
	 * 'xxxxx' DELETE FROM student WHERE s_id = 
	 * 'yyyyy' DELETE FROM student WHERE s_id = 
	 * 'zzzzz' DELETE FROM student WHERE s_id = 
	 */
	@Override
	public void deleteStudents(String[] ids) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM student WHERE s_id = ?";
		try {
			connection = SQLController.getConnection();
			// 设置事务手动提交
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			for(String id : ids) {
				ps.setString(1, id);
				System.out.println(id);
				System.out.println("****");
				// 批量添加参数
				ps.addBatch();
			}
			// 批量执行
			ps.executeBatch();
			// 事务提交（生效）
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			// 数据回滚
			connection.rollback();
			// 异常抛出去
			throw new Exception(e);
		} finally {
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		
	}

	@Override
	public int countStudent(String keywords) throws Exception {
		int totalCount = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(s_id) from student where s_name like '%" + keywords + "%'";
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			SQLController.closeResultSet(rs);
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		return totalCount;
	}

	@Override
	public List<Student> selectStudents(Pager pager, String keywords)
			throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> students = new ArrayList<Student>();
		String sql = " SELECT * FROM ( "
						 + " SELECT ROWNUM M, s_id, s_name, s_age FROM student "
					    + " WHERE ROWNUM <= ? AND s_name like '%" + keywords + "%'  "
					    + " ) TEMP WHERE TEMP.M > ? ";
		try {
			connection = SQLController.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, pager.getPagerNO() * pager.getPagerSize());
			ps.setInt(2, (pager.getPagerNO() - 1 ) * pager.getPagerSize());
			rs = ps.executeQuery();
			while(rs.next()) {

				
				/**
				 * 按名查询
				 */
				Student student = new Student(
						rs.getString("S_ID"), 
						rs.getString("S_NAME"), 
						rs.getInt("S_AGE"));
				
				students.add(student);
			}
		} finally {
			SQLController.closeResultSet(rs);
			SQLController.closePreparedStatement(ps);
			SQLController.coloseConnection(connection);
		}
		return students;
	}

}
