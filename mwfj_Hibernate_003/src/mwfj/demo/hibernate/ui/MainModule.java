package mwfj.demo.hibernate.ui;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import mwfj.demo.hibernate.entities.Person;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule {

	public static void main(String[] args) {
		
		Session session = null;
		InputStream in  = null;
		try {
			session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			
			Person person = new Person();
			person.setName("jason");
			person.setAge(24);
			person.setHeight(180.5F);
			person.setWeight(75.55D);
			Calendar birthday = Calendar.getInstance();
			/**
			 * Moth 0-11 表示1-12月
			 */
			birthday.set(1991, 5, 5);
			person.setBirthday(birthday);
			person.setCreatedDatetime(new Date());
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < 1000; i++) {
				sb.append("come on !!");
			}
			person.setDescription(sb.toString());
			 in = MainModule.class.getResourceAsStream("avatar.jpg");
			person.setAvatar(
					session.getLobHelper().createBlob(in, in.available()));
			person.setDeposit(new BigDecimal("15300.50"));
			// 数据库没有boolean值类型，用0表示false，1表示true
			person.setMarried(true);
			
			session.saveOrUpdate(person);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if( in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			HibernateUtil.getSessionFactory().close();
		}

	}

}
