package mwfj.demo.ui.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.Student;
import mwfj.demo.service.StudentService;
import mwfj.demo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ToIndexServlet
 */
@WebServlet("/index.html")
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 数据准备完成
		 * 
		 * page request session application
		 * 
		 */
		
		String pageNo = request.getParameter("pageNo");

		try {
			List<Student> students = this.studentService.getStudents(pageNo);
			request.setAttribute("Students", students);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}

}
