package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4858607474381497912L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--get--");
//		this.doPost(request, response);
		
		response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---post---");

		// 字符集处理
		request.setCharacterEncoding("UTF-8");

		/**
		 * 对与get和post都有效
		 * post: 参数名：表单控件中的name值
		 * 
		 * URL 传参：URL?参数名1=参数值1&参数名2=参数值2&参数名3=参数值3
		 * get：参数名：URL传参的参数名
		 */
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");

		System.out.println(loginName);
		System.out.println(loginPassword);

		/**
		 * ContentType: text/html
		 * response.setContentType("text/html");
		 */
		
//		PrintWriter out = response.getWriter();
//		try {
////			out.print("Success");
//			
//			out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
//			
//			out.print("<html>");
//			out.print("<head>");
//			out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
//			out.print("<title>Success</title>");
//			out.print("</head>");
//			out.print("<body>");
//			out.print("<h3>Thanks Success Login</h3>");
//			out.print("<button onClick=\"alert('Hello')\">click me</button>");
//			out.print("</body>");
//			out.print("</html>");
//		} finally {
//			if (out != null) {
//				out.close();
//			}
//		}
		
		/**
		 * 请求转发
		 * 服务器内部跳转
		 * 1）在多个组件转发，是一次请求：共享request域里面的数据
		 * page
		 * request
		 * session
		 * application
		 * 
		 * 2）客户端的URL地址是不会发生变化的
		 */
		
		if(loginName.equals("tom") && loginPassword.equals("123456")) {
			User user = new User();
			user.setLoginName(loginName);
			user.setLoginPassword(loginPassword);
			
//			request.setAttribute("LoginName", loginName);
			request.setAttribute("User", user);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
//			response.sendRedirect(request.getContextPath() + "/user/login.jsp?errorCode=1");
			request.setAttribute("ErrorMsg", "登录名或登录密码错误！");
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
		
		
		
		/**
		 * 重定向
		 * 1) 两次请求，两次响应
		 * 2）客户端地址栏发生变化，/login.action   /success.jsp
		 * 3）两次请求的request对象不同，所以，你在第一次request里面存储的数据
		 * 在第二次request里面无效
		 * 4）request.getContextPath() 获得工程的根路径
		 */
//		response.sendRedirect(request.getContextPath() + "/success.jsp");

	}

}
