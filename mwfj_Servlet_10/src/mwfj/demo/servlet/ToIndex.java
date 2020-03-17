package mwfj.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.Product;

/**
 * Servlet implementation class ToIndex
 */
@WebServlet("/student/index.html")
public class ToIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 准备动态数据
		 */
		
		List<Product> products =(List<Product>) this.getServletContext().getAttribute("Products");
		request.setAttribute("Products", products);
		
		request.getRequestDispatcher("/WEB-INF/jsp/user/index.jsp").forward(request, response);
	}

}
