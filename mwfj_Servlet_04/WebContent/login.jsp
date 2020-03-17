<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript">
	function doLogin(path) {
		var loginForm = document.getElementById("formLogin");
		//loginForm.action = "${pageCotext.request.contextPath}/login.action";

		var ricoPath = document.getElementById("hidPath").value;
		alert(ricoPath);

		loginForm.action = path + "/login.action";
		loginForm.method = "post";
		loginForm.submit();

	}
</script>
</head>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("ricoPath", path);
%>
<body>
	<center>
		<form id="formLogin">
			<table>


				<tr>
					<td>${ricoPath} 登录名</td>
					<td><input type="text" name="loginName" id="loginName">
					</td>
				</tr>
				<tr>
					<td><input type="hidden"
						value="${pageContext.request.contextPath}" id="hidPath">
						登录密码</td>
					<td><input type="password" name="loginPassword"
						id="loginPassword"></td>
				</tr>
				<tr>
					<%--
				
					onClick('/Rico_Servlet_04');
				 --%>
					<td><input type="button" value="登录"
						onclick='doLogin("${pageContext.request.contextPath}")'> 
						<a href="#" onclick="doLogin('${pageContext.request.contextPath}')">登录</a>

					</td>
					<td><input type="button" value="重置"></td>
				</tr>
			</table>
		</form>
		<h1>
			会话ID：<%=session.getId()%>
			| ${pageContext.session.id}
		</h1>

	</center>
</body>
</html>