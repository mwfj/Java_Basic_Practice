<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/included/path_lib.jsp"%>
<%@include file="/included/tag_lib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script type="text/javascript">
	function modifyProduct() {
		var chks = document.getElementsByName("chkItem");
		var flag = false;
		var count = 0;
		var id = 0;
		for(var i = 0; i < chks.length; i++) {
			if(chks[i].checked) {
				flag = true;
				count++;
				id = chks[i].value;
			}
		}
		
		if(!flag) {
			alert("你至少要选中一项");
			return;
		}
		
		if(count != 1) {
			alert("你只能选中一项进行修改");
			return;
		}
		
		//alert("id :" + id);
		
		
		window.location.href = "${path}/student/modify_product.html?id=" + id;
	}
	
	function removeProduct(){
		var chks = document.getElementsByName("chkItem");
		var flag = false;
		var ids = "";
		for(var i = 0; i < chks.length; i++) {
			if(chks[i].checked) {
				flag = true;
				ids += chks[i].value + ",";
			}
		}
		
		if(!flag) {
			alert("你至少要选中一项");
			return;
		}
		
		ids = ids.substring(0, ids.length - 1);
		//alert(ids);
		

		if (window.confirm("你确定要删除选中项吗？")) {
			window.location.href = "${path}/student/do_remove_product.html?ids="
				+ ids;
		}
		
	}
</script>
</head>
<body>

	<div style="text-align: center;">
		<h3>主页</h3>
		<table style="margin: auto;width: 50%">
			<tr>
				<th>
				</th>
				<th>
					商品编号
				</th>
				<th>
					商品名称
				</th>
				<th>
					
				</th>
			</tr>
			<c:forEach items="${requestScope.Products}" var="p">
				<tr>
					<td>
						<input type="checkbox" name="chkItem" value="${p.id}"
						 >
					</td>
					<td>
						${p.number }
					</td>
					<td>
						${p.name }
					</td>
					<td>
						<a href="${path}/student/product_detail.html?id=${p.id}">详情</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<hr>
		
		<a href="${path}/student/new_product.html">新增商品</a>
		&nbsp;&nbsp;
		<a href="#" onclick="modifyProduct()">修改商品（修改选中的一项）</a>
		&nbsp;&nbsp;
		<a href="#" onclick="removeProduct()">删除商品（删除选中的）</a>
	</div>
	

</body>
</html>