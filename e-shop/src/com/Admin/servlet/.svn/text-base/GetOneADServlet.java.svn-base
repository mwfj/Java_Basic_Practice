package com.Admin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.AD;
import com.Admin.vo.ADPager;
import com.Admin.vo.ProdPager;
import com.Admin.vo.Product;

public class GetOneADServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		ADPager adPager = (ADPager) request.getSession().getAttribute("adPager");
		Map adMap = adPager.getAdMap();
		AD ad = (AD) adMap.get(id);
		request.setAttribute("ad", ad);
		request.getRequestDispatcher("Admin/pages/manageDetailAD.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
