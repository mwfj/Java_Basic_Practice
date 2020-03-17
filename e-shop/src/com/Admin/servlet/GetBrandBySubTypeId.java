package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.Brand;
import com.Admin.vo.SubType;

public class GetBrandBySubTypeId extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String subTypeId = request.getParameter("subTypeId");
		int subTypeid=0;
		if(subTypeId != "") {
			subTypeid = Integer.parseInt(subTypeId);
		}
		SubTypeDao subTypeDao=new SubTypeDaoImpl();
		List brands = subTypeDao.getBrandBySubTypeId(subTypeid);
		out.println("<brands>");
		for(int i = 0;i<brands.size();i++) {
			Brand brand = (Brand)brands.get(i);
			out.println("<brand>");
			out.println("<brandId>"+brand.getBrandid()+"</brandId>");
			out.println("<brandName>"+brand.getBrandname()+"</brandName>");
			out.println("</brand>");
		}
		out.println("</brands>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}

}
