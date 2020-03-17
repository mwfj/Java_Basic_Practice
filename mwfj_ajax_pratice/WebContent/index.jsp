<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--
 		1. 不用刷新页面却可以和服务端进行通信的方式就AJAX，直线aJAX的主要方式是XMLHttpRequest对象
 		2. 使用XMLHttpRequest对象事项Ajax【了解】
 		3. Ajax传输数据的三种方式：
 					a. xml: 由于较笨重，解析困难，使用较少。但xml是通用的数据交换格式
 					b. HTML: 不需要解析，可以直接放到文档中，若仅更新一部分区域，可以考虑使用HTML进行传输
 						但是传输数据不是很方便且HTML需要拼装完成
 					c.JSON: 使用较多，小巧，有面向对象的特征且有很多第三方jar包可以讲Java对象和集合转换为JSON字符串
 		4. 使用jQuery完成ajax操作
 					a. load(): 可以用于HTML文档的元素节点，把结果直接加到对应的子元素。通常而言load()加载后的数据是一个html片段
 						eg: var $object = ...;
 							  url = ....;
 							  var args = {key:value};
 							  $object.load(url,args);
 					b. $.get()&$.post()$.getJSON(): 更加灵活，除了使用load方法的情况，大部分都是使用这三个方法
 						1). 基本使用：
 						url: Ajax 请求的目标参数
 						args: 传递的参数，必须是JSON类型
 						data: Ajax响应成功后的数据。可能是XML，HTML，JSON
 						eg:  $.get(url, args, function(){
 						
 						});
 						2).  请求JSON数据
 						$.get(url, args, function(){
 						
 						}, "JSON");
 						$.getJSON(url, args, function(){
 						
 						});
 						$.post(url, args, function(){
 						
 						}, "JSON");
 						
  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Ajax</title>
	<script type="text/javascript">
		window.onload = function(){
				// 1. 获取a标签，并为其添加onclick事件
				document.getElementsByTagName("a")[0].onclick = function(){
					//3. 创建一个HMLHttpRequest对象
					var request = new XMLHttpRequest();
					//4. 准备发送请求的数据： URL
					var url = this.href  + "?time="+ new Date();
					alert(url);
					var method = "GET";
					//5. 调用XMLHttpRequeat的open方法
					//最好添加一个时间戳在URL的后面，这样可以确保URL的唯一性，从而确保不会浏览浏览器的缓存
					request.open(method, url);
					//6 调用XMLHttpRequeat 的send 方法
					request.send(null);
					//7. 为XMLHttpRequeat对象添加onreadystatechange 响应函数. 其中onready statechange由服务器触发
					// 当readystate为0的时候，代表未初始化还没有调用open方法；当为1的时候，open方法已被调用，而send方法还有没被调用
					//当为2的时候表示已加载完毕，send方法已被调用请求已经开始。为3的时候表示交互中，服务器正在响应
					//当为4的时候代表响应发送完毕
					//改变readyState属性是服务器对客户端操作的一种方式，每次readyState属性改变都会触发readystatechange事件
					//当请求结束的时候，每个浏览器都会自动将readystate设为4
					request.onreadystatechange =  function () {
						//8. 判断这个响应是否完成: XMLHttpRequeat对象的onreadystatechange为4的时候
						if (request.readyState ==4) {
							//9. 在判断响应是否可用，XMLHttpRequeat对象的返回值为200或304的时候
							if (request.status == 200 || request.status == 304) {
								//10. 答应响应结果: ResponseText
								alert(request.responseText);
							}
						}
					}
					// 2. 取消按节点的默认行为
					return false;
					}
			}
	</script>
</head>
<body>
	<a id = "a" href="helloAjax.txt">Hello Ajax</a><br><br><br>
	Ajax 传输HTML：<a href ="sendByhtml.jsp"> SendByhtml</a><br><br>
	Ajax 传输XML：<a href ="sendByxml.jsp"> SendByXML</a><br><br>
	Ajax 传输Json：<a href ="sendByjson.jsp"> SendByJson</a><br><br>
	Jquery load 方法: <a href  ="ajax_jquery_practice_load1.jsp">ajax_jquery_practice_load1.jsp </a><br><br>
	JQuery 部分load: <a href  ="ajax_jquery_practice_load2.jsp">ajax_jquery_practice_load2.jsp </a><br><br>
	Get and Post 方法(xml): <a href="ajax_jquery_practice_get&post_xml.jsp">ajax_jquery_practice_get&post_xml.jsp</a><br><br>
	Get and Post 方法(json): <a href="ajax_jquery_practice_get&post_json.jsp">ajax_jquery_practice_get&post_json.jsp</a><br><br>
</body>
</html>