package com.Admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminProdDao;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.vo.ProdPager;

public class GetProdByNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String pageSize_str = request.getParameter("pageSize");
		int offset = 0;
		int pagecurrentPageNo = 1;
		int pageSize = 5;
		if(pageSize_str != null) {
			pageSize = Integer.parseInt(pageSize_str);
		}
		String prodName= new String(request.getParameter("prodName").getBytes("iso-8859-1"), "gbk");
			AdminProdDao adminProdDao=new AdminProdDaoImpl();
			ProdPager prodPager = adminProdDao.searchProd(prodName);
			prodPager.setPageOffset(offset);
			prodPager.setPagecurrentPageNo(pagecurrentPageNo);
			prodPager.setPageSize(pageSize);
			request.setAttribute("prodPager", prodPager);
			request.setAttribute("prodList", prodPager.getProdMap().values());
			request.getRequestDispatcher("Admin/pages/manageProducts.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
