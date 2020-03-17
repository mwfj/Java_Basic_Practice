package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.SuperType;
import com.Admin.vo.SuperTypePager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class GetOneSuperTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		SuperTypePager superTypePager = (SuperTypePager) request.getSession().getAttribute("superTypePager");
		Map stMap = superTypePager.getSuperTypeMap();
		SuperType superType = (SuperType) stMap.get(id);
		request.setAttribute("superType", superType);
		request.getRequestDispatcher("Admin/pages/manageDetailSuperType.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
