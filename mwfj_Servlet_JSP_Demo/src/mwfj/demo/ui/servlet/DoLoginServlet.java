package mwfj.demo.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mwfj.demo.entities.Student;
import mwfj.demo.service.StudentService;
import mwfj.demo.service.impl.BusinessException;
import mwfj.demo.service.impl.StudentServiceImpl;

/**
 * 注解条件： 1） Web Module 3.0+ 2） tomcat 7.0+ 3）servlet jar 3.0+
 * 
 * @author mwfj
 * 
 */
@WebServlet("/doLogin.html")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentServiceImpl();

	/**
	 * JSON 
	 * 注解
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--post--登录--");
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");

		System.out.println(loginName);
		System.out.println(loginPassword);

		try {
			
			
			Student student = this.studentService.login(loginName,
					loginPassword);
			if (student == null) {
				
//				request.setAttribute("ErrorMsg", "你输入的登录名或密码有错。");
//				request.getRequestDispatcher("/login.html").forward(request, response);
				
				response.sendRedirect(request.getContextPath() + "/login.html?errorMsg=1");
				
			} else {
				/**
				 * Student 对象存入session
				 * 跳转到index.html页面
				 */
				HttpSession session = request.getSession();
				session.setAttribute("Student", student);
				response.sendRedirect(request.getContextPath() + "/index.html");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			/*response.sendRedirect(request.getContextPath() + "/login.html?errorMsg=2");*/
			response.sendRedirect(request.getContextPath() + "/login.html");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			response.sendRedirect(request.getContextPath() + "/500.html");
		}

	}

}
