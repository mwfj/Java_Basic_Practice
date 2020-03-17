package mwfj.demo.hibernate.ui.transaction;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Account;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	static void doSave() {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			Account account = new Account();
			account.setName("Tina");
			account.setBalance(new BigDecimal("1000"));

			session.save(account);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

	static void doTest() {
		/**
		 * 线程
		 */
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Session session = null;
				Transaction tx = null;

				try {
					session = HibernateUtil.getCurrentSession();
					tx = session.beginTransaction();

					Account account = (Account) session
							.createQuery("from Account a").setMaxResults(1)
							.uniqueResult();
					
					account.setBalance(account.getBalance().add(new BigDecimal(100)));
					Thread.sleep(1000);
					session.update(account);
					tx.commit();
				} catch(org.hibernate.StaleObjectStateException e) {
					System.err.println("增加出错，对象已经被更改");
					e.printStackTrace();
					tx.rollback();
					
				}
				
				catch (Exception e) {
					e.printStackTrace();
					tx.rollback();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Session session = null;
				Transaction tx = null;

				try {
					session = HibernateUtil.getCurrentSession();
					tx = session.beginTransaction();
					
					Account account = (Account) session
							.createQuery("from Account a").setMaxResults(1)
							.uniqueResult();
					account.setBalance(account.getBalance().subtract(new BigDecimal(100)));
					
					session.update(account);
					tx.commit();
				} catch(org.hibernate.StaleObjectStateException e) {
					System.err.println("减少出错，对象已经被更改");
					e.printStackTrace();
					tx.rollback();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					tx.rollback();
				}

			}
		});

		t1.start();
		t2.start();

	}

	public static void main(String[] args) {
//		 doSave();
		doTest();
	}

}
