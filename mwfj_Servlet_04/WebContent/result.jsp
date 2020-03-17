<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%--只能静态包含，动态包含就错，因为动态包含只能会被包含的页面，不能指挥整个页面的跳转 --%>
<%@ include file="isLogined.jsp" %> 




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品</title>
</head>
<body>
	<center>
		<a href="index.jsp">回去再买</a>
		<table>
		
		
			<tr>
				<th>
					商品名称
				</th>
				<th>
					商品数量
				</th>
			</tr>
			<c:forEach var="p" items="${sessionScope.Cart}">
				<tr>
					<td>
						<%-- <c:if test="${p.key == 'apple' }">
							苹果
						</c:if> --%>
						${p.key}
						
					</td>
					<td>
						${p.value}
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>