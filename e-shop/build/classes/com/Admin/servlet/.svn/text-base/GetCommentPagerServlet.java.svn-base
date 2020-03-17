package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminCommentDao;
import com.Admin.daoimpl.AdminCommentDaoImpl;
import com.Admin.vo.CommentPager;

public class GetCommentPagerServlet extends HttpServlet {

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
		AdminCommentDao adminCommentdao = new AdminCommentDaoImpl();
		CommentPager commentPager = adminCommentdao.getCommentPager(pageOffset, pageSize);
		if(commentPager.getCommentMap().size() == 0 && pageOffset != 0) {
			pageOffset -= pageSize;
			commentPager = adminCommentdao.getCommentPager(pageOffset, pageSize);
		}
		if(pageOffset%pageSize == 0 || pageOffset/pageSize >0) {
			pagecurrentPageNo = pageOffset/pageSize + 1;
		}
		commentPager.setPageOffset(pageOffset);
		commentPager.setPageSize(pageSize);
		commentPager.setPagecurrentPageNo(pagecurrentPageNo);
		request.setAttribute("commentPager", commentPager);
		request.setAttribute("commentList", commentPager.getCommentMap().values());
		request.getRequestDispatcher("Admin/pages/manageComments.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
