<%@page import="com.Admin.vo.BrandPager"%>
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
	BrandPager bp = subTypeDao.getAllBrands(offset,pageSize);
	if(bp.getBrandMap().size() == 0 && offset != 0) {
		offset -=pageSize;
		bp = subTypeDao.getAllBrands(offset, pageSize);
	}
	if(offset%pageSize == 0 || offset/pageSize >0) {
		pagecurrentPageNo = offset/pageSize + 1;
	}
	bp.setPageOffset(offset);
	bp.setPagecurrentPageNo(pagecurrentPageNo);
	request.getSession().setAttribute("brandPager", bp);
	request.getSession().setAttribute("brandList", bp.getBrandMap().values());
	request.getRequestDispatcher("../pages/addBrand.jsp").forward(request, response);
%>

