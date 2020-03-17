package mwfj.demo.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadingServlet
 */
@WebServlet("/load.action")
public class LoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--get--");
		String name = request.getParameter("name");
		System.out.println(name);
		
		// 响应
		PrintWriter out = null;
		try {
			// 乱码
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.print("<h3>大家好，欢迎来到ajax的世界-GET</h3>");
		} finally {
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("--post--");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		
		
		// 响应
		PrintWriter out = null;
		try {
			// 乱码
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.print("<h3>大家好，欢迎来到ajax的世界-POST</h3>");
		} finally {
			out.close();
		}
	}

}
