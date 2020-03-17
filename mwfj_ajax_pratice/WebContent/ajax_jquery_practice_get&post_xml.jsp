<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax_jQuery_GET or POST</title>
<script type="text/javascript" src = "scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">
/**
 * $.get()/$.post() 使用来进行异步请求，它的结构式$.get(url[,data][,callback][,type]);
 其中url String类型是q请求HTML页面的URL地址
 date(optional): object 类型以键值对的方式发送到服务器最为QueryString附加到URL后面
 callback 函数: 载入成功是回调函数会自动将结果和状态传递给该方法
 其中回调函数只有两个参数分别是date返回内容，可以JSON，XML，HTML等；
 															另外一个是 textstaus代表请求状态：success, error, notmodify, timeout 4种
 type String类型: 可以是XML，HTML，Script, Json, Text , _default

 	get和post两个方法在jQuery中是全局函数，而find()等方法都是对jQuery对象进行操作的
 */
	$(function(){
		$("a").click(function(){
			var url  = this .href;
			//必须要用JSON格式
			var dates = {"time": new Date()};

			$.get(url, dates, function(data){
				//当响应结束时，回调函数被触发。而响应结果在data中
					var name = $(data).find("name").text();
					var email = $(data).find("email").text();
					var website = $(data).find("website").text();
					//alert(name);
					//alert(website);
					//alert(email);
					$("#details").empty()
										.append("<h2><a href = ' "+email+" '>"+name+"</a></h2>")
										.append("<h1><a href = ' "+website+" '>"+website+"</a></h1>");
				});
			return false;
			});
		})
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li><a href  = "xml/Liergou.xml">Liergou</a></li>
		<li><a href = "xml/Niusaodou.xml">Niusaodou</a></li>
		<li><a href="xml/Saobidun.xml"> Saobidun</a></li>
	</ul>
	<br><br>
	<div id = "details"></div>
	
</body>
</html>