package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.action")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 会话和cookie的清理
		 */
		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("LoginName")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
				if(cookie.getName().equals("LoginPassword")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}

}
