package mwfj.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.A;
import mwfj.demo.entities.B;
import mwfj.demo.entities.Product;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/preparedIndex.action")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("--servlet--");
		
		/**
		 * 准备数据
		 */
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "cn0001", "苹果", 10));
		products.add(new Product(2L, "cn0002", "香蕉", 20));
		products.add(new Product(3L, "cn0003", "草莓", 30));
		products.add(new Product(4L, "cn0004", "橘子", 40));
		products.add(new Product(5L, "cn0005", "西瓜", 50));
		
		request.setAttribute("products", products);
		
		A a = new A();
		a.setName("This is a.");
		B b = new B("This is b", 100);
		a.setB(b);
		
		request.setAttribute("a", a);
		
		
		// 请求转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
