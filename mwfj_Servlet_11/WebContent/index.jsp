<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX Index</title>

<%--jquery 库 --%>
<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript">
	// 闭包写法
	// onload 事件完毕
	$(document).ready(function(){
		/* $("#btnCheckedRegisterName").on("click", function(){
			alert("++");
		});	 */
		
		// 点击事件
		$("#btnCheckedRegisterName").click(function(){
			// 注册名
			// ajax
			// 响应
			var _registerName = $("#txtRegisterName").val();
			// alert(_registerName);
			
			/*
				jquey 
				1 ajax() [最全的一个]
				2 $.get()
				3 $.post()
				4 $.load()
			*/
			
			document.getElementById("imgLoading").style.display = "block";
			
			// jquery ajax post 
			$.post(
					"${pageContext.request.contextPath}/chekedRegisterName.action",
					{
						"RegisterName" : _registerName
					},
					function(data, status) {
						//alert(data);
						//alert(status)
						if(status == "success") {
							/* if(data) {
								alert("该注册名：" + _registerName + "已经被注册过");
							} else {
								alert("注册名可用");
							} */
							
							//alert(data);
							//alert(data.id + "|" + data.name + "|" + data.age);
							//$("#divResult").html(data.id + "|" + data.name + "|" + data.age);
							
							var _content = "";
							for(var i = 0; i < data.length; i++) {
								var obj = data[i];
								_content += obj.name + "|" + obj.id + "|" + obj.age
								_content += "<br>";
							}
							$("#divResult").html(_content);
						}
						
						document.getElementById("imgLoading").style.display = "none";
					}
			);
			
		});	
	});






	function loadXMLDoc() {
		// 创建XMLHttpRequest对象，由它发起和服务器的请求
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
		/* var _name = "tom";
		var _age = 99; */
		
		var _name = document.getElementById("txtName").value;
		var _age = document.getElementById("txtAge").value;
		
		if(_name == "" || _age == "") {
			alert("名字和年龄不能为空");
			return;
		}
		
		
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4) {
				if(xmlhttp.status == 200) {
					// 服务器响应值
					var responseValue = xmlhttp.responseText;
					// 响应值放在div之间
					document.getElementById("myDiv").innerHTML=responseValue;
				} else if(xmlhttp.status == 404) {
					alert("未找到请求资源");
				} else if(xmlhttp.status == 500) {
					alert("服务器内部错误");
				} else {
					alert("操作失败，请联系服务器管理员");
				}
			}
			
			// readyState = 4 是发送成功状态
			// status = 200 这个是响应状态码
			/* if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{
					// 服务器响应值
					var responseValue = xmlhttp.responseText;
					// 响应值放在div之间
					document.getElementById("myDiv").innerHTML=responseValue;

				} */
		};
		/* xmlhttp.open(
				"GET",
				"${pageContext.request.contextPath}/load.action?name=" + _name, true);
		
		xmlhttp.send(); */
		
		xmlhttp.open(
				"POST",
				"${pageContext.request.contextPath}/load.action", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("name=" + _name + "&age=" + _age);
		
	}
</script>
</head>
<body>

	

	<div id="myDiv"><h3>Let AJAX change this text</h3></div>
	
	<div>
		 你的名字: <input type="text" id="txtName">;
		 <br>
		你的年龄: <input type="text" id="txtAge">;
	</div>
	
	<button type="button" onclick="loadXMLDoc()">Change Content</button>
	
	<hr>
	
	<fieldset>
		<legend>注册表单</legend>
		注册名 <input type="text" id="txtRegisterName"> 
		<button id="btnCheckedRegisterName">检查注册名是否被注册</button> 
		<img 
			id="imgLoading"
			src="${pageContext.request.contextPath}/image/loading.gif" style="display: none;">
	</fieldset>
	
	
	<div id="divResult">
	</div>
	
	

</body>
</html>