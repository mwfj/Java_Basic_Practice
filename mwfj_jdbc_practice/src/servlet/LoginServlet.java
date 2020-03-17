package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet(name="loginServlet",urlPatterns={"/login.action"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1815037487256735328L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String login_name = req.getParameter("login_name");
		String password = req.getParameter("login_pwd");
		
		User user = new User(login_name, password);
		
		System.out.println(session.getId());
		
		session.setAttribute("User", user);
		
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

}
