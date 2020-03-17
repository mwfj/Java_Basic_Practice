<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image</title>
</head>
<body>
	<center>
		<img alt="" 
			style="width: 480px; height: 320px"
			src="${pageContext.request.contextPath}/images/1.jpg">
			
			<hr>
			
				<a href="${pageContext.request.contextPath}/getReadme.pdf">打开一个PDF</a>
			
			<hr>
		
		<img alt="" 
			style="width: 480px; height: 320px"
			src="${pageContext.request.contextPath}/getImage.jpg?id=1">
			<br>
		<img alt="" 
			style="width: 480px; height: 320px"
			src="${pageContext.request.contextPath}/getImage.jpg?id=2">
			<br>
		<img alt="" 
			style="width: 480px; height: 320px"
			src="${pageContext.request.contextPath}/getImage.jpg?id=3">
	</center>
</body>
</html>