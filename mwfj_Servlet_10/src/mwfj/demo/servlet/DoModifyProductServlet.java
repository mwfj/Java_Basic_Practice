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
 * Servlet implementation class DoModifyProductServlet
 */
@WebServlet("/student/do_modify_product.html")
public class DoModifyProductServlet extends HttpServlet {
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
		
		ServletContext application = this.getServletContext();
		List<Product> products = (List<Product>)application.getAttribute("Products");
		Product product = null;
		for(Product p : products) {
			if(p.getId() == Long.parseLong(strId)) {
				product = p;
			}
		}
		if(product != null) {
			product.setName(strName);
			product.setNumber(strNumber);
			product.setDes(strDes);
		} 
		
		response.sendRedirect(request.getContextPath() + "/student/index.html");
	}

}
