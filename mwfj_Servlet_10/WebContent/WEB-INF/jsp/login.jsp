<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/included/path_lib.jsp"%>
<%@include file="/included/tag_lib.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>登录 Login</h3>

	<form action="${path}/do_login.html" method="post">
		登录名：<input type="text" name="loginName">
		<br>
		<select name="studentType">
			<c:forEach items="${requestScope.Types}" var="t">
				<option value="${t.id}">${t.name}</option>
			</c:forEach>
		</select>
		<br>
		<button>登录</button>
	</form>


</body>
</html>