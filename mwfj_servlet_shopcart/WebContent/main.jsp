<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.User==null}">
	<jsp:forward page="/login.jsp"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="logout.js"></script>
<script type="text/javascript">
	function selectAll() {
		var select_computer = document.getElementById("cart_list");
		var checkboxes = select_computer.computer;
		for (var i = 0; i < checkboxes.length; i++) {
			var key = checkboxes[i];
			key.checked = !key.checked;
		}
	}
</script>
<title>Welcome to the Cart Shop</title>
</head>
<body>
	<h2 style="text-align: center;">
		Hello, ${sessionScope.User.login_name} welcome to the Cart Shop!<br>
		Please select the computer brand you want to buy.
	</h2>
	<!--创建带有多选框的表单-->
	<form id="cart_list" name="cart_list" style="text-align: center;"
		action="${pageContext.request.contextPath}/cart" method="post">
		<h3>
			<b>thinkpad x1: </b><input type="checkbox" name="computer"
				value="thinkpad x1"><br>
		</h3>
		<h3>
			<b>macbook pro: </b><input type="checkbox" name="computer"
				value="macbook pro"><br>
		</h3>
		<h3>
			<b>xps 14:</b><input type="checkbox" name="computer"
				value="dell xps 14"><br>
		</h3>
		<h3>
			<b>alienware: </b><input type="checkbox" name="computer"
				value="alienware"><br>
		</h3>
		<h3>
			<b>surfacebook: </b><input type="checkbox" name="computer"
				value="surfacebook"><br>
		</h3>
		<h3>
			<b>surface pro: </b><input type="checkbox" name="computer"
				value="surface pro"><br>
		</h3>
		<input type="submit" name="add_submit" id="add" value="添加"> <input
			type="submit" name="sub_submit" id="sub" value="移除">
	</form>
	<center>
		<input type="button" name="logout" value="安全退出"
			onclick="logout('${pageContext.request.contextPath}')"> <input
			type="button" name="logout" value="全选/不选" onclick="selectAll()">
	</center>
</body>
</html>