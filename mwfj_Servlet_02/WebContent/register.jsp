<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/register.action" method="post">
			<table >
				<tr>
					<td>
						兴趣爱好
					</td>
					<td>
						<input type="checkbox" value="music" name="interesting">音乐
						<input type="checkbox" value="game" name="interesting">游戏
						<input type="checkbox" value="movie" name="interesting">电影
					</td>
				</tr>
				
				<tr>
					<td>
						<button>注册</button>
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