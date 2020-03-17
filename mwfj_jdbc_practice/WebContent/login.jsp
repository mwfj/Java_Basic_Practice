<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript">
	function checkform(path) {
		var js_form = document.getElementById("login_form");
		var login_name = document.getElementById("login_name");
		var login_password = document.getElementById("login_pwd");
		if (login_name.value=="mwfj" &&login_password.value=="mwfj") {
			document.getElementById("successMsg").innerHTML="登陆成功";
			js_form.action = path+"/login.action";
			js_form.method = "post";
			js_form.submit();
		}else {
			document.getElementById("errMsg").innerHTML= "用户名/密码不都是'mwfj',不能登录";
		}
	}
</script>
</head>
<body>
		<center>
				<h1><b>欢迎来到登陆界面</b></h1>
				<form id= "login_form" name="login_form">
				<table>
						<tr>
							<td style="text-align: left;">用户名: </td>
							<td><input type="text" name="login_name" id="login_name"></td>
						</tr>
						<tr>
							<td style="text-align: left;">密码: </td>
							<td><input type="password" name="login_pwd" name="login_pwd"></td>
						</tr>
						<tr>
							<td><input type="button" name="login_submit" id="login_submit" value="登陆" onclick="checkform('${pageContext.request.contextPath}')"></td>
							<td><input type="reset" name="login_reset" id="login_reset" value="重置"></td>
						</tr>
					</table>
				</form>
				<h2 id="errMsg" style="color: red;"></h2>
				<h2 id="successMsg"></h2>
		</center>
</body>
</html>