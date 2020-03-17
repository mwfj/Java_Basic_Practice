<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 判断用户是否登陆过 -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:if test="${sessionScope.User==null}">
	<jsp:forward page="/login.jsp"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the main page</title>
</head>
<body>
	<h2 style="text-align: center;">Welcome, Mr. ${sessionScope.User.name};</h2>
	
</body>
</html>