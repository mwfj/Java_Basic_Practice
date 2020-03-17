<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax jQuery 部分 load</title>
<script type="text/javascript" src  = "scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">
	//Ajax传递HTML
	//服务器通过HTML传递数据文本储存在responseText属性中。插入HTML最好的办法就是更新元素的innerHTML属性
	$(function(){
		$("a").click(function(){
				//在这里通过在连接下添加选择器来实现部分load (其中h1前的空格URL和选择器之间的间隔，而h1和 a之间的空格代表a是h1的子标签)
				var url = this.href + " h1 a";
				var dates = {"time": new Date()};
				//任何一个HTML节点都可以使用load 方法来加载ajax. 结果将直接插入到当前HTML节点中
				$("#details").load(url,dates);
				return false;
			});
		})
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