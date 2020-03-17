package mwfj.demo.hibernate.ui.cache;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Student;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	static void doCache1() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			List<Student> students = session.createQuery(
					"from Student s where s.id < 12").list();
			for (Student student : students) {
				System.out.println(student.getName());
			}

			System.out.println("=======================");

			// 清除缓存
			// session.clear();

			Student jerry = (Student) session.get(Student.class, 11L);
			System.out.println(jerry.getName());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

	/**
	 * EHCache 依赖jar：ehcache-core.jar hibernate-ehcache.jar
	 * 
	 */
	static void doCache2() {
		Session s1 = HibernateUtil.getOpenSession();
		Transaction t1 = s1.beginTransaction();

		List<Student> students = s1.createQuery(
				"from Student s where s.id < 12").setCacheable(true).list();
		for (Student student : students) {
			System.out.println(student.getName());
		}

		t1.commit();
		s1.close();

		System.out.println("=======================");

		Session s2 = HibernateUtil.getOpenSession();
		Transaction t2 = s2.beginTransaction();
		

		List<Student> students2 = s2.createQuery(
				"from Student s where s.id < 12").setCacheable(true).list();
		for (Student student : students2) {
			System.out.println(student.getName());
		}
		
		t2.commit();
		s2.close();
	}

	public static void main(String[] args) {
		doCache2();
	}

}
