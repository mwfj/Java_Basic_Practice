<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="tag_lib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New</title>
</head>
<body>
	<center>
		<form action="${path}/newStudent.action"
			method="post">
			<table style="width: 60%; border: 1px solid black">
				<caption>新增学生信息</caption>
				<tr>
					<td>
						学生的姓名
					</td>
					<td>
						<input type="text" name="name" style="width: 200px;">
					</td>
				</tr>
				<tr>
					<td>
						学生的年龄
					</td>
					<td>
						<input type="text" name="age" style="width: 200px;">
					</td>
				</tr>
				<tr>
					<td>
						<button>新增</button>
						
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>