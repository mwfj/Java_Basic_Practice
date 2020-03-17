<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="path_lib.jsp" %>
<%@ include file="tag_lib.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载</title>
<%@ include file="css_js_lib.jsp" %>

<link rel="stylesheet" href="${path}/resource/css/download.css">
<%-- <script type="text/javascript" src="${path}/js/download.js"></script> --%>

<script type="text/javascript">
	function formSubmit() {
		
	}
</script>

</head>
<body>

	<center>
		<a href="${path}/download.action">文件下载</a>
	</center>

</body>
</html>