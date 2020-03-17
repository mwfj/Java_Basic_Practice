<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script type="text/javascript">
	function changeValidateCode() {
		
		var code = document.getElementById("imageValidateCode");
		code.src = "${pageContext.request.contextPath}/getValidateImage.jpg?timpstamp=" + new Date();
	}
</script>
</head>
<body>
	<%--
		验证码：
		1) 服务器算出一个随机数字（字母、数字，公式......）,保存在服务器上
		2) 随机数字发送到客户端浏览器中（生成一副图片）
		3) 表单提交的时候，用户把他看到的数字填写，然后传到服务器上
		4) 服务器会把原来保存的字符串和用户提交的字符串（验证码）比较
		--------------------------------------------------
		技术实现：
		1）可以事先做100副图片，然后通过配置映射，图片---》内容（字符串值）
		  然后，通过动态图片流，向客户端发送图片，让用户操作。
		2）随机生成字符串值，然后通过画笔画出一幅图，然后把这个值嵌入到图片里面，
		发送到客户端去。 *
		
		
		
		
	 --%>
	<center>
	
		<form action="${pageContext.request.contextPath}/register.action" method="post">
			<table>
				<tr>
					<th>
						登录名
					</th>
					<td>
						<input type="text" name="loginName">
					</td>
				</tr>
				<tr>
					<th>
						验证码
					</th>
					<td>
						<img 
							id="imageValidateCode"
							alt="" 
							title="看不清楚，请点击换一张图片"
							style="cursor: pointer;"
							src="${pageContext.request.contextPath}/getValidateImage.jpg"
							onclick="changeValidateCode()">
							<br>
						<input type="text" name="validateCode">
					</td>
				</tr>
				<tr>
					<td>
						<button>注册</button>
					</td>
				</tr>
			</table>
		</form>
		
	</center>

</body>
</html>