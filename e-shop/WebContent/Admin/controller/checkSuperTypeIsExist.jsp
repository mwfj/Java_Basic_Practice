<%@ page contentType="text/plain; charset=UTF-8" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map,org.codehaus.jackson.map.ObjectMapper,
com.Admin.dao.SuperTypeDao,com.Admin.daoimpl.SuperTypeDaoImpl" %>
<%
	String path = request.getContextPath();
	//response.setContentType("text/xml;charset=gbk");
	response.setHeader("Cache-Control", "no-cache");
	request.setCharacterEncoding("gbk");
	Map mapParam=new HashMap();
	String superTypeName = new String(request.getParameter("superTypeName").getBytes("iso-8859-1"), "gbk");
	byte[] buf = superTypeName.getBytes("gbk");
	SuperTypeDao superTypeDao = new SuperTypeDaoImpl();
	if(superTypeDao.checkSuperTypeIsExist(new String(buf))) {
		mapParam.put("STATE","true");
		mapParam.put("CONTENT", "该名称已存在");
	    ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mapParam); 
		out.print(json);
	} else {
		mapParam.put("STATE","false");
		mapParam.put("CONTENT", "该名称不存在");
	    ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mapParam); 
		out.print(json);
	}
%>

