package mwfj.demo.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class ToLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2344312211623908928L;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--get--");
		// 请求转发，服务器内部跳转
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}


	
	
	
	
	
	

}
