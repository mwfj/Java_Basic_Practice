package com.Admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminLoginDao;
import com.Admin.daoimpl.AdminLoginDaoImpl;
import com.Admin.vo.Admin;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String path=request.getContextPath();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);
		AdminLoginDao adminLoginDao=new AdminLoginDaoImpl();
		boolean result=adminLoginDao.login(admin);
		if(result){
			ServletContext context = this.getServletContext();
			//List adminList = (List) context.getAttribute("adminList");
			//System.out.println(adminList.size());
			//if(!adminList.contains("admin")) {
				request.getSession().setAttribute("admin", admin);
				request.getSession().setAttribute("merchantId", "admin");
				response.sendRedirect("Admin/pages/adminConter.jsp");
			//} else {
				//request.setAttribute("message","ÒÑµÇÂ¼");
				//request.getRequestDispatcher("Admin/login/adminLogin.jsp").forward(request, response);
			//}
		}else{
			response.sendRedirect(path+"/error.jsp");
		}
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
