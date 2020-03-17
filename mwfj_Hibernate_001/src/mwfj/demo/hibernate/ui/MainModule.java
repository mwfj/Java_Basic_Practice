package mwfj.demo.hibernate.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Student;
import mwfj.demo.hibernate.tools.HibernateUtil;

/**
 * Configuration 配置 SessionFactory 会话工厂 Session 会话 Transaction 事务
 * 
 * @author MWFJ
 * 
 */
public class MainModule {

	private static String[] menus = { "1 新增学生信息", "2 修改学生信息", "3 删除学生信息",
			"4 查询一个学生信息", "5 查询所有学生信息", "0 退出" };

	private static String readLine() {
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private static void doNewStudent() {
		System.out.println("==新增学生信息==");

		System.out.println("请输入学生的姓名：");
		String name = readLine();
		System.out.println("请输入学生的年龄：");
		String age = readLine();

		Session session = null;
		Transaction tx = null;

		try {
			Student student = new Student();
			student.setName(name);
			student.setAge(Integer.parseInt(age));

			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			System.out.println("==新增学生信息成功==");
		} catch (Exception e) {
			tx.rollback();
		}

		/*
		 * Session session = null; Transaction tx = session.beginTransaction();
		 * session.save(new Student(1L, "", 21)); Student student = get....();
		 * student.setName() session.update(student); session.delete(arg0);
		 * 
		 * Student student = new Student();
		 * 
		 * session.saveOrUpdate(arg0);
		 * 
		 * session.get(Student.Class, 1L); session.load(arg0, 1L);
		 * 
		 * List<Student> list = session.createQuery("from Student").list();
		 * 
		 * Student student =
		 * session.createCriteria(Student.class).addOrder(Order
		 * .asc("age")).uniqueResult();
		 */

	}

	private static void doModifyStudent() {
		System.out.println("==修改学生信息==");
		System.out.println("==请输入要修改学生的ID==");
		String id = readLine();
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, Long.parseLong(id));
			if(student == null) {
				System.out.println("无此ID的学生信息。");
			} else {
				System.out.println("请输入新的学生的姓名：");
				String name = readLine();
				System.out.println("请输入新的学生的年龄：");
				String age = readLine();
				student.setName(name);
				student.setAge(Integer.parseInt(age));
				session.update(student);
				System.out.println("==修改学生信息成功==");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	private static void doRemoveStudent() {
		System.out.println("==删除学生信息==");
		System.out.println("==请输入要删除学生的ID==");
		String id = readLine();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, Long.parseLong(id));
			if(student == null) {
				System.out.println("无此ID的学生信息。");
			} else {
				session.delete(student);
				System.out.println("==删除学生信息成功==");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}
	
	private static void doGetStudent() {
		
		System.out.println("==查询学生信息==");
		System.out.println("==请输入要查询学生的ID==");
		String id = readLine();
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, Long.parseLong(id));
			if(student == null) {
				System.out.println("无此ID的学生信息。");
			} else {
				System.out.println("学生信息如下：" + student.toString());
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public static void doGetStudents() {
		System.out.println("==查询所有学生信息==");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			/*List<Student> students = session
					.createCriteria(Student.class)
					.list();*/
			
			List<Student> students = session
			.createQuery("from Student")
			.list();
		
			if(students != null) {
				for (Student student : students) {
					System.out.println(student.toString());
				}
			}	
		
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	

	public static void main(String[] args) {

		/*
		 * Configuration cfg = new Configuration().configure();
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 * 
		 * Session session = factory.getCurrentSession();
		 * 
		 * System.out.println(session);
		 */

		System.out.println("======================");
		System.out.println("===欢迎来到学生管理系统===");
		System.out.println("======================");

		hello: while (true) {

			for (String menu : menus) {
				System.out.println(menu);
			}

			String input = readLine();

			switch (input) {
			case "1":
				doNewStudent();
				break;
			case "2":
				doModifyStudent();
				break;
			case "3":
				doRemoveStudent();
				break;
			case "4":
				doGetStudent();
				break;
			case "5":
				doGetStudents();
				break;
				
			default:
				break hello;
			}
		}
	}

}
