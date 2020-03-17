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
import com.Admin.vo.ProdPager;
import com.Admin.vo.SubTypePager;

public class GetSubTypeByIdServlet extends HttpServlet {

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
			String superTypeId_str= request.getParameter("superTypeId");
			int superType =0;
			if(superTypeId_str!=null){
				superType=Integer.parseInt(superTypeId_str);
			}
			SubTypeDao subTypeDao=new SubTypeDaoImpl();
			SubTypePager subTypePager = subTypeDao.getSubTypeBySuperId(offset,pageSize,superType);
			subTypePager.setPageOffset(offset);
			subTypePager.setPagecurrentPageNo(pagecurrentPageNo);
			subTypePager.setPageSize(pageSize);
			request.setAttribute("subTypePager", subTypePager);
			request.setAttribute("subTypeList", subTypePager.getSubTypeMap().values());
			request.getRequestDispatcher("Admin/pages/addSubType.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
