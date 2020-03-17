<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.user == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<center>
		<h3>Hello, ${sessionScope.user.loginName}, welcome.</h3>
		
		<a href="${pageContext.request.contextPath}/logout.action">安全退出</a>
	</center>

</body>
</html>