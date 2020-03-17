<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax and jQuery test 1</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(function () {
		$("a").click(function(){
			//这里的href是DOM对象而不是jQuery对象
			//load 方法是jQuery中最简单也最常用的方法，能载入远程的HTML代码并插入到DOM中
			var url = this.href;
			var  dates = {"time": new Date()}; 
			$("#context").load(url,dates);

			
			return false;
			});
	})
</script>
</head>
<body>
	<a id="a" href="helloAjax.txt">click on it</a>
	<div id="context"></div>
</body>
</html>