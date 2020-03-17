package mwfj.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mwfj.demo.entities.Type;

/**
 * Servlet implementation class ToLoginServlet
 */
@WebServlet("/login.html")
public class ToLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 准备动态数据
		 */
		List<Type> types = new ArrayList<Type>();
		types.add(new Type(1L, "计算机", null));
		types.add(new Type(2L, "经济管理", null));
		types.add(new Type(3L, "航空分院", null));
		types.add(new Type(4L, "图艺", null));
		
		request.setAttribute("Types", types);
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
//	@RequestMapping(value="/login.html", requestMethond=GET)
//	public String toLogin( ){
//		return "login"; // 前缀 后缀
//	}

}
