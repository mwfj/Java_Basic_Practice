<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

<c:if test="${requestScope.product == null}">
	<jsp:forward page="preparedInfo.action"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
</head>
<body>
	<center>
		<h3>商品详情</h3>
		<table>
			<tr>
				<td>
					商品ID
				</td>
				<td>
					${requestScope.product.id}
				</td>
			</tr>
			<tr>
				<td>
					商品编号
				</td>
				<td>
					${requestScope.product.proNumber}
				</td>
			</tr>
			<tr>
				<td>
					商品名称
				</td>
				<td>
					${requestScope.product.proName}
				</td>
			</tr>
			<tr>
				<td>
					库存数量
				</td>
				<td>
					${requestScope.product.proStock}
				</td>
			</tr>
		</table>
	</center>
</body>
</html>