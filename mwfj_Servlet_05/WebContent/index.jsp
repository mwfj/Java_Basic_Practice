<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>

<c:if test="${requestScope.products == null}">
	<%--请求转发 --%>
	<jsp:forward page="preparedIndex.action"></jsp:forward>
</c:if>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/new.jsp";
	}
	
	function modifyProduct() {
		var chkProducts = document.getElementsByName("product");
		if(chkProducts != null) { 
			var flag = false;
			var count = 0;
			var selectId = 0;
			for(var i = 0; i < chkProducts.length; i++) {
				if(chkProducts[i].checked){
					flag = true;
					count++;
					selectId = chkProducts[i].value;
					continue;
				}
			}
			if(!flag) {
				alert("你至少要选中一项，才能修改操作");
				return;
			}
			if(count > 1) {
				alert("你只能选中一项进行修改操作");
				return;
			}
			window.location.href = "${pageContext.request.contextPath}/modify.jsp?productId=" + selectId;
		}
	}
	
	function removeProduct() {
		var chkProducts = document.getElementsByName("product");
		if(chkProducts != null) {
			var flag = false;
			var ids = "";
			for(var i = 0; i < chkProducts.length; i++) {
				if(chkProducts[i].checked){
					flag = true;
					ids += (chkProducts[i].value + ",");
					continue;
				}
			}
			
			// 1,2,3,  --> subString(0,)
			ids = ids.substring(0, ids.lastIndexOf(",", ids.length));
			alert(ids);
			
			//var l = ids.lastIndexOf(",", ids.length);
			//alert(l);
			
			if(!flag) {
				alert("你至少要选中一项，才能删除操作");
			} else {
				//alert(ids);
				window.location.href = "${pageContext.request.contextPath}/product.action?type=del&ids="+ids;
			}
		}
	}
</script>

</head>
<body>
	<center>
		<h4>${requestScope.a.b.name}</h4>
		<h3>商品信息</h3>
		<hr>
		<form action="${pageContext.request.contextPath}/cart.action"
		method="post">

			<table>
				<tr>
					<th></th>
					<th>商品ID</th>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>库存数量</th>
					<th></th>
				</tr>
				<c:forEach items="${requestScope.products}" var="product">
					<tr>
						<td><input type="checkbox" value="${product.id}"
							name="product"></td>
						<td>${product.id}</td>
						<td>${product.proNumber}</td>
						<td>${product.proName}</td>
						<td>${product.proStock}</td>
						<td>
						
							
							<a href="${pageContext.request.contextPath}/info.jsp?productId=${product.id}"
								target="_blank">查看详情</a>
								
								<a href="http://www.163.com">网易</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			<input type="submit" value="购买商品" name="add"> &nbsp; <input type="submit" value="删除商品" name="sub">
			<hr>
			<input type="button" value="增加商品" onclick="addProduct()">
			 &nbsp;
			 <input type="button" value="修改商品" onclick="modifyProduct()">
			 &nbsp;
			 <input type="button" value="删除商品" onclick="removeProduct()">
			 &nbsp;
		</form>


	</center>
</body>
</html>