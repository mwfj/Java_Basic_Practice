<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="tag_lib.jsp" %>

<c:if test="${requestScope.student == null}">
	<jsp:forward page="getStudent.action?type=update"></jsp:forward>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New</title>
</head>
<body>
	<center>
		<form action="${path}/modifyStudent.action"
			method="post">
			<table style="width: 60%; ">
				<caption>修改学生信息</caption>
				<tr>
					<td colspan="2">
						<input type="hidden" readonly="readonly"
						name="id" value="${requestScope.student.id}">
					</td>
				</tr>
				<tr>
					<td>
						学生的姓名
					</td>
					<td>
						<input type="text" name="name" style="width: 200px;"
							value="${requestScope.student.name}">
					</td>
				</tr>
				<tr>
					<td>
						学生的年龄
					</td>
					<td>
						<input type="text" name="age" style="width: 200px;"
							value="${requestScope.student.age}">
					</td>
				</tr>
				<tr>
					<td>
						<button>修改</button>
						
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
			<hr>
			<a href="main.jsp">返回主页</a>
		</form>
	</center>
</body>
</html>