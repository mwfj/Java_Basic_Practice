package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminUserDao;
import com.Admin.daoimpl.AdminUserDaoImpl;

public class DeleteMerchantServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String merchants_str = request.getParameter("merchantIds");
		String pageOffset_str = request.getParameter("pageOffset");
		String pageSize_str = request.getParameter("pageSize");
		int pageOffset = 0;
		int pageSize = 5;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		String[] ids_str = null;
		if(merchants_str != "") {
			ids_str = merchants_str.split(",");
		}
		int[] ids = new int[ids_str.length];
		for(int i=0;i<ids_str.length;i++) {
			ids[i] = Integer.parseInt(ids_str[i]);
		}
		AdminUserDao adminUserDao = new AdminUserDaoImpl();
		if(adminUserDao.deleteMerchants(ids)) {
			request.getRequestDispatcher("getMerchantPagerServlet?pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
