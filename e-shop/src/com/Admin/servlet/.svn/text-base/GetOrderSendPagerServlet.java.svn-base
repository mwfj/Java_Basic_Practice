package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminOrderDao;
import com.Admin.daoimpl.AdminOrderDaoImpl;
import com.Admin.vo.OrderSendPager;
import com.Admin.vo.UserPager;

public class GetOrderSendPagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagerOffset = request.getParameter("pager.offset");
		String pageSize_str = request.getParameter("pageSize");
		int offset = 0;
		int pagecurrentPageNo = 1;
		int pageSize = 5;
		if(pagerOffset != null && pageSize_str != null) {
			offset = Integer.parseInt(pagerOffset);
			pageSize = Integer.parseInt(pageSize_str);
		}
		AdminOrderDao adminOrderDao=new AdminOrderDaoImpl();
		OrderSendPager osp = adminOrderDao.getOrderSendPager(offset, pageSize);
		if(osp.getOrderMap().size() == 0 && offset != 0) {
			offset -=pageSize;
			osp = adminOrderDao.getOrderSendPager(offset, pageSize);
		}
		if(offset%pageSize == 0 || offset/pageSize >0) {
			pagecurrentPageNo = offset/pageSize + 1;
		}
		osp.setPageOffset(offset);
		osp.setPagecurrentPageNo(pagecurrentPageNo);
		request.getSession().setAttribute("orderPager", osp);
		request.getSession().setAttribute("orderList", osp.getOrderMap().values());
		request.getRequestDispatcher("Admin/pages/manageSendOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
