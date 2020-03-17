<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/included/path_lib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<%@ include file="/included/jquery_lib.jsp" %>
<%@ include file="/included/jquery_ui_lib.jsp" %>
<%@ include file="/included/uploadify_lib.jsp" %>

<script type="text/javascript">
	$(function() {
		$("input[type=button], button, a")
			.button();
	
		$("#btnLogin").click(function(){
				$("#dialog").dialog("open");
		});
		
		$("#txtDate").datepicker();
		
		$("#file_upload_1").uploadify({
	        height        : 30,
	        swf           : '${path}/js/uploadify/uploadify.swf',
	        uploader      : '${path}/upload.action',
	        width         : 120,
	        fileObjName : "fileUpload",
	        auto	: false
	    });
		
		$("#btnUpload").on("click", function(){
			if(confirm("你确定要上传吗？")){
				$("#file_upload_1").uploadify("upload");
			}
			
		});
			
		
		var _dialog = $("#dialog").dialog({
			autoOpen: false,
			height: 230,
		    width: 400,
			show: {
		        effect: "blind",
		        duration: 500
		      },
		      hide: {
		        effect: "explode",
		        duration: 500
		      },
		    buttons: {
		    	"登录" : login,
		    	"关闭" : function(){
		    		_dialog.dialog("close");
		    	}
		    }
		    
		      
		});
		
		function login(){
			var _loginName = $("#txtLoginName").val();
			var _loginPassword = $("#txtLoginPassword").val();
			
			$.post(
					"${path}/login.action",
					{
						"LoginName" : _loginName,
						"LoginPassword" : _loginPassword
					},
					function(data, status){
						if(status == "success") {
							if(data == "true") {
								alert("登录成功");
								_dialog.dialog("close");
								setTimeout(function(){
									window.location.href = "${path}/index.jsp";
								}, 1000);
							} else {
								alert("登录名或密码错误");
							}
						}
					}
			);
			
		}
		
	});
</script>

</head>
<body>
	<button>普通按钮</button>
	<a href="#">超链接</a>
	<button id="btnLogin">登录</button>
	<input type="button" value="普通按钮">
	<a href="#">超链接</a><a href="#">超链接</a><a href="#">超链接</a>
	
	<hr>
	
	<input type="text" id="txtDate">
	
	<hr>
	
	<input type="file" name="fileUpload" id="file_upload_1" />
	
	<br>
	<button id="btnUpload">上传</button>
	
	
	<div id="dialog" title="登录">
		<table>
			<tr>
				<td>
					登录名：
				</td>
				<td>
					<input type="text" id="txtLoginName">
				</td>
			</tr>
			<tr>
				<td>
					登录密码：
				</td>
				<td>
					<input type="password" id="txtLoginPassword">
				</td>
			</tr>
			<!-- <tr>
				<td>
					<button>登录</button>
				</td>
				<td>
					<button>重置</button>
				</td>
			</tr> -->
		</table>
		 
	</div>
	
</body>
</html>