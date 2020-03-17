package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
@WebServlet(name = "loginServlet", urlPatterns={"/login.action"})
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("login_name");
		String pwd = req.getParameter("login_password");
		System.out.println(name);
		System.out.println(pwd);
			
		
		//通过校验之后创建user对象
		User user = new User(name, pwd);
		
		//创建session对象
		HttpSession session =req.getSession();
		String sessionID = session.getId();
		System.out.println("sessionID:"+sessionID);
		session.setAttribute("User", user);

		//页面跳转到main.jsp
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
		
	}

}
