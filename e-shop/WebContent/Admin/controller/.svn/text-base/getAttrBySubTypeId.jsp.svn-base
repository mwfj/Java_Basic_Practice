<%@page import="net.sf.json.JSONArray"%>
<%@page import="com.Admin.daoimpl.AdminProdDaoImpl"%>
<%@page import="com.Admin.daoimpl.AdminLoginDaoImpl"%>
<%@page import="com.Admin.dao.AdminProdDao"%>
<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map,org.codehaus.jackson.map.ObjectMapper,
com.Admin.vo.Attr" %>
<%
	String path = request.getContextPath();
	response.setHeader("Cache-Control", "no-cache");
	request.setCharacterEncoding("gbk");
	Map mapParam=new HashMap();
	String subtypeId = request.getParameter("subTypeId");
	int subtype=0;
	if(subtypeId!=null&&!"".equals(subtypeId)){
		subtype=Integer.parseInt(subtypeId);
	}
	AdminProdDao adminProdDao = new AdminProdDaoImpl();
	List attrList=adminProdDao.getAttrBySubType(subtype);
	List aList=new ArrayList();
	StringBuffer resultOptions = new StringBuffer();
	if(attrList.size()>0){
		for(int i=0;i<attrList.size();i++){
			Attr attr=(Attr)attrList.get(i);
			Map paramMap=new HashMap();
			paramMap.put("attrId",attr.getAttrid());
			paramMap.put("attrName",attr.getAttrname());
			paramMap.put("attrType",attr.getAttrtype());
			paramMap.put("attrValue",attr.getAttrvalue());
			aList.add(paramMap);
		}
	}
	JSONArray jsonArr = JSONArray.fromObject(aList);	
	out.print(jsonArr.toString());
%>

