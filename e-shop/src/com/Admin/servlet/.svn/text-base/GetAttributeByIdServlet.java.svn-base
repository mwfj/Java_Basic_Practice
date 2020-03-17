package com.Admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminProdDao;
import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.AttributePager;
import com.Admin.vo.ProdPager;
import com.Admin.vo.SubTypePager;

public class GetAttributeByIdServlet extends HttpServlet {

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
			String subTypeId_str= request.getParameter("subTypeId");
			int subType =0;
			if(subTypeId_str!=null){
				subType=Integer.parseInt(subTypeId_str);
			}
			SubTypeDao subTypeDao=new SubTypeDaoImpl();
			AttributePager ap = subTypeDao.getAttributeById(offset,pageSize,subType);
			ap.setPageOffset(offset);
			ap.setPagecurrentPageNo(pagecurrentPageNo);
			request.getSession().setAttribute("attributePager", ap);
			request.getSession().setAttribute("attributeList", ap.getAttributeMap().values());
			request.getRequestDispatcher("Admin/pages/addAttribute.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
