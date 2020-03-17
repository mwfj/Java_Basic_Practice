package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminNoticeDao;
import com.Admin.daoimpl.AdminNoticeDaoImpl;

public class DeleteNoticeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String notices = request.getParameter("notices");
		String pageOffset_str = request.getParameter("pageOffset");
		String pageSize_str = request.getParameter("pageSize");
		String type=request.getParameter("type");
		int pageOffset = 0;
		int pageSize = 5;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		if(notices != "") {
			String[] ids_str = notices.split(",");
			int[] ids = new int[ids_str.length];
			for(int i=0;i<ids_str.length;i++) {
				ids[i] = Integer.parseInt(ids_str[i]);
			}
			AdminNoticeDao adminNoticeDao=new AdminNoticeDaoImpl();
			if(type.equals("ad")){
				if(adminNoticeDao.deleteAD(ids)) {
					request.getRequestDispatcher("getADPagerServlet?pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
				}
			}else{
				if(adminNoticeDao.deleteNotice(ids)) {
					request.getRequestDispatcher("getNoticePagerServlet?pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
