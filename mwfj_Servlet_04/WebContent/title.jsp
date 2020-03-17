<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="width: 100%; height: 200px; background-color: gray;">
	<h3>
		request域里面的变量：${requestScope.User.loginName}
		<br>
		session域里面的变量：${sessionScope.User.loginName}
		<br>
		这是我的标题
	</h3>
</div>