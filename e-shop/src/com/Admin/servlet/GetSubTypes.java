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
import com.Admin.vo.SubType;

public class GetSubTypes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		SubTypeDao subTypeDao=new SubTypeDaoImpl();
		List subTypes = subTypeDao.getSubTypes();
		out.println("<subTypes>");
		for(int i = 0;i<subTypes.size();i++) {
			SubType subType = (SubType)subTypes.get(i);
			out.println("<subType>");
			out.println("<subTypeId>"+subType.getSubTypeId()+"</subTypeId>");
			out.println("<subTypeName>"+subType.getTypeName()+"</subTypeName>");
			out.println("</subType>");
		}
		out.println("</subTypes>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
