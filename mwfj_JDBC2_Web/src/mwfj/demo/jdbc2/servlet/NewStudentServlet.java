package mwfj.demo.jdbc2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.jdbc2.service.impl.ServiceRulesException;

/**
 * UI ---> Service
 * UI 依赖 Service ： UI 创建Service 对象
 * 
 * @author mwfj
 *
 */
@WebServlet("/newStudent.action")
public class NewStudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null;
		String age = null;
		
		name = request.getParameter("name");
		age = request.getParameter("age");
		
		try {
			System.out.println("servlet called");
			this.studentService.newStudent(name, age);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} catch(ServiceRulesException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("/failed.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/500.jsp");
		}
		
	}

}
