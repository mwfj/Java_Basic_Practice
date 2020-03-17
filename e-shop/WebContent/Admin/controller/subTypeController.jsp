<%@page import="com.Admin.vo.SubTypePager"%>
<%@page import="com.Admin.daoimpl.SubTypeDaoImpl"%>
<%@page import="com.Admin.dao.SubTypeDao"%>
<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map"%>
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
	SubTypeDao subTypeDao=new SubTypeDaoImpl();
	SubTypePager sp = subTypeDao.getAllSubTypes(offset,pageSize);
	if(sp.getSubTypeMap().size() == 0 && offset != 0) {
		offset -=pageSize;
		sp = subTypeDao.getAllSubTypes(offset, pageSize);
	}
	if(offset%pageSize == 0 || offset/pageSize >0) {
		pagecurrentPageNo = offset/pageSize + 1;
	}
	sp.setPageOffset(offset);
	sp.setPagecurrentPageNo(pagecurrentPageNo);
	request.getSession().setAttribute("subTypePager", sp);
	request.getSession().setAttribute("subTypeList", sp.getSubTypeMap().values());
	request.getRequestDispatcher("../pages/addSubType.jsp").forward(request, response);
%>

