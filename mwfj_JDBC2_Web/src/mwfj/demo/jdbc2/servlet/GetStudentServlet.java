package mwfj.demo.jdbc2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.jdbc2.entities.Student;
import mwfj.demo.jdbc2.service.impl.ServiceRulesException;

/**
 * Servlet implementation class GetStudentServlet
 */
@WebServlet("/getStudent.action")
public class GetStudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		try {
			Student student = this.studentService.getStudent(id);
			if(student == null) {
				throw new ServiceRulesException("没有此ID的记录");
			} else {
				request.setAttribute("student", student);
				if(type.equals("update")) {
					request.getRequestDispatcher("/modify.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/view.jsp").forward(request, response);
				}
			}
			
		} 
		catch(ServiceRulesException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("/failed.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
