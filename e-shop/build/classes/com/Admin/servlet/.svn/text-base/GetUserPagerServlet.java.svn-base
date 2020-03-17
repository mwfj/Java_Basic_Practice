package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminUserDao;
import com.Admin.daoimpl.AdminUserDaoImpl;
import com.Admin.vo.UserPager;

public class GetUserPagerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		AdminUserDao adminUserDao=new AdminUserDaoImpl();
		UserPager up = adminUserDao.getUserPager(offset, pageSize);
		if(up.getUserMap().size() == 0 && offset != 0) {
			offset -=pageSize;
			up = adminUserDao.getUserPager(offset, pageSize);
		}
		if(offset%pageSize == 0 || offset/pageSize >0) {
			pagecurrentPageNo = offset/pageSize + 1;
		}
		up.setPageOffset(offset);
		up.setPagecurrentPageNo(pagecurrentPageNo);
		request.getSession().setAttribute("userPager", up);
		request.getSession().setAttribute("userList", up.getUserMap().values());
		request.getRequestDispatcher("Admin/pages/manageUsers.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
