<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<center>
	
		<a href="http://www.163.com">网易</a>

		<%--
			login.action
			/login.action
			${pageContext.request.contextPath}/login.action
			/Rico_Servlet_01/login.action
		 --%>
		 
		 <%
		 	String path = request.getContextPath();
		 %>
		 
		 <%--
		 	客户端向服务器发送请求的方式：get post
		 	1 携带数据的方式不同
		 	2 Servlet取值getParameter（参数名）
		 	3 get请求有可能出现乱码问题
		 	4 get你的参数值会暴露在URL地址栏中 不安全
		 	5 实际应用中get比post多
		 	
		 	get：超链接 、地址栏复制一个地址、css image js引用
		 	
		 	<users>
			 	<user>
			 		<loginName>tom</loginName>
			 		<loginPassword>123456</loginPassword>
			 	</user>
			 	<user>
			 		<loginName>tom</loginName>
			 		<loginPassword>123456</loginPassword>
			 	</user>
		 	</users>
		 	
		 	
		 	
		 	[
		 		school: "成都学院",
			 	{
			 		loginName: tom,
			 		loginPassword: 123456,
			 		interesting:[
			 			{
			 				cName: 音乐,
			 				eName: Music
			 			}
			 		]
			 	
			 	},
			 	{
			 		loginName: jack,
			 		loginPassword: 123456
			 	
			 	}
			 	
		 	]
		 	
		 	www.apple.com.cn
		 	
		  --%>
		<form action="${pageContext.request.contextPath}/iphone/login.action" method="post">
			<table>
				<tr>
					<td>登录名</td>
					<td><input type="text" name="loginName" id="loginName">
					</td>
				</tr>
				<tr>
					<td>登录密码</td>
					<td><input type="password" name="loginPassword"
						id="loginPassword"></td>
				</tr>
				<tr>
				
					<!-- <td>
						<button>登录</button>
						<input type="button" value="登录">
					</td> -->
				
				
					<td><input type="submit" value="登录"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
				<tr>
					<td colspan="2" style="color: red">
						${requestScope.ErrorMsg}
						
						
							<%-- ${param.参数名}
							URL?参数名=参数值&参数名=参数值...
							JSP 上取得URL参数 --%>
						
						<%-- <c:if test="${param.errorCode == 1}">
							登录名或登录密码错误
						</c:if> --%>
					</td>
				</tr>
			</table>
		</form>


	</center>

</body>
</html>