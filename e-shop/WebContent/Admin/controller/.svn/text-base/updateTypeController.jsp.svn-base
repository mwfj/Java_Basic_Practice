<%@page import="com.Admin.vo.Attr"%>
<%@page import="com.Admin.daoimpl.SubTypeDaoImpl"%>
<%@page import="com.Admin.dao.SubTypeDao"%>
<%@page import="com.Admin.daoimpl.SuperTypeDaoImpl"%>
<%@page import="com.Admin.dao.SuperTypeDao"%>
<%@page import="com.Admin.vo.SuperTypePager"%>
<%@ page contentType="text/plain; charset=GBK" language="java" import="java.util.*"%>
<%@ page import="java.util.HashMap,java.util.Map" %>
<%
	String path=request.getContextPath();
	String id_str=request.getParameter("id");
	int Id=0;
	if(id_str!=null){
		Id=Integer.parseInt(id_str);
	}
	String name=new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
	String type=request.getParameter("type");
	boolean result=false;
	SuperTypeDao superTypeDao=new SuperTypeDaoImpl();
	SubTypeDao subTypeDao=new SubTypeDaoImpl();
	if(type.equals("super")){
		if(superTypeDao.updateTypeName(Id,name)){
			result=true;
		}
	}else if(type.equals("sub")){
		if(subTypeDao.updateTypeName(Id,name)){
			result=true;
		}
	}else if(type.equals("brand")){
		if(subTypeDao.updateBrandName(Id,name)){
			result=true;
		}
	}else if(type.equals("attr")){
		String attrType_str=request.getParameter("attrType");
		int attrType=0;
		if(attrType_str!=null){
			attrType=Integer.parseInt(attrType_str);
		}
		String attrValue=new String(request.getParameter("attrValue").getBytes("iso-8859-1"), "utf-8");
		Attr attr=new Attr();
		attr.setAttrid(Id);
		attr.setAttrname(name);
		attr.setAttrtype(attrType);
		attr.setAttrvalue(attrValue);
		if(subTypeDao.updateAttribute(attr)){
			result=true;
		}
	}
	
%>

