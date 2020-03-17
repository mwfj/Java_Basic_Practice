<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
</head>
<body>
	<center>
		<form action="${path}/login.action" method="post">
			登录名：<input type="text" name="loginName">
			<br>
			<br>
			<button>登录</button>
		</form>
		<br>
		<c:if test="${param.errorCode == 5 }">
			<span style="color: red">该账号已经被冻结，请联系管理员。</span>
		</c:if>
	</center>
</body>
</html>