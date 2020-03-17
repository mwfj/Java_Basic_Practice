<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A</title>

</head>
<body>
	<%-- 静态包含 --%>
	<%@ include file="title.jsp" %>
	
	<%-- <%@ include file="isLogined.jsp" %> --%>
	
	
	<%--动态包含 --%>
	<%-- <jsp:include page="title.jsp"></jsp:include> --%>
	
	<%--
		相同点： 
		1 包含页面和被包含页面，它内容组合一起
		2 共享request域里面的数据
		不同点：
		静态包含：包含和被包含的代码先合在一起，在编译，形成一个底层源文件
		动态包含：包含和被包含页面先各自编译，在将输出内容组合在一起
		-------------------
		什么时候用：
		包含静态的东西用静态包含：象导入js、css、标签库等等....
		动态包含一般用于业务发生变化的页面。
		-------------------
		
		
	 --%>
	
	
</body>
</html>