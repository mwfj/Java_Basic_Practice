package mwfj.demo.hibernate.ui.selfJoin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Category;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {
	
	 static void doSave() {
			Session session = null;
			Transaction tx = null;

			try {
				session = HibernateUtil.getCurrentSession();
				tx = session.beginTransaction();
				
				Category c1 = new Category();
				c1.setName("Moblie Phone");
				Category c2 = new Category();
				c2.setName("Household Electric");
				
				Category c3 = new Category();
				c3.setName("Smart Phone");
				c3.setCategory(c1);
				
				Category c4 = new Category();
				c4.setName("CellPhone for Old People");
				
				Category c5 = new Category();
				c5.setName("Android");
				c5.setCategory(c3);
				
				Category c6 = new Category();
				c6.setName("IOS");
				c6.setCategory(c3);
				
				Category c7 = new Category();
				c7.setName("Other OS");
				c7.setCategory(c3);
				
				session.save(c1);
				session.save(c2);
				session.save(c3);
				session.save(c4);
				session.save(c5);
				session.save(c6);
				session.save(c7);
				
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				HibernateUtil.getSessionFactory().close();
			}
		}
	
	public static void main(String[] args) {
		doSave();
	}

}
