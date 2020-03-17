package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mwfj.demo.business.UserBusiness;
import mwfj.demo.business.impl.BusinessException;
import mwfj.demo.business.impl.UserBusinessImpl;
import mwfj.demo.entities.User;

@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserBusiness userBusiness = new UserBusinessImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		String isCookie = request.getParameter("flag");
		String autoLogin = request.getParameter("autoLogin");
		System.out.println("是否要自动登录：" + autoLogin);

		if (isCookie != null) {
			// Filter 放过来的
			try {
				User user = this.userBusiness.login(loginName, loginPassword);
				if (user == null) {
					response.sendRedirect(request.getContextPath()
							+ "/login.jsp?errorCode="
							+ "loginName or loginPassword is failed.");
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} else {
			// 表单提交
			try {

				/**
				 * 先判断登录名和登录密码
				 */
				User user = this.userBusiness.login(loginName, loginPassword);

				if (user == null) {
					response.sendRedirect(request.getContextPath()
							+ "/login.jsp?errorCode="
							+ "loginName or loginPassword is failed.");
				} else {
					if (autoLogin == null) {
						// 不要自动登录

					} else {
						// 自动登录

						Cookie cookieLoginName = new Cookie("LoginName",
								loginName);
						/**
						 * 密码，你应该采用加密，变成密文 Cookie里面不能存中文
						 */
						Cookie cookieLoginPassword = new Cookie(
								"LoginPassword", loginPassword);

						/**
						 * 设置Cookie的有效时间，单位秒
						 */
						cookieLoginName.setMaxAge(60 * 60 * 24);
						cookieLoginPassword.setMaxAge(60 * 60 * 24);

						response.addCookie(cookieLoginName);
						response.addCookie(cookieLoginPassword);

					}

					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}

			} catch (BusinessException e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath()
						+ "/login.jsp?errorCode="
						+ new String(e.getMessage().getBytes("UTF-8"),
								"ISO-8859-1"));

			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}

		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

	}

}
