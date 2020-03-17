package mwfj.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitValidateCode = request.getParameter("validateCode");
		
		String serverValidateCode = (String)request.getSession().getAttribute("ValidateCode");
		
		System.out.println("提交的验证码：" + submitValidateCode);
		System.out.println("服务器产生的验证码：" + serverValidateCode);
		
		// 不区分大小写比较
		if(submitValidateCode.equalsIgnoreCase(serverValidateCode)) {
			
		}
		
	}

}
