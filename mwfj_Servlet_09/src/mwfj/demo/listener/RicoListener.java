package mwfj.demo.listener;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class RicoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 try {
//			Connection connection = DBHandler.getConnection();
//			System.out.println(connection);
			 
			 Context ctx = new InitialContext();
			 DataSource dataSource = 
					 // JNDI 方式
						(DataSource)ctx.lookup("java:/comp/env/jdbc/zk");
			 Connection connection = dataSource.getConnection();

			 System.out.println("JNDI 获得连接：" + connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
