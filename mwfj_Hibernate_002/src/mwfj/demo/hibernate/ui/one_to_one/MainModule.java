package mwfj.demo.hibernate.ui.one_to_one;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.User;
import mwfj.demo.hibernate.entities.UserDetail;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	private static void doSave() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			User u1 = new User();
			u1.setLoginName("Tina");
			u1.setLoginPassword("Tina");

			UserDetail ud1 = new UserDetail();
			ud1.setAddress("德阳市");
			ud1.setCellPhone("13500");

			/**
			 * 建立关系
			 */
			ud1.setUser(u1);
			u1.setUserDetail(ud1);

			session.save(u1);
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

			List<User> users = (List<User>) session.createQuery("from User as u")
					.list();
			for(User user : users) {
				System.out.println(user.getId() + "|" + user.getLoginName() + "|" + user.getLoginPassword() 
						+ "|" + user.getUserDetail().getAddress() + "|" + user.getUserDetail().getCellPhone());
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
	}

}
