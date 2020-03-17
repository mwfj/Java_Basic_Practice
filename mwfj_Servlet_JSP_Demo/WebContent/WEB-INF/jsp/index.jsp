<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 判断用户是否登录才能访问index.html页面 --%>
<c:if test="${sessionScope.Student == null}">
	<c:redirect url="login.html"></c:redirect>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<center>
		<h3>${sessionScope.Student.nickName},欢迎来到民族学院首页</h3>
		<table width="80%">
			<tr>
				<th>ID</th>
				<th>昵称</th>
				<th>年龄</th>
			</tr>
			<c:forEach var="student" items="${requestScope.Students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.nickName}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
		<a href="${pageContext.request.contextPath}/index.html?pageNo=1">第一页</a> 
		&nbsp; 
		<a href="${pageContext.request.contextPath}/index.html?pageNo=2">第二页</a>
	</center>




</body>
</html>