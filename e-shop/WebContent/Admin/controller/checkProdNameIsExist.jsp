<%@page import="com.Admin.daoimpl.AdminProdDaoImpl"%>
<%@page import="com.Admin.dao.AdminProdDao"%>
<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map,org.codehaus.jackson.map.ObjectMapper,
com.Admin.dao.SubTypeDao,com.Admin.daoimpl.SubTypeDaoImpl" %>
<%
	String path = request.getContextPath();
	//response.setContentType("text/xml;charset=gbk");
	response.setHeader("Cache-Control", "no-cache");
	request.setCharacterEncoding("gbk");
	Map mapParam=new HashMap();
	String prodName = new String(request.getParameter("prodName").getBytes("iso-8859-1"), "gbk");
	AdminProdDao adminProdDao = new AdminProdDaoImpl();
	if(adminProdDao.checkProdNameIsExist(prodName)) {
		mapParam.put("STATE","true");
		mapParam.put("CONTENT", "商品名已存在");
	    ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mapParam); 
		out.print(json);
	} else {
		mapParam.put("STATE","false");
		mapParam.put("CONTENT", "商品名不存在");
	    ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mapParam); 
		out.print(json);
	}
%>

