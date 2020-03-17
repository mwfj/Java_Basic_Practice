<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Web Login</h3>
	<h5>该站点被访问次数是：${applicationScope.AccessWebCount}</h5>
	<h5>当前在线人数：${applicationScope.OnlineWebCount}</h5>
	<center>
		<form action="${pageContext.request.contextPath}/login.action"
			method="post">
			登录名：<input type="text" name="loginName">
			<br>
			<button>登录</button>
		</form>
	</center>
</body>
</html>