<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="tag_lib.jsp"%>

<c:if test="${requestScope.student == null}">
	<jsp:forward page="getStudent.action?type=view"></jsp:forward>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
<style type="text/css">
table.imagetable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.imagetable th {
	background: #b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}

table.imagetable td {
	background: #dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
</head>
<body>

	<center>
		<h5>查看学生信息</h5>
		<table  class="imagetable">

			<tr>
				<td>学生ID</td>
				<td>${requestScope.student.id}</td>

			</tr>
			<tr>
				<td>学生的姓名</td>
				<td>${requestScope.student.name}</td>
			</tr>
			<tr>
				<td>学生的年龄</td>
				<td>${requestScope.student.age}</td>
			</tr>

		</table>
		<hr>
		<a href="main.jsp">返回主页</a>

	</center>

</body>
</html>