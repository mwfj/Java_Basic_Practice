package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminProdDao;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.vo.ProdPager;

public class GetProdPagerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageOffset_str = request.getParameter("pager.offset");	//获取每页前一记录值
		String pageSize_str = request.getParameter("pageSize");	//获取每页记录数
		int pageOffset = 0;		//默认记录值为0
		int pageSize = 5;		//默认每页记录数为5
		int pagecurrentPageNo = 0;
		if(pageOffset_str != null && pageSize_str != null) {	//如果接收到参数
			pageOffset = Integer.parseInt(pageOffset_str);	//转换为前一记录值
			pageSize = Integer.parseInt(pageSize_str);		//转换为每页记录数
		}
		AdminProdDao adminProdDao=new AdminProdDaoImpl();
		ProdPager prodPager = adminProdDao.getProdPager(pageOffset, pageSize);	//获取产品集合
		if(prodPager.getProdMap().size() == 0 && pageOffset != 0) {
			pageOffset -= pageSize;
			prodPager = adminProdDao.getProdPager(pageOffset, pageSize);
		}
		if(pageOffset%pageSize == 0 || pageOffset/pageSize >0) {
			pagecurrentPageNo = pageOffset/pageSize + 1;	//当前页加一
		}
		prodPager.setPageOffset(pageOffset);	//设置记录值
		prodPager.setPageSize(pageSize);		//设置每页记录数
		prodPager.setPagecurrentPageNo(pagecurrentPageNo);	//设置当前页
		request.getSession().setAttribute("prodPager", prodPager);
		request.getSession().setAttribute("prodList", prodPager.getProdMap().values());
		request.getRequestDispatcher("Admin/pages/manageProducts.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
