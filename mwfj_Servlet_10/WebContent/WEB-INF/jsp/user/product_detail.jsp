<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/included/path_lib.jsp"%>
<%@include file="/included/tag_lib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
	<center>
		<table width="50%">
			<tr>
				<th>
					商品ID（一般不显示）
				</th>
				<th>
					商品编号
				</th>
				<th>
					商品名称
				</th>
				<th>
					商品描述
				</th>
			</tr>
			<tr>
				<td>
					${requestScope.Product.id}
				</td>
				<td>
					${requestScope.Product.number}
				</td>
				<td>
					${requestScope.Product.name}
				</td>
				<td>
					${requestScope.Product.des}
				</td>
			</tr>
		</table>
		<hr>
		<a href="${path}/student/index.html">返回</a>
	</center>
</body>
</html>