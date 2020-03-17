package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminUserDao;
import com.Admin.dao.SubTypeDao;
import com.Admin.dao.SuperTypeDao;
import com.Admin.daoimpl.AdminUserDaoImpl;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.daoimpl.SuperTypeDaoImpl;

public class DeleteTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Types_str = request.getParameter("typeIds");
		String pageOffset_str = request.getParameter("pageOffset");
		String pageSize_str = request.getParameter("pageSize");
		String type=request.getParameter("type");
		int pageOffset = 0;
		int pageSize = 5;
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		String[] ids_str = null;
		if(Types_str != "") {
			ids_str = Types_str.split(",");
		}
		int[] ids = new int[ids_str.length];
		for(int i=0;i<ids_str.length;i++) {
			ids[i] = Integer.parseInt(ids_str[i]);
		}
		SuperTypeDao superTypeDao = new SuperTypeDaoImpl();
		SubTypeDao subTypeDao = new SubTypeDaoImpl();
		if(type.equals("super")){
			if(superTypeDao.deleteSuperType(ids)) {
				request.getRequestDispatcher("Admin/controller/superTypeController.jsp?" +
						"pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
			}
		}else if(type.equals("sub")){
			if(subTypeDao.deleteSubType(ids)) {
				request.getRequestDispatcher("Admin/controller/subTypeController.jsp?" +
						"pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
			}
		}else if(type.equals("brand")){
			if(subTypeDao.deleteBrand(ids)){
				if(subTypeDao.deleteBrand(ids)) {
					request.getRequestDispatcher("Admin/controller/brandController.jsp?" +
							"pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
				}
			}
		}else if(type.equals("attribute")){
			if(subTypeDao.deleteBrand(ids)){
				if(subTypeDao.deleteAttribute(ids)) {
					request.getRequestDispatcher("Admin/controller/attributeController.jsp?" +
							"pager.offset="+pageOffset+"&pageSize="+pageSize).forward(request, response);
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
