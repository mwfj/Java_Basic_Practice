package mwfj.demo.jdbc2.service.impl;

import java.sql.Connection;
import java.util.List;

import mwfj.demo.jdbc2.commons.Pager;
import mwfj.demo.jdbc2.commons.Validate;
import mwfj.demo.jdbc2.dao.StudentDao;
import mwfj.demo.jdbc2.dao.StudentLogDao;
import mwfj.demo.jdbc2.dao.impl.SQLController;
import mwfj.demo.jdbc2.dao.impl.StudentDaoImpl;
import mwfj.demo.jdbc2.dao.impl.StudentLogDaoImpl;
import mwfj.demo.jdbc2.entities.Student;
import mwfj.demo.jdbc2.service.StudentService;


/**
 * 接口：多态
 * Animal animal = new Dog();
 * animal.....
 * @author RICO
 * 
 * service ----> dao
 * service 依赖 dao ： 创建dao的对象
 *
 */
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao = new StudentDaoImpl();
	private StudentLogDao studentLogDao = new StudentLogDaoImpl();

	/**
	 * JDBC中多表操作控制事务的核心：只能在一个连接上去操作，你才能控制事务
	 * 
	 */
	@Override
	public void newStudent(String name, String age) throws Exception {
		System.out.println("Service called");
		
		/**
		 * 数据验证
		 */
		if(Validate.isNull(name)) {
			throw new ServiceRulesException("数据不能为空.");
		}
		
		if(Validate.isNull(age)) {
			throw new ServiceRulesException("数据不能为空.");
		}
		
		if(!Validate.isNumber(age)) {
			throw new ServiceRulesException("数据不是数字.");
		}
		
		if(!Validate.isAgeOK(Integer.parseInt(age), 1, 200)) {
			throw new ServiceRulesException("年龄值越界.");
		}
		
		/**
		 * 数据封装
		 */
		Connection connection = null;
		try {
			connection = SQLController.getConnection();
			connection.setAutoCommit(false);
			Student student = new Student();
			student.setName(name);
			student.setAge(Integer.parseInt(age));
			this.studentDao.insertStudent(student, connection);
			this.studentLogDao.insertStudentLog("Hello World", connection);
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw new Exception(e);
		} finally {
			// 在什么位置开连接，什么位置关
			SQLController.coloseConnection(connection);
		}
	}

	@Override
	public void modifyStudent(String id, String newName, String newAge) throws Exception {
		Student student = this.studentDao.selectStudent(id);
		if(student != null) {
			student.setName(newName);
			student.setAge(Integer.parseInt(newAge));
			this.studentDao.updateStudent(student);
		} else {
			throw new Exception("ID：" + id + "的数据不存在，不能修改。");
		}
		
	}

	

	@Override
	public Student getStudent(String id) throws Exception {
		return this.studentDao.selectStudent(id);
	}

	@Override
	public List<Student> getStudents() throws Exception {
		return this.studentDao.selectStudents();
	}

	@Override
	public void removeStudents(String ids) throws Exception {
//		this.studentDao.deleteStudents(ids);
		// 'xxxx', 'yyyy', 'zzzz'
		// [0] : "'xxxx'" ---> "xxxx"
		// [1] :  "'yyyy'" ---> "yyyy"
		
		// 先去掉单引号
		ids = ids.replace("'", "");
		// 拆分
		String[] _ids = ids.split(",");
		for(String str : _ids) {
			System.out.println("+" + str);
//			str = str.replace("'", "");
//			System.out.println("-" + str);
		}
		this.studentDao.deleteStudents(_ids);
		
		// where s_id in ('xxx', 'yyy', 'zzz');
		// where s_id = ?; ---> "xxx"
	}

	@Override
	public Pager getStudents(String pagerNO) throws Exception {
		// 总条数
		int totalCount = this.studentDao.countStudent();
		// 分页对象
		Pager pager = new Pager(pagerNO, totalCount);
		// 查询当前分页下的数据
		List<Student> students = this.studentDao.selectStudents(pager);
		// 数据塞入Pager对象中
		pager.setList(students);
		
		return pager;
	}

	@Override
	public Pager getStudents(String pagerNO, String pagerSize) throws Exception {
		int totalCount = this.studentDao.countStudent();
		Pager pager = new Pager(pagerNO, pagerSize, totalCount);
		List<Student> students = this.studentDao.selectStudents(pager);
		System.out.println(students.size());
		pager.setList(students);
		return pager;
	}

	@Override
	public Pager getStudents(String pagerNO, String pagerSize, String keywords)
			throws Exception {
		int totalCount = this.studentDao.countStudent(keywords);
		Pager pager = new Pager(pagerNO, pagerSize, totalCount);
		List<Student> students = this.studentDao.selectStudents(pager, keywords);
		pager.setList(students);
		return pager;
	}

}
