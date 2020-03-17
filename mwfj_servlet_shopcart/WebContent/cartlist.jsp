<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="isLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>This is the Cart Page</title>
			<script type="text/javascript" src="prePage.js"></script>
			<script type="text/javascript" src="logout.js"></script>
		</head>
		<body>
			<h1 style="text-align: center;">
				<b>Cart List</b>
			</h1>
			<!-- ${empty requestScope.isNull} -->
			<c:choose>
				<c:when test="${!empty sessionScope.isNull}">
					<c:forEach var="p" items="${sessionScope.Cart}">
						<table align="center">
							<tr>
								<td>
									<h2 style="text-align: left:;">电脑品牌： ${p.key}</h2>
								</td>
								<td>
									<h2 style="text-align: right:;">&nbsp;数量： ${p.value}</h2>
								</td>
							</tr>
						</table>
					</c:forEach>
				</c:when>
				<c:when test="${empty sessionScope.isNull}">
					<h2 style="color: red; text-align: center;">${requestScope.errMsg }</h2>
				</c:when>
			</c:choose>
			<table align="center">
				<tr>
					<td>
						<input type="button" name="pre_page" value="返回上一页" onclick="pre_page()"></td>
						<td>
							<input type="button" name="logout" value="安全退出" onclick="logout('${pageContext.request.contextPath}')"></td>
						</tr>
					</table>
				</body>
			</html>
