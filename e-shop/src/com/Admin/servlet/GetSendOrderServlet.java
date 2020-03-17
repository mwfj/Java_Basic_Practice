package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminOrderDao;
import com.Admin.daoimpl.AdminOrderDaoImpl;

public class GetSendOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag_str = request.getParameter("flag");
		System.out.println(flag_str);
		if(flag_str != "") {
			int flag = Integer.parseInt(flag_str);
			AdminOrderDao adminOrderDao=new AdminOrderDaoImpl();
			List orderList = adminOrderDao.getNotSendOrder(flag);
			request.setAttribute("orderList", orderList);
			request.getRequestDispatcher("Admin/pages/manageOrder.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
