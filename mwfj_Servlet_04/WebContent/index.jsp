<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%--
	<c:redirect url="login.jsp"></c:redirect>
	JSP中的重定向写法
	------------------------------
	<jsp:forward page="/login.jsp"></jsp:forward>
	JSP中的请求转发，服务器内部跳转
 --%>
<c:if test="${sessionScope.User == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>  
    
    
    
<%--
  安全退出：
 1 主动的清除上次会话
 2 页面重定向login
 -------
 3 cookie清掉
 
	
 --%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">
	function logout(){
		if(window.confirm("你是否要安全退出？")){
			window.location.href = "${pageContext.request.contextPath}/logout.action";
		}
	}
</script>
</head>
<body>
	<center>
		<h3>Hello, ${sessionScope.User.loginName}, Welcome to my web.</h3>
		<br>
		<h3>Hello, ${requestScope.User.loginName}, Welcome to my web.</h3>
		<div>
			<!-- <a href="#" onclick="logout()">安全退出</a> -->
			
			<img alt=""
				title="安全退出"
				style="cursor: pointer;"
				onclick="logout()"
			 src="${pageContext.request.contextPath}/imges/exit.png">
			
		</div>
		<br>
		<a href="${pageContext.request.contextPath}/settings.jsp">我的设置</a>
		
		<hr>
		
		<form action="${pageContext.request.contextPath}/cart.action" method="post">
		
			<input type="checkbox" value="apple" name="fruit">苹果
			<br>
			<input type="checkbox" value="berry" name="fruit">草莓
			<br>
			<input type="checkbox" value="banana" name="fruit">香蕉
			<br>
			<input type="checkbox" value="orange" name="fruit">橙子
			<br>
			<input type="submit" value="添加购物车" name="add">
			
			<input type="submit" value="移除购物车" name="sub">
			
		</form>
		
		
	</center>
</body>
</html>