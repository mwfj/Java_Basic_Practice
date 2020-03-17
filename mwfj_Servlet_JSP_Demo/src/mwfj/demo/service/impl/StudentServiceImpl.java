package mwfj.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import mwfj.demo.dao.StudentDao;
import mwfj.demo.dao.impl.StudentDaoImpl2;
import mwfj.demo.entities.Student;
import mwfj.demo.service.StudentService;
/**
 * 
 * @author mwfj
 *
 */
public class StudentServiceImpl implements StudentService {
	
	private boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private StudentDao studentDao = new StudentDaoImpl2();

	@Override
	public Student login(String loginName, String loginPassword)
			throws Exception {
		/**
		 * 非空，长度
		 * 1）客户端判断
		 * 2）服务器判断
		 * 客户端和服务器端双向验证
		 */

		if(loginName == null || loginName.trim().equals("") || loginName.trim().length() == 0) {
			throw new BusinessException("登录名不能为空");
		}
		
		if(loginPassword == null || loginPassword.trim().equals("") || loginPassword.trim().length() == 0) {
			throw new BusinessException("登录密码不能为空");
		}
		
		return this.studentDao.getStudent(loginName, loginPassword);
	}
	
	private List<Student> get1st(List<Student> students) {
		List<Student> pageNoStudents = new ArrayList<Student>();
		for(int i = 0; i < 4; i++) {
			pageNoStudents.add(students.get(i));
		}
		
		return pageNoStudents;
	}
	
	private List<Student> get2nd(List<Student> students) {
		List<Student> pageNoStudents = new ArrayList<Student>();
		for(int i = 4; i < students.size(); i++) {
			pageNoStudents.add(students.get(i));
		}
		
		return pageNoStudents;
	}
	
	

	@Override
	public List<Student> getStudents(String pageNo) throws Exception {
		List<Student> students = this.studentDao.selectStudents();
		
		if(pageNo == null || pageNo.trim().equals("")) {
			return this.get1st(students);
		} else {
			if(isNumber(pageNo)) {
				// 参数是数字
				int number = Integer.parseInt(pageNo);
				if(number == 1) {
					return this.get1st(students);
				} else if (number == 2) {
					return this.get2nd(students);
				} else {
					return this.get1st(students);
				}
			} else {
				// 参数不是数字
				return this.get1st(students);
			}
		}
	}

}
