<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body>

	<center>
		<%--表单中有file控件 那么，form的enctype一定要指定 --%>
		<form action="${pageContext.request.contextPath}/upload.action"
			 enctype="multipart/form-data"
		
			method="post">
			<table>
				<tr>
					<td>
						上传文件
					</td>
					<td>
						<input type="file" name="fileUpload">
						
					</td>
					
				</tr>
				<tr>
					<td>
						上传文件描述
					</td>
					<td>
						<input type="text" name="fileDes">
					</td>
				</tr>
				<tr>
					<td>
						上传文件的标题
					</td>
					<td>
						<input type="text" name="fileTitle">
					</td>
				</tr>
				<tr>
					<td>
						<button>上传</button>
					</td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>