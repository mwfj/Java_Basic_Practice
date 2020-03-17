package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product.action")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		switch (type) {
		case "del":
			String ids = request.getParameter("ids");
			System.out.println(ids);
			String[] str = ids.split(",");
			// delete from Product where id in (1,3,5);
			break;
		case "add":

			break;
		case "update":
			String id = request.getParameter("id");
			System.out.println(id);
			
			String productNumber = request.getParameter("productNumber");
			System.out.println("修改的商品的编号：" + productNumber);
			
			String productName = request.getParameter("productName");
			System.out.println("修改的商品的名称：" + productName);
			
			String productStock = request.getParameter("productStock");
			System.out.println("修改的商品的库存：" + productStock);
			break;

		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
