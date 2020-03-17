<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	function doLogin() {
		var loginName = document.getElementById("loginName").value;
		var loginPassword = document.getElementById("loginPassword").value;
		
		if(loginName == null || loginName.trim() == "") {
			alert("用户名不能为空。");
			return false;
		}
		
		if(loginPassword == null || loginPassword.trim() == "") {
			alert("密码不能为空。");
			return false;
		}
		
		return true;
		
	}
</script>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/doLogin.html" method="post" >
			<table>
				<tr>
					<td>
						登录名
					</td>
					<td>
						<input type="text" name="loginName" id="loginName">
					</td>
				</tr>
				<tr>
					<td>
						登录密码
					</td>
					<td>
						<input type="password" name="loginPassword" id="loginPassword">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="登录" onclick="return doLogin();">
						<!-- <button>登录</button>
						<input type="button" value="登录">  -->
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="color: red">
						<%-- ${requestScope.ErrorMsg} --%>
						
						<c:if test="${param.errorMsg == 1}">
							登录名或登录密码错误，请重新输入
						</c:if>
						<c:if test="${param.errorMsg == 2}">
							登录名或登录密码不能为空。
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>