package mwfj.demo.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器类 1 针对的Application Session Request 对象的状态发生变化的
 * 这个三个对象都不是我们自己创建的，是受容器和Servlet 规范管辖， 所以，它必须提供一个接口，当他们状态发生变化的时候，我们去植入功能代码 2
 * ServletContext ----> appliction HttpSession ----> session HttpServletRequest
 * ----> request ------------------------------- ServletContextListener
 * ServletContextAttributeListener HtppSessionListener
 * 
 * HttpSessionListener, HttpSessionAttributeListener...
 * 
 * ServletRequestListener, ServletRequestAttributeListener
 * 
 * @author RICO
 * 
 */
@WebListener
public class RicoListener implements ServletContextListener,
		ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener,
		ServletRequestListener, ServletRequestAttributeListener{

	public RicoListener() {
		System.out.println("构造方法:RicoListener");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("appliction destroyed");
		ServletContext application = sce.getServletContext();
		Integer webAccessCount = (Integer) application
				.getAttribute(Tools.ACCESS_WEB_COUNT);
		Properties properties = new Properties();
		properties.setProperty(Tools.ACCESS_WEB_COUNT,
				webAccessCount.toString());
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File("D:\\web_config.properties"));
			properties.store(out, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("appliction inited");
		ServletContext application = sce.getServletContext();
		// 存入在线人数
		application.setAttribute(Tools.ONLINE_WEB_COUNT, 0);
		
		Properties properties = new Properties();
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(new File("D:\\web_config.properties"));
			
			properties.load(inStream);
			Integer accessWebAccount = 
					Integer.valueOf(
							properties.getProperty(Tools.ACCESS_WEB_COUNT, "0"));
			// 存入访问站点人数
			application.setAttribute(Tools.ACCESS_WEB_COUNT, accessWebAccount);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent sce) {
		System.out.println("application attr added");
		

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent sce) {
		System.out.println("application attr remove");

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent sce) {
		System.out.println("application attr replaced");

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
		ServletContext application = se.getSession().getServletContext();
		Integer accessWebCount = (Integer) application
				.getAttribute(Tools.ACCESS_WEB_COUNT);
		accessWebCount += 1;
		application.setAttribute(Tools.ACCESS_WEB_COUNT, accessWebCount);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destoryed");
		ServletContext application = se.getSession().getServletContext();
		
		/**
		 * 只有在登录状态下销毁session的人数减少1
		 */
		if(se.getSession().getAttribute("LoginName") != null) { 
			Integer onlineWebCount = (Integer)application.getAttribute(Tools.ONLINE_WEB_COUNT);
			onlineWebCount -= 1;
			application.setAttribute(Tools.ONLINE_WEB_COUNT, onlineWebCount);
		}
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("session added");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session added");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session added");
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
