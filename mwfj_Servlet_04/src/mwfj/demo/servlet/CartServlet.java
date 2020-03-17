package mwfj.demo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart.action")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 会话域中存储用户相关的东西
	 * 
	 * 购物车放入Session中
	 * 
	 * 购物车里面就是要保存商品的名字和商品的数量
	 * 
	 * 购物车的对象的构建：Map<String, Integer> cart
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, Integer> cart = null;

		HttpSession session = request.getSession();

		Object obj = session.getAttribute("Cart");

		if (obj == null) {
			// 第1次，购物车不存在，自己创建
			cart = new HashMap<String, Integer>();
		} else {
			// 第2-N次，购物车已经存在，你要取出来接着操作
			cart = (Map<String, Integer>) obj;
		}
		/**
		 * 我要知道你勾选了哪些商品要添加或者移除
		 */
		String[] fruits = request.getParameterValues("fruit");
		System.out.println("String:"+fruits);
		if (fruits != null) {
			/**
			 * 添加或移除
			 */
			String add = request.getParameter("add");
			String sub = request.getParameter("sub");
			System.out.println("Add:" + add);
			System.out.println("Sub:" + sub);

			// 添加商品
			if (add != null) {
				for(String fruit : fruits) {
					Integer count = cart.get(fruit);
					//System.out.println("Count ="+count);
					if(count == null) {
						cart.put(fruit, 1);
					} else {
						cart.put(fruit, count + 1);
					}
				}
			} else {
				// 删除商品
				for(String fruit: fruits) {
					Integer count = cart.get(fruit);
					if(count == null) {
						continue;
					} else {
						Integer newCount = count - 1;
						if(newCount >= 1) {
							cart.put(fruit, newCount);
						} else {
							cart.remove(fruit);
						}
					}
					
				}

			}
			session.setAttribute("Cart", cart);
		} else {
			// 一个商品都没有勾选
		}

		// 查看购物车
		response.sendRedirect(request.getContextPath() + "/result.jsp");
	}

}
