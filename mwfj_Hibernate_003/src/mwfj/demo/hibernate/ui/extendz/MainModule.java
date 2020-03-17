package mwfj.demo.hibernate.ui.extendz;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Bird;
import mwfj.demo.hibernate.entities.Rabbit;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			Bird bird = new Bird();
		    bird.setName("Bird11");
		    bird.setWeight(1.5F);
		    bird.setFlySpeed(80.5F);
		    bird.setWingCount(2);

		    Rabbit rabbit = new Rabbit();
		    rabbit.setName("Rabbit11");
		    rabbit.setWeight(2.5F);
		    rabbit.setRanSpeed(70.3F);
		    rabbit.setLegCount(4);
		    
		    Rabbit rabbit1 = new Rabbit();
		    rabbit1.setName("Australian_hare");
		    rabbit1.setWeight(3.5F);
		    rabbit1.setRanSpeed(100.3F);
		    rabbit1.setLegCount(6);
		    
		    session.save(bird);
		    session.save(rabbit);
		    session.save(rabbit1);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		
	
	    
	    


	}

}
