<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<center>
		<div style="font-size: 16px; text-align: center;">Index Page</div>
		<form action="${pageContext.request.contextPath}/register"
			method="post">
			<fieldset>
				LoginName : <input type="text" name="loginName">
				<br>
				LoginName : <input type="password" name="loginPassword">
				<br>
				<button>Register</button>
			</fieldset>
		</form>
	</center>
</body>
</html>