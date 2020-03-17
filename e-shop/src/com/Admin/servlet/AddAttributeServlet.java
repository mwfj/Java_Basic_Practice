package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.SubTypeDao;
import com.Admin.daoimpl.SubTypeDaoImpl;
import com.Admin.vo.Attr;
import com.Admin.vo.SubType;

public class AddAttributeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.setContentType("text/html;charset=gbk");
			String superTypeId = request.getParameter("superTypeId");	//获取大类ID
			String subTypeId=request.getParameter("subTypeId");        //获取小类 ID
			String attrName=new String(request.getParameter("attributeName").getBytes("iso-8859-1"), "gbk");     //获取属性名
			String attrType=request.getParameter("attrType");          //获取属性类型
			String attrValue=request.getParameter("attrValues");      // 获取属性值
			if(!"".equals(attrValue) && attrValue!=null){
				attrValue=new String(attrValue.getBytes("iso-8859-1"), "gbk");
			}
			if (attrName != null && attrType != null) {
				Attr attr = new Attr();	//创建属性对象
				attr.setAttrname(attrName);
				attr.setAttrtype(Integer.parseInt(attrType));
				attr.setAttrvalue(attrValue);
				attr.setSubtypeid(Integer.parseInt(subTypeId));
				SubTypeDao subTypeDao=new SubTypeDaoImpl();
				if (subTypeDao.addAttribute(attr)) {	//执行添加
					request.setAttribute("message", "添加成功");
				} else {
					request.setAttribute("message", "添加失败");
				}
				request.getRequestDispatcher("Admin/pages/addAttribute.jsp?subTypeId="+subTypeId
											+"&superTypeId="+superTypeId).forward(
						request, response);
			}
		}
			
		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
		}
}