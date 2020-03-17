<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript" src="checkform.js"></script>
</head>
<body>
	<h1 style="text-align: center;"> 欢迎来到登陆界面</h1>
	<center>
	<form id="login_form" name="login_form" >
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="login_name" id="login_name"></td>
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="login_password" id="login_pwd"></td>
			</tr><tr>
			<!-- button 按钮的另一种写法：
			 <button name="login_submit" onclick='Check("${pageContext.request.contextPath}")'>登陆</button><input type= "button"  name="login_submit" id="login_submit" onclick='Check("${pageContext.request.contextPath}")' value="登陆"> -->
				<td  style="text-align: center;">&nbsp;&nbsp;<input type= "button"  name="login_submit" id="login_submit" onclick='Check("${pageContext.request.contextPath}")' value="登陆"></td>
				<td  style="text-align: center;"><input type = "reset" name="login_reset" id="login_reset" value="重置" ></td>
			</tr>
		</table>
	</form>
	
	<h2 id="errmsg" style="color: red;"></h2>
	<h2 id =success></h2>
	</center>
</body>
</html>