<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 通过jQuery的方式传送 Json(GET&POST)</title>
<script type="text/javascript" src = "scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(function(){
		$("a").click(function(){
			var url  = this .href;
			//必须要用JSON格式
			var dates = {"time": new Date()};
			//方法1: 在get方法内的type参数位中注明是JSON类型
			$.get(url, dates, function(data){
				//当响应结束时，回调函数被触发。而响应结果在data中
					var name = data.person.name;
					var email = data.person.email;
					var website =data.person.website;
					//alert(name);
					//alert(website);
					//alert(email);
					$("#jsonldetails").empty()
										.append("<h2><a href = ' "+email+" '>"+name+"</a></h2>")
										.append("<h1><a href = ' "+website+" '>"+website+"</a></h1>");
				}, "JSON");
			//方法二：直接调用getJSON方法
			/**
			$.getJSON(url, dates, function(data){
				//当响应结束时，回调函数被触发。而响应结果在data中
					var name = data.person.name;
					var email = data.person.email;
					var website =data.person.website;
					//alert(name);
					//alert(website);
					//alert(email);
					$("#jsonldetails").empty()
										.append("<h2><a href = ' "+email+" '>"+name+"</a></h2>")
										.append("<h1><a href = ' "+website+" '>"+website+"</a></h1>");
				});
				**/
			return false;
			});
		})
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