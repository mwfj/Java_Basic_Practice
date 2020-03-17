package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.Product;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/preparedModify.action")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		System.out.println(productId);
		
		Product product = new Product(1L, "cn0001", "苹果", 10);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/modify.jsp").forward(request, response);
	}

}
