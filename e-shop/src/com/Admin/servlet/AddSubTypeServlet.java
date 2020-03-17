package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.SubType;

public class AddSubTypeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		String superTypeId_str = request.getParameter("superTypeId");	//获取大类ID
		String subTypeName = new String(request.getParameter("subTypeName").getBytes("iso-8859-1"), "gbk");		//获取小类名称
		//String attribute= new String(request.getParameter("attributeName").getBytes("iso-8859-1"), "gbk"); //获取属性名
		if (superTypeId_str != null && subTypeName != null) {
			SubType subType = new SubType();	//创建小类对象
			subType.setSuperTypeId(Integer.parseInt(superTypeId_str));	//设置大类ID
			subType.setTypeName(subTypeName);	//设置小类名词
			SubTypeDao subTypeDao=new SubTypeDaoImpl();
			if (subTypeDao.addSubType(subType)) {	//ִ执行添加
				request.setAttribute("message", "添加成功");
			} else {
				request.setAttribute("message", "添加失败");
			}
			request.getRequestDispatcher("Admin/controller/subTypeController.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
