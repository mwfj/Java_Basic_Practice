<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 传送 Json</title>
<script type="text/javascript">

	window.onload = function () {
		var aNodes = document.getElementsByTagName("a");
		for (var i = 0; i < aNodes.length; i++) {
			aNodes[i].onclick = function () {
				 var request = new XMLHttpRequest();
				 var method = "GET";
				 var url = this.href;
					//alert(url);
				 request.open(method, url);
				 request.send(null);
				 request.onreadystatechange = function () {
					if (request.readyState == 4) {
						if (request.status ==200 || request == 304) {
							/**
								<h2>Liergou</h2>
								<h1>
									<a href = "www.baidu.com">www.Liergou.com</a>
								</h1>
							**/
							var result = request.responseText;
							var jsonObject = eval("("+result+")");
							var name = jsonObject.person.name;
							var website = jsonObject.person.website;
							var email = jsonObject.person.email;

							//创建a标签
							var aNode = document.createElement("a");
							//将文本name放入a标签中
							aNode.appendChild(document.createTextNode(name));
							//给a标签赋值链接
							aNode.href = email;
							
							var h2Node  = document.createElement("h2");
							h2Node.appendChild(aNode);
							
							var aNode2 = document.createElement("a");
							aNode2.appendChild(document.createTextNode(website));
							aNode2.href = website;
							
							var h3Node  = document.createElement("h3");
							h3Node.appendChild(aNode2);

							var jsondetail = document.getElementById("jsonldetails");

							jsondetail.innerHTML = "";
							jsondetail.appendChild(h2Node);
							jsondetail.appendChild(h3Node);
						}
					}
				}
				return false;
			}
		}
	}
/**
 * Json的优点:
	 					1.相比XML，json更加灵巧
 						2. JSON不需要从服务器端发送含有特定内容类型的首部信息
 				缺点:
 	 					1. 语法过于严谨
 	 					2.代码不易读
 	 					3.eval()存在风险
 */
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li><a href  = "json/liergou.json">Liergou</a></li>
		<li><a href = "json/niusaodou.json">Niusaodou</a></li>
		<li><a href="json/saobidun.json"> Saobidun</a></li>
	</ul>
	<div id = "jsonldetails"></div>
	
</body>
</html>