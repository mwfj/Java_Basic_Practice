package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.SubType;
import com.Admin.vo.SubTypePager;

public class GetOneSubTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		SubTypePager subTypePager = (SubTypePager) request.getSession().getAttribute("subTypePager");
		Map stMap = subTypePager.getSubTypeMap();
		SubType subType = (SubType) stMap.get(id);
		request.setAttribute("subType", subType);
		request.getRequestDispatcher("Admin/pages/manageDetailSubType.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
