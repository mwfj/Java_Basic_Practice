<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map,org.codehaus.jackson.map.ObjectMapper,
com.Admin.dao.SubTypeDao,com.Admin.daoimpl.SubTypeDaoImpl" %>
<%
	String path = request.getContextPath();
	//response.setContentType("text/xml;charset=gbk");
	response.setHeader("Cache-Control", "no-cache");
	request.setCharacterEncoding("gbk");
	Map mapParam=new HashMap();
	String subTypeName = new String(request.getParameter("subTypeName").getBytes("iso-8859-1"), "gbk");
	byte[] buf = subTypeName.getBytes("gbk");
	SubTypeDao subTypeDao = new SubTypeDaoImpl();
	if(subTypeDao.checkSubTypeIsExist(new String(buf))) {
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

