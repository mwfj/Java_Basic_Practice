package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rico.demo.listener.Tools;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		
		HttpSession session = request.getSession();
		session.setAttribute("LoginName", loginName);
		
		ServletContext application = this.getServletContext();
		Integer onlineWebCount = (Integer)application.getAttribute(Tools.ONLINE_WEB_COUNT);
		onlineWebCount += 1;
		application.setAttribute(Tools.ONLINE_WEB_COUNT, onlineWebCount);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

}
