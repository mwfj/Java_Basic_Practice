package mwfj.demo.jdbc2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.jdbc2.commons.Pager;

/**
 * Servlet implementation class GetStudentsServlet
 */
@WebServlet("/getStudents.action")
public class GetStudentsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Student> students = null;
		
		String pagerNO = request.getParameter("pagerNO");
		String pagerSize = request.getParameter("pagerSize");
		// like %%
		String keywords = request.getParameter("keywords");
		if(keywords == null) {
			keywords = "";
		}
		
		
		try {
//			Pager pager  = this.studentService.getStudents(pagerNO);
			Pager pager  = this.studentService.getStudents(pagerNO, pagerSize, keywords);
			request.setAttribute("pager", pager);
			request.getSession().setAttribute("selectedValue", pager.getPagerSize());
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}

}
