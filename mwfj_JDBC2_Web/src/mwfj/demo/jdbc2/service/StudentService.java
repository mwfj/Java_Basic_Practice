package mwfj.demo.jdbc2.service;

import java.util.List;

import mwfj.demo.jdbc2.commons.Pager;
import mwfj.demo.jdbc2.entities.Student;

/**
 * 三层结构
 * UI ---- Servlet Filter JSP 
 *
 * Service ---- 业务：验证，数据组合|拆分|格式化，......
 * 
 * Dao (DataAccess) ---- 和数据库操作的事情
 * 
 * 
 * ----------- MVC:Modol View Controller
 * View: JSP JS CSS HTML
 * Controller : Servlet Filter Listener （Struts，Spring MVC）
 * Model: Service 和 DAO
 * 
 * 
 * @author RICO
 *
 */
public interface StudentService {
	
	public void newStudent(String name, String age) throws Exception;
	
	public void modifyStudent(String id, String newName, String newAge) throws Exception;
	
	
	
	public void removeStudents(String ids) throws Exception;
	
	public Student getStudent(String id) throws Exception;
	
	public List<Student> getStudents() throws Exception;
	
	public  Pager getStudents(String pagerNO) throws Exception;
	
	public  Pager getStudents(String pagerNO, String pagerSize) throws Exception;
	
	public  Pager getStudents(String pagerNO, String pagerSize, String keywords) throws Exception;

}
