package servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name="logout", urlPatterns={"/logout"})
public class LogoutServlet extends HttpServlet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession logout_sessioin = req.getSession();
		//清空session
		logout_sessioin.invalidate();
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
