<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="rico.demo.servlet.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>

<% int a = 10; %>

	<%--
		${LoginName}
		page
		request
		session
		application
	 --%>
	<%-- <h3>${requestScope.LoginName}, Welcome to my web</h3> --%>
	
	<%
		Object obj = request.getAttribute("User");
		if(obj != null) {
			User user = (User)obj;
			String loginName = user.getLoginName();
		}
		
		
	%>
	
	<h3>${requestScope.User.loginName}, Welcome to my web</h3>
	
	
	
	<button onclick="alert('Hello')">Click Me</button>
</body>
</html>