package mwfj.demo.hibernate.ui.many_to_many;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Course;
import mwfj.demo.hibernate.entities.Teacher;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {
	
	 static void doSave() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			Teacher t1 = new Teacher();
			t1.setName("Jake John");
			Teacher t2 = new Teacher();
			t2.setName("Sam Smith");
			Teacher t3 = new Teacher();
			t3.setName("Federor");
			
			Course c1 = new Course();
			c1.setName("English");
			Course c2 = new Course();
			c2.setName("Physics");
			Course c3 = new Course();
			c3.setName("Math");
			
			t1.getCourses().add(c1);
			t1.getCourses().add(c2);
			t2.getCourses().add(c1);
			t2.getCourses().add(c3);
			t3.getCourses().add(c2);
			t3.getCourses().add(c3);
			
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	 static void doView() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			List<Teacher> teachers = session.createCriteria(Teacher.class).list();
			
			if(teachers != null) {
				for (Teacher teacher : teachers) {
					System.out.println("Teacher's name:" + teacher.getName());
					System.out.println("The Course he teach is" );
					for (Course course : teacher.getCourses()) {
						System.out.println(course.getName() + "\t");
					}
				}
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
		doView();
//		doSave();
		
		
	
		
		

	}

}
