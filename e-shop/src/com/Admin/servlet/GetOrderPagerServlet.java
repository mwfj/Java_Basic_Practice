package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminOrderDao;
import com.Admin.vo.OrderPager;
import com.Admin.daoimpl.AdminOrderDaoImpl;

public class GetOrderPagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagerOffset = request.getParameter("pager.offset");	//获取记录值
		String pageSize_str = request.getParameter("pageSize");		//获取每页记录数
		int offset = 0;		//默认从1开始
		int pageSize = 5;	//默认每页显示条记录
		if(pagerOffset != null && pageSize_str != null) {
			offset = Integer.parseInt(pagerOffset);		//获取记录值
			pageSize = Integer.parseInt(pageSize_str);	//获取每页记录数
		}
		AdminOrderDao adminOrderDao=new AdminOrderDaoImpl();
		OrderPager op = adminOrderDao.getOrderPager(offset,pageSize);	//获取分页订单
		op.setPageOffset(offset);		//设置记录值
		op.setPageSize(pageSize);		//设置每页的显示数
		request.getSession().setAttribute("orderPager", op);
		request.getSession().setAttribute("orderList", op.getOrderMap().values());
		request.getRequestDispatcher("Admin/pages/manageOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
