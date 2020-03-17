package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.SuperTypeDao;
import com.Admin.daoimpl.SuperTypeDaoImpl;
import com.Admin.vo.SuperType;

public class AddSuperTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		String superTypeName = new String(request.getParameter("superTypeName").getBytes("iso-8859-1"), "gbk");	//获取大类名称 
		if (superTypeName != null) {		//如果大类名称不为空
			SuperType superType = new SuperType();	//创建大类对象
			superType.setTypeName(superTypeName);	//设置大类名称
			SuperTypeDao superTypeDao =new SuperTypeDaoImpl();
			if (superTypeDao.addSuperType(superType)) {	//执行添加
				request.setAttribute("message", "添加成功");
			} else {
				request.setAttribute("message", "添加失败");
			}
			request.getRequestDispatcher("Admin/controller/superTypeController.jsp")
					.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
