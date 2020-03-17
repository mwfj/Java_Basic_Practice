package mwfj.demo.hibernate.ui.many_to_many;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mwfj.demo.hibernate.entities.Order;
import mwfj.demo.hibernate.entities.OrderItems;
import mwfj.demo.hibernate.entities.Product;
import mwfj.demo.hibernate.tools.HibernateUtil;

public class MainModule2 {
	
	static void doSave() {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			Product p1 = new Product("MobilePhone");
			Product p2 = new Product("Furniture");
			Product p3 = new Product("Clothes");
			
			Order o1 = new Order("00001");
			Order o2 = new Order("00002");
			Order o3 = new Order("00003");
			
			OrderItems oi1 = new OrderItems(new BigDecimal("5288"), o1, p1);
			OrderItems oi2 = new OrderItems(new BigDecimal("1299"), o1, p3);
			OrderItems oi3 = new OrderItems(new BigDecimal("6666"), o2, p3);
			OrderItems oi4 = new OrderItems(new BigDecimal("5555"), o3, p2);
			
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(o1);
			session.save(o2);
			session.save(o3);
			session.save(oi1);
			session.save(oi2);
			session.save(oi3);
			session.save(oi4);
		
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
			
			List<Order> orders = session.createCriteria(Order.class).list();
			if(orders != null) {
				for (Order order : orders) {
					System.out.println("Order num：" + order.getNumber());
					System.out.println("Order:");
					for(OrderItems oi : order.getOrderItems()) {
						System.out.println(  "Price" + oi.getPrice() + "Product Name:"  + "\t"  +  oi.getProduct().getName());
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
