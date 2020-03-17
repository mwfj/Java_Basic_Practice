<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 传送 HTML</title>
<script type="text/javascript">
	//Ajax传递HTML
	//服务器通过HTML传递数据文本储存在responseText属性中。插入HTML最好的办法就是更新元素的innerHTML属性
	window.onload = function () {
		var aNodes = document.getElementsByTagName("a");
		for (var i = 0; i < aNodes.length; i++) {
			aNodes[i].onclick = function () {
				 var request = new XMLHttpRequest();
				 var method = "GET";
				 var url = this.href;

				 request.open(method, url);
				 request.send(null);
				 request.onreadystatechange = function () {
					if (request.readyState == 4) {
						if (request.status ==200 || request == 304) {
							document.getElementById("details").innerHTML = request.responseText; 
						}
					}
				}
				return false;
			}
		}
	}
	// 优点：1. 从服务器端发送HTML代码在浏览器不需要用javascript解析 2. HTML可读性好且与innerHTML属性搭配效率高
	// 缺点: 1.若需要通过aJax更新一篇文档的多个部分，HTML不合适； 2. innerHTML并非DOM标准
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li><a href  = "Liergou.html">Liergou</a></li>
		<li><a href = "Niusaodou.html">Niusaodou</a></li>
		<li><a href="Saobidun.html"> Saobidun</a></li>
	</ul>
	<div id = "details"></div>
</body>
</html>