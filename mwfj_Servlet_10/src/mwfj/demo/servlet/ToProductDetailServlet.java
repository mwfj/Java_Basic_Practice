package mwfj.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.Product;
import mwfj.demo.tools.ValidateTools;

/**
 * Servlet implementation class ToProductDetailServlet
 */
@WebServlet("/student/product_detail.html")
public class ToProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		if(strId != null) {
			if(ValidateTools.isNumber(strId)) {
				Long id = Long.parseLong(strId);
				Product product = null;
				List<Product> products = (List<Product>)this.getServletContext().getAttribute("Products");
				for(Product p : products) {
					if(p.getId() == id) {
						product = p;
					}
				}
				if(product != null) {
					request.setAttribute("Product", product);
					request.getRequestDispatcher("/WEB-INF/jsp/user/product_detail.jsp").forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/student/index.html");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/student/index.html");
			}
		} else {
			// id is NULL
			response.sendRedirect(request.getContextPath() + "/student/index.html");
		}
		
		
	}

}
