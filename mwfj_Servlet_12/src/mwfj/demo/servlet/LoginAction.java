package mwfj.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginName = request.getParameter("LoginName");
		String loginPassword = request.getParameter("LoginPassword");

		PrintWriter out = null;
		try {
			out = response.getWriter();

			if (loginName.equalsIgnoreCase("tom")
					&& loginPassword.equalsIgnoreCase("1234")) {
				out.print(true);
			} else {
				out.print(false);
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

}
