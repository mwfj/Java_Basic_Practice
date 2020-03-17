package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mwfj.demo.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 登录是会话的一个应用，为什么要将User对象放在回话中
	 * 1） 多个页面要用到User的信息
	 * 2）登录的时候我不想暴露login.action表单提交的URL
	 * 3）会话中的User对象是否存在，作为用户成功登录该站点的判断依据
	 * 
	 * 会话：用户和服务器之间的关系，User本身掌管用户信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		
		System.out.println(loginName);
		
		User user = new User(loginName, loginPassword);
		
		/**
		 * request.getSession();
		 * request.getSession(true);
		 * ---------------------------------
		 * 对于该URL请求，如果先前已经创建过回话，那么取出来；如果没有，就理解给你创建一个
		 * ---------------------------------
		 * request.getSession(false);
		 * 对于该URL请求，如果先前已经创建过回话，那么取出来；如果没有，不创建，返回Null
		 */
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println(sessionId);
		session.setAttribute("User", user);

		request.setAttribute("User", user);
		
//		request.getRequestDispatcher("/a.jsp").forward(request, response);
		
		/**
		 * Java代码中重定向的写法
		 */
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		/**
		 * Java代码的请求转发，服务器内部跳转
		 */
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
