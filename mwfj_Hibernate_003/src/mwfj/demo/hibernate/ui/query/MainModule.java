package mwfj.demo.hibernate.ui.query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Department;
import mwfj.demo.hibernate.entities.Employee;
import mwfj.demo.hibernate.entities.Student;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	static void doSave() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			Student s1 = new Student("tom", 21);
			Student s2 = new Student("jack", 18);
			Student s3 = new Student("tina", 25);
			Student s4 = new Student("jerry", 19);
			Student s5 = new Student("terasa", 28);
			Student s6 = new Student("rose", 30);
			Student s7 = new Student("lucy", 37);

			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			session.save(s5);
			session.save(s6);
			session.save(s7);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}
	
	static void doQuery() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			/*
			 * List<Student> students = session .createQuery(
			 * "select s.name from Student s where s.age between 20 and 30")
			 * .list();
			 * 
			 * if(students != null) { for (Student student : students) {
			 * System.out.println(student.toString()); } }
			 */

			/*
			 * List<Object> objects = session
			 * .createQuery("select s.name from Student s where s.age >=21")
			 * .list(); if(objects != null) { for (Object object : objects) {
			 * System.out.println(object.toString()); } }
			 */

			/**
			 * tom 20 ---> object[] ---> object[0]= tom object[1] = 20
			 */
			/*
			 * List<Object[]> objects = session .createQuery(
			 * "select s.name, s.age from Student s where s.age >=21 order by s.id desc"
			 * ) .list(); if(objects != null) { for (Object[] object : objects)
			 * { System.out.println(object[0] + "\t" + object[1]); } }
			 */

			/*
			 * List<Student> students = session .createCriteria(Student.class)
			 * .addOrder(Order.desc("age"))
			 * 
			 * .list(); if(students != null) { for (Student student : students)
			 * { System.out.println(student.toString()); } }
			 */

			/*
			 * List<Student> students = session
			 * .createQuery("from Student s order by s.age desc")
			 * .setMaxResults(3) .list(); if(students != null) { for (Student
			 * student : students) { System.out.println(student.toString()); } }
			 */

			/*
			 * List<Student> students = session .createCriteria(Student.class)
			 * .setMaxResults(5) .addOrder(Order.asc("name")) .list();
			 * if(students != null) { for (Student student : students) {
			 * System.out.println(student.toString()); } }
			 */

			/**
			 * 7条数据 每页分3条 分3页 第1页 1-3 第2页 4-6 第3页 7
			 * 
			 * 分页写法 setFirstResult = (pager.getPageNO - 1) *
			 * pager.getPagerSize(); setMaxResults = pager.getPagerSize();
			 * 
			 * Oracle --> 翻译 --> rownum MySQL --> 翻译 --> Limit 3,3
			 */

			/*
			 * List<Student> students = session
			 * .createQuery("from Student s order by s.id") .setFirstResult(3)
			 * .setMaxResults(3) .list(); if(students != null) { for (Student
			 * student : students) { System.out.println(student.toString()); } }
			 */

			/**
			 * 通过主键来查询 get NULL load throws ObjectNotFoundException
			 */

			/*
			 * Student student = (Student) session.get(Student.class, 100L);
			 * if(student != null ) { System.out.println(student.toString()); }
			 */

			/*
			 * try { Student student = (Student) session.load(Student.class,
			 * 100L); System.out.println(student.toString()); }
			 * catch(ObjectNotFoundException e) {
			 * System.out.println("没有此ID的记录"); }
			 */

			/*
			 * Student student = (Student) session //
			 * .createQuery("from Student s where s.id = " + 100L)
			 *//**
			 * 按位置条件查询 属性名 = ? setXXX(位置, 值); 位置从0开始算
			 */
			/*
			 * .createQuery("from Student s where s.id = ?") .setLong(0, 8L)
			 *//**
			 * 按形参名字查询 属性名 = :形参名 setXXX("形参名", 值)
			 */
			/*
			 * .createQuery("from Student s where s.id = :myid")
			 * .setLong("myid", 8L) .uniqueResult();
			 * System.out.println(student.toString());
			 */

			/*
			 * List<Student> students = session
			 * .createQuery("from Student s where s.name like ? and s.age >= ? "
			 * ) .setString(0, "t" + "%") .setInteger(1, 21) .list();
			 * if(students != null) { for (Student student : students) {
			 * System.out.println(student.toString()); } }
			 */

			/*
			 * List<Student> students = session .createQuery(
			 * "from Student s where s.name like :myname and s.age >= :myage ")
			 * .setString("myname", "t" + "%") .setInteger("myage", 21) .list();
			 * if(students != null) { for (Student student : students) {
			 * System.out.println(student.toString()); } }
			 */

			/**
			 * 唯一查询：列名唯一性（条件组合最后唯一数据） from User u where u.loginname = ? AND
			 * u.loginpassword = ?
			 */
			/*
			 * Student student = (Student)session
			 * .createQuery("from Student s where s.name = ? ") .setString(0,
			 * "tom") .uniqueResult(); System.out.println(student.toString());
			 */

			/*
			 * List<Object[]> objects = session
			 * .createQuery("select count(s), s.age from Student s group by s.age"
			 * ) .list();
			 * 
			 * if(objects != null) { for (Object[] object : objects) {
			 * System.out.println("人数：" + object[0] + "\t" + " 年龄：" +
			 * object[1]); } }
			 */

			/**
			 * 命名HQL查询
			 */
			/*@SuppressWarnings("unchecked")
			List<Student> students = session.getNamedQuery("selectStudentAll")
					.list();
			if (students != null) {
				for (Student student : students) {
					System.out.println(student.toString());
				}
			}*/
			
			/**
			 * QBC
			 * 条件查询
			 */
			
		/*	Student student = (Student)session
				.createCriteria(Student.class)
				.add(Restrictions.eq("id", 8L))
				.uniqueResult();
			System.out.println(student.toString());*/
			
			/**
			 * MatchMode.ANYWHERE :任意位置匹配
			 * MatchMode.EXACT : 精确匹配字符
			 * MatchMode.START: 以匹配字符开头
			 * MatchMode.END ： 以匹配字符结尾
			 * --------------------------------------
			 * Restrictions.disjunction() 逻辑或
			 * Restrictions.conjunction() 逻辑与
			 */
		/*	List<Student> students = session
					.createCriteria(Student.class)
					.add(Restrictions.conjunction()
							.add(Restrictions.ge("age", 22)))
							.add(Restrictions.like("name", "t", MatchMode.START))
					
//					.add(Restrictions.gt("age", 21))
//					.add(Restrictions.like("name", "tom", MatchMode.EXACT))
					.list();
			if (students != null) {
				for (Student student : students) {
					System.out.println(student.toString());
				}
			}*/
			
			/**
			 * 原生的SQL语句
			 * 注意点：平台移植差
			 */
		/*	List<Student> students =  session
				.createSQLQuery("select * from test_student")
				.addEntity(Student.class)
				.list();
			if (students != null) {
				for (Student student : students) {
					System.out.println(student.toString());
				}
			}*/
			
			
			/***********联合查询|Hibernate 延迟加载策略 *********/
			
			/**
			 * objects[0] ----> Department
			 * objects[1] ----> Employee
			 */
		/*	List<Object[]> objects =
					session
//					.createQuery("from Department d inner join d.employees")
//					.createQuery("from Department d left join  d.employees")
//					.createQuery("from Department d right join d.employees")
					.createQuery("from Department d full join d.employees")
					.list();
			if(objects != null) {
				for (Object[] object : objects) {
					Department d = (Department)object[0];
					Employee e = (Employee)object[1];
					if(d != null) {
						System.out.print("部门名称：" + d.getName() + "\t"  );
					} else {
						System.out.println();
					}
					
					if(e != null) {
						System.out.println("员工名：" + e.getName());
					}
				}
			}*/
			
			
	
			
			
			
			
			
			

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

	/**
	 * Hibernate 查询三种接口提供使用 1 HQL * 2 QBC 3 原生SQLQuery（不能做平台移植）
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Session session = null;
		Student student = null;
		List<Department> departments = null;
		List<Employee> employees = null;
		
		try {
			session = HibernateUtil.getOpenSession();
			
			/**
			 * Hibernate 检索策略
			 * 1 延迟加载
			 * 2 立即加载
			 * 3 迫切左外连接加载
			 * 
			 * 检索策略作用的位置
			 * 类级别（表）
			 * 关联级别（一对多，多对多，一对一）
			 * 
			 * 类级别的检索：
			 * 默认情况下是延迟检索，延迟检索仅对load方法有效，
			 * 而get方法、HQL方法、QBC方法无效（立即检索）
			 * ----------
			 * 延迟检索需要注意的地方
			 * 就是在真正发起检索数据的时候，你的session不能关闭，否则查不到数据
			 * org.hibernate.LazyInitializationException: could not initialize proxy - the owning Session was closed
			 * 
			 * 关联级别的检索策略（oneToMany oneToOne ManyToMany）
			 * "from Department d"
			 * ----
			 * oneToXXX 在一的一方由于拥有Set集，永远默认级别延迟检索
			 * XXXToOne 在多的一方，永远默认级别是立即检索
			 */
			/*Student student = session.get(Student.class, 8L);
			student.getName();*/
			
			/*session.get(Student.class, 8L);
			
			*//**
			 * 1) 先到Session缓存(内存级别)找数据，如果有取出来
			 * 2) 如果没有，会到二级缓存(文件级别)里面找，如果有取出来
			 * 3) 如果没有，才会发起数据库查询
			 *//*
			 student = (Student) session.load(Student.class, 8L);
			System.out.println(student.getName());*/
			
			/**
			 * 延迟加载，在加载子对象的时候，查询的次数是N+1次
			 * N（指的是主表记录数）
			 * 
			 * ---在查Department的时候，想获得Employee记录
			 * 
			 * 需求：
			 * 1 from Department d  希望：只查Department
			 * 2 form Department d 希望：查Department 和 Employee ，并且不希望是N+1查询，而
			 * 是 连接查询
			 * 
			 * 最佳策略：
			 * 第一种：1 lazy=true fetch=select batch-size= 5 
			 * 然后，你的所有语句不用考虑联合查, from Department d
			 * 
			 * 第二种：2 lazy=true fetch=subselect 
			 * 然后，你的所有语句不用考虑联合查, from Department d
			 * 
			 * 第三种：
			 * 默认 lazy=true fetch=select
			 * 你自己知道什么时候用Department ： from Department d
			 * 什么时候Deparment - Employee ： from Department d left join fetch d.employees
			 * 
			 * --------------------------------------
			 * 特点：返回的数据结构都是 List<主表>
			 * --------------------------------------
			 * 如果你需要平行结构，跟延迟已经没有太大关系
			 * List<Object[]> objects = from Department d left join d.employees
			 * 
			 * 
			 * 
			 */
			departments = session.createQuery("from Department d").list();
			if(departments != null) {
				for(Department department : departments) {
					System.out.println("部门名称：" + department.getName());
					System.out.println("它的员工有：" );
					for(Employee employee : department.getEmployees()) {
						System.out.println(employee.getName() + "\t");
					}
				}
			}
			
		/*	employees = session.createQuery("from Employee e").list();
			if(employees != null) {
				for (Employee employee : employees) {
					System.out.println("员工：" + employee.getName() + " 所属部门：" + employee.getDepartment().getName());
				}
			}
			*/
			
			
			
			HibernateUtil.getSessionFactory().close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	
		
	

	}

}
