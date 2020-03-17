<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h3>${sessionScope.LoginName}, 欢迎来到我的主页</h3>
	<h5>站点访问总数：${applicationScope.AccessWebCount}</h5>
	<h5>当前在线人数：${applicationScope.OnlineWebCount}</h5>
	<h3>
		<a href="${pageContext.request.contextPath}/logout.action">安全退出</a>
	</h3>
</body>
</html>