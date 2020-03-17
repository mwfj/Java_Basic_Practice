package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.Attr;
import com.Admin.vo.AttributePager;
import com.Admin.vo.SubType;
import com.Admin.vo.SubTypePager;
import com.Admin.vo.SuperType;
import com.Admin.vo.SuperTypePager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class GetOneAttributeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		AttributePager attrPager = (AttributePager) request.getSession().getAttribute("attributePager");
		Map attrMap = attrPager.getAttributeMap();
		Attr attr = (Attr) attrMap.get(id);
		request.setAttribute("attribute", attr);
		request.getRequestDispatcher("Admin/pages/manageDetailAttr.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
