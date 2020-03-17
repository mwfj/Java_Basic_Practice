<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<table>
				<tr>
					<td>
						登录名
					</td>
					<td>
						<input type="text" name="loginName">
					</td>
				</tr>
				<tr>
					<td>
						登录密码
					</td>
					<td>
						<input type="password" name="loginPassword">
					</td>
				</tr>
				<tr>
					<td>
						记住我的登录状态
					</td>
					<td>
						<input type="checkbox" name="autoLogin" value="autoLogin">
					</td>
				</tr>
				<tr>
					<td>
						<button>登录</button>
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="color: red">
						${param.errorCode}
					</td>
					
				</tr>
			</table>
		</form>
	</center>
</body>
</html>