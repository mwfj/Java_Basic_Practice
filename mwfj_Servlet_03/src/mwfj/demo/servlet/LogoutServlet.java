package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 单例：实例变量被多线程共享
 * @author RICO
 *
 */
@WebServlet("/logout.action")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7979314848589489498L;
	
//	private String name;
	
	private StudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 局部变量，在多线程中有自己的方法栈
		String name = req.getParameter("Name");
		if(name.equals("tom")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		studentService.logout(name);
		System.out.println(name);
	}

	/**
	 * Servlet API
	 * 
	 * request
	 * response
	 * ServletConfig
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}


	
	

}
