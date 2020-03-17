package mwfj.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rico.demo.entities.Product;

/**
 * Servlet implementation class DoNewProductServlet
 */
@WebServlet("/student/do_new_product.html")
public class DoNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strId = request.getParameter("productId");
		String strNumber = request.getParameter("productNumber");
		String strName= request.getParameter("productName");
		String strDes = request.getParameter("productDes");
		
		Product product = new Product(Long.parseLong(strId), strNumber, strName, strDes);
		ServletContext application = this.getServletContext();
		List<Product> products = (List<Product>) application.getAttribute("Products");
		products.add(product);
		application.setAttribute("Products", products);
		
		response.sendRedirect(request.getContextPath() + "/student/index.html");
		
	}

}
