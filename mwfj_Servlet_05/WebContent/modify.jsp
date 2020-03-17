<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

<c:if test="${requestScope.product == null}">
	<jsp:forward page="preparedModify.action"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body>
	<center>
		<h3>商品详情</h3>
		
		<form action="${pageContext.request.contextPath}/product.action?type=update&id=${requestScope.product.id}"
			method="post">
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
					<input type="text" value="${requestScope.product.proNumber}" name="productNumber">
				</td>
			</tr>
			<tr>
				<td>
					商品名称
				</td>
				<td>
					<input type="text" value="${requestScope.product.proName}" name="productName">
				</td>
			</tr>
			<tr>
				<td>
					库存数量
				</td>
				<td>
					<input type="text" value="${requestScope.product.proStock}" name="productStock">
				</td>
			</tr>
			<tr>
				<td>
					<button>修改</button>
				</td>
			</tr>
		</table>
		
		</form>
		
	</center>
</body>
</html>