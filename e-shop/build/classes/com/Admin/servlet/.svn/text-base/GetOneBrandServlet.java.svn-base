package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.Brand;
import com.Admin.vo.BrandPager;
import com.Admin.vo.SubType;
import com.Admin.vo.SubTypePager;
import com.Admin.vo.SuperType;
import com.Admin.vo.SuperTypePager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class GetOneBrandServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		BrandPager brandPager = (BrandPager) request.getSession().getAttribute("brandPager");
		Map brandMap = brandPager.getBrandMap();
		Brand brand = (Brand) brandMap.get(id);
		request.setAttribute("brand", brand);
		request.getRequestDispatcher("Admin/pages/manageDetailBrand.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
