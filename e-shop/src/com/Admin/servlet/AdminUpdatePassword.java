package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminLoginDao;
import com.Admin.daoimpl.AdminLoginDaoImpl;
import com.Admin.vo.Admin;

public class AdminUpdatePassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		String name = request.getParameter("name");
		System.out.println(password+":"+rpassword);
		if(password != null && rpassword != null && name != null) {
			if(!password.equals(rpassword)) {
				request.setAttribute("message", "两次输入的密码不能相同");
				request.getRequestDispatcher("Admin/pages/updatePassword.jsp").forward(request, response);
			} else {
				Admin admin = new Admin();
				admin.setName(name);
				admin.setPassword(password);
				AdminLoginDao adminLoginDao=new AdminLoginDaoImpl();
				if(adminLoginDao.updatePassword(admin)) {
					request.setAttribute("message", "修改成功");
					request.getRequestDispatcher("Admin/pages/updatePassword.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("Admin/pages/updatePassword.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
