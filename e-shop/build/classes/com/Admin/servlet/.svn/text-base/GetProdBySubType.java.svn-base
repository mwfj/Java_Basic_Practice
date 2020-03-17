package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminProdDao;
import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.Product;
import com.Admin.vo.SubType;

public class GetProdBySubType extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String subTypeId_str = request.getParameter("subTypeId");
		int subTypeId = 0;
		if(subTypeId_str != null) {
			subTypeId = Integer.parseInt(subTypeId_str);
		}
		AdminProdDao adminProdDao=new AdminProdDaoImpl();
		List products = adminProdDao.getProdBySubTypeId(subTypeId);
		out.println("<products>");
		for(int i = 0;i<products.size();i++) {
			Product prod = (Product)products.get(i);
			out.println("<product>");
			out.println("<productId>"+prod.getProductid()+"</productId>");
			out.println("<productName>"+prod.getProductname()+"</productName>");
			out.println("</product>");
		}
		out.println("</products>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
