package mwfj.demo.hibernate.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			 Configuration cfg = new Configuration();  
			return cfg.configure()
					.buildSessionFactory(
							new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	// 不需要关闭，在当前线程
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	// 需要手动关闭
	public static Session getOpenSession() {
		return sessionFactory.openSession();
	}

}
