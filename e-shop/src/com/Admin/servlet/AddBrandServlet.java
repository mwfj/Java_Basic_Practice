package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.Attr;
import com.Admin.vo.Brand;

public class AddBrandServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		String superTypeId = request.getParameter("superTypeId");	//获取大类ID
		String subTypeId=request.getParameter("subTypeId");        //获取小类ID
		String brandName=new String(request.getParameter("brandName").getBytes("iso-8859-1"), "gbk");     //获取属性名
		Brand brand = new Brand();	//创建属性对象
		brand.setSubtypeid(Integer.parseInt(subTypeId));
		brand.setBrandname(brandName);
		SubTypeDao subTypeDao=new SubTypeDaoImpl();
		if (subTypeDao.addBrand(brand)) {	//ִ执行添加
			request.setAttribute("message", "添加成功");
		} else {
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("Admin/controller/brandController.jsp?subTypeId="+subTypeId
									+"&superTypeId="+superTypeId).forward(
				request, response);
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
}
