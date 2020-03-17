package com.Admin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.ProdPager;
import com.Admin.vo.Product;

public class GetOneProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		ProdPager prodPager = (ProdPager) request.getSession().getAttribute("prodPager");
		Map prodMap = prodPager.getProdMap();
		Product product = (Product) prodMap.get(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("Admin/pages/manageDetailProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
