package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminNoticeDao;
import com.Admin.daoimpl.AdminNoticeDaoImpl;
import com.Admin.vo.NoticePager;

public class GetNoticePagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageOffset_str = request.getParameter("pager.offset");
		String pageSize_str = request.getParameter("pageSize");
		int pageOffset = 0;
		int pageSize = 5;
		int pagecurrentPageNo = 0;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		AdminNoticeDao adminNoticeDao=new AdminNoticeDaoImpl();
		NoticePager noticePager = adminNoticeDao.getNoticePager(pageOffset, pageSize);
		if(noticePager.getNoticeMap().size() == 0 && pageOffset != 0) {
			pageOffset -= pageSize;
			noticePager = adminNoticeDao.getNoticePager(pageOffset, pageSize);
		}
		if(pageOffset%pageSize == 0 || pageOffset/pageSize >0) {
			pagecurrentPageNo = pageOffset/pageSize + 1;
		}
		noticePager.setPageOffset(pageOffset);
		noticePager.setPageSize(pageSize);
		noticePager.setPagecurrentPageNo(pagecurrentPageNo);
		request.setAttribute("noticePager", noticePager);
		request.setAttribute("noticeList", noticePager.getNoticeMap().values());
		request.getRequestDispatcher("Admin/pages/manageNotice.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
