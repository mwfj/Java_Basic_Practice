package mwfj.demo.hibernate.ui.one_to_many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Department;
import mwfj.demo.hibernate.entities.Employee;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {
	
	private static void doSave() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			Department d1 = new Department();
			d1.setName("开发部");
			
			Employee e1 = new Employee();
			e1.setName("tom");
			Employee e2 = new Employee();
			e2.setName("tina");
			
			e1.setDepartment(d1);
			e2.setDepartment(d1);
			
			Department d2 = new Department();
			d2.setName("市场部");
			
			Employee e3 = new Employee();
			e3.setName("jerry");
			e3.setDepartment(d2);
			
			Department d3 = new Department();
			d3.setName("人力资源部");
			
			Employee e4 = new Employee();
			e4.setName("tiger");
			e4.setDepartment(d3);
			Employee e5 = new Employee();
			e5.setName("lucy");
			e5.setDepartment(d3);
			Employee e6 = new Employee();
			e6.setName("jack");
			e6.setDepartment(d3);
			
			
			/**
			 * 数据是要生成的，但是无法有外键数据关系
			 * 关系维护应该以外键所在表（对象）为主导
			 */
			/*Set<Employee> employees = new HashSet<Employee>();
			employees.add(e1);
			employees.add(e2);
			d1.setEmployees(employees);*/
			
			session.save(d1);
			session.save(e1);
			session.save(e2);
			session.save(d2);
			session.save(e3);
			session.save(d3);
			session.save(e4);
			session.save(e5);
			session.save(e6);
			

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void doView() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			/**
			 * HQL : Hiberante Query Language
			 */
		/*	List<Department> departments = 
					session.createQuery("from Department ").list();
			
			for (Department department : departments) {
				System.out.println("部门名称：" + department.getName());
				Set<Employee> employees = department.getEmployees();
				System.out.println("它的员工有：");
				for(Employee employee : employees) {
					System.out.println("员工姓名：" + employee.getName());
				}
				System.out.println("-------------------------------------");
			}*/
			
			/**
			 * QBC : Query By Criteria
			 */
			List<Employee> employees = session
					.createCriteria(Employee.class)
					.list();
			for(Employee employee : employees) {
				System.out.println("员工姓名：" + employee.getName() + " | 所在部门名称：" + employee.getDepartment().getName());
				System.out.println("-------------------------------------");
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

	public static void main(String[] args) {
//		doSave();
		
		doView();

	}

}
