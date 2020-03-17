package mwfj.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rico.demo.entities.Product;

/**
 * Servlet implementation class DoRemoveProductServlet
 */
@WebServlet("/student/do_remove_product.html")
public class DoRemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("ids");
		String[] strIds = ids.split(",");
		
		List<Product> removes = new ArrayList<Product>();
		
		ServletContext application = this.getServletContext();
		List<Product> products = (List<Product>) application.getAttribute("Products");
		for(Product p : products) {
			for(String id : strIds) {
				if(p.getId() == Long.parseLong(id)) {
					removes.add(p);
				}
			}
		}
		
		products.removeAll(removes);
		
		response.sendRedirect(request.getContextPath() + "/student/index.html");
	}

}
