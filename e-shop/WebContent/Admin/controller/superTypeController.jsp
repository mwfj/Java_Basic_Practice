<%@page import="com.Admin.daoimpl.SuperTypeDaoImpl"%>
<%@page import="com.Admin.dao.SuperTypeDao"%>
<%@page import="com.Admin.vo.SuperTypePager"%>
<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map" %>
<%
	String path=request.getContextPath();
	String pagerOffset = request.getParameter("pager.offset");
	String pageSize_str = request.getParameter("pageSize");
	int offset = 0;
	int pagecurrentPageNo = 1;
	int pageSize = 5;
	if(pagerOffset != null && pageSize_str != null) {
		offset = Integer.parseInt(pagerOffset);
		pageSize = Integer.parseInt(pageSize_str);
	}
	SuperTypeDao superTypeDao=new SuperTypeDaoImpl();
	SuperTypePager sp = superTypeDao.getAllSuperTypes(offset,pageSize);
	if(sp.getSuperTypeMap().size() == 0 && offset != 0) {
		offset -=pageSize;
		sp = superTypeDao.getAllSuperTypes(offset, pageSize);
	}
	if(offset%pageSize == 0 || offset/pageSize >0) {
		pagecurrentPageNo = offset/pageSize + 1;
	}
	sp.setPageOffset(offset);
	sp.setPagecurrentPageNo(pagecurrentPageNo);
	request.getSession().setAttribute("superTypePager", sp);
	request.getSession().setAttribute("superTypeList", sp.getSuperTypeMap().values());
	request.getRequestDispatcher("../pages/addSuperType.jsp").forward(request, response);
%>

