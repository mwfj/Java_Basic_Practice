package mwfj.demo.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mwfj.demo.entities.Product;

/**
 * Application Lifecycle Listener implementation class RicoListener
 *
 */
@WebListener
public class RicoListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public RicoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	/**
    	 * 模仿数据库
    	 */
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "0001", "iPhone 4", "苹果开始火了"));
        products.add(new Product(2L, "0002", "iPhone 4S", "乔布斯时代最经典的"));
        products.add(new Product(3L, "0003", "iPhone 5", "上市最短的苹果"));
        products.add(new Product(4L, "0004", "iPhone 5S", "土豪金"));
        products.add(new Product(5L, "0005", "iPhone 5C", "塑料版"));
        products.add(new Product(6L, "0006", "iPhone 6", "苹果大屏"));
        products.add(new Product(7L, "0007", "iPhone 6 Plus", "屏幕最好的"));
        
        sce.getServletContext().setAttribute("Products", products);
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
