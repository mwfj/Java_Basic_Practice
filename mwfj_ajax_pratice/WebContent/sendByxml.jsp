<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 传送 HTML</title>
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
							//1. 结果为XML格式，则xu要使用responseXML 来获取
							//2. XML结果不能直接使用，必须先创建对应的节点，再讲节点加入#detailsxml div中来解析
							/**
								<h2>Liergou</h2>
								<h1>
									<a href = "www.baidu.com">www.Liergou.com</a>
								</h1>
							**/
							var result = request.responseXML;
							var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
							var website = result.getElementsByTagName("website")[0].firstChild.nodeValue;
							var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;

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

							var detailxml = document.getElementById("xmldetails");

							detailxml.innerHTML = "";
							detailxml.appendChild(h2Node);
							detailxml.appendChild(h3Node);
						}
					}
				}
				return false;
			}
		}
	}
// Ajax传输xml的优点: 1. XML是通用的数据格式
//										2. 利用DOM可以完全掌控，且不必把数据强加到一定定义好的格式中，而是自定义数据标记
//										3.DOM可以完全掌控
//								缺点: 1.DOM 解析复杂
//										2. 必须确保文档含有正确的首部信息，否则responseXML将会为空 
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li><a href  = "xml/Liergou.xml">Liergou</a></li>
		<li><a href = "xml/Niusaodou.xml">Niusaodou</a></li>
		<li><a href="xml/Saobidun.xml"> Saobidun</a></li>
	</ul>
	<div id = "xmldetails"></div>
	
</body>
</html>