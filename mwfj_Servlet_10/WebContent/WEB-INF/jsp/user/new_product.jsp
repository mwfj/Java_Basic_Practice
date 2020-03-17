<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/included/path_lib.jsp"%>
<%@include file="/included/tag_lib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
</head>
<body>

	<center>
		<form action="${path}/student/do_new_product.html"
			method="post">
			<table>
				<tr>
					<td>
						商品ID
					</td>
					<td>
						<input type="text" name="productId">
					</td>
				</tr>
				<tr>
					<td>
						商品编号
					</td>
					<td>
						<input type="text" name="productNumber">
					</td>
				</tr>
				<tr>
					<td>
						商品名称
					</td>
					<td>
						<input type="text" name="productName">
					</td>
				</tr>
				<tr>
					<td>
						商品描述
					</td>
					<td>
						<textarea rows="10" cols="30" name="productDes"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<button>新增商品</button>
					</td>
					<td>
						<input type="reset" value="重置表单">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>