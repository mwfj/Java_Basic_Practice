package mwfj.demo.hibernate.ui.component;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Fish;
import mwfj.demo.hibernate.entities.FishTail;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {
	
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			
			Fish fish = new Fish();
		    fish.setName("cyprinoid");
		    fish.setColor("red");

		    FishTail tail = new FishTail();
		    tail.setName("cyprinoid_tail");
		    tail.setLength(1);
		    
		    fish.setTail(tail);
		    
		    session.save(fish);
		    
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

}
