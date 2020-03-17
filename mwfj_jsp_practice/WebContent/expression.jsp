<%@page import="java_bean.Test_javabean"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is the expression page]</title>
</head>
<body>
<h2>
		Current time:<%=new Date() %><br/>
		Random number: <%= Math.random() %><br/>
		String :<%= "Hello, this is the expression page" %><br/>
		1+1 = <%= 1+1 %><br/>
		Remote host = <%= request.getRemoteHost() %><br>
		-------------------------------------------------------------------<br>
		获取Test_javabean的各种属性<br>
		<jsp:useBean id="test_javabean" class = "java_bean.Test_javabean" scope = "session">
				<jsp:setProperty property="name" name="test_javabean" value="mwfj"/>
				<jsp:setProperty property="age" name="test_javabean" value = "23"/>
				<jsp:setProperty property="male" name="test_javabean" value = "true"/>
		</jsp:useBean>
				姓名：<jsp:getProperty property="name" name="test_javabean"/><br>
				年龄：<jsp:getProperty property="age" name="test_javabean"/><br>
				是男生吗?：<jsp:getProperty property="male" name="test_javabean"/>(不推荐用javabean的getProperty方法获取布尔值)<br>
				


	
</h2>
</body>
</html>