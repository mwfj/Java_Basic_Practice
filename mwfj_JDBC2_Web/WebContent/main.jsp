<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="tag_lib.jsp"%>

<c:if test="${requestScope.pager == null}">
	<jsp:forward page="getStudents.action"></jsp:forward>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>

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

.myButton {
	-moz-box-shadow: 0px 10px 14px -7px #276873;
	-webkit-box-shadow: 0px 10px 14px -7px #276873;
	box-shadow: 0px 10px 14px -7px #276873;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #599bb3
		), color-stop(1, #408c99));
	background: -moz-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -webkit-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -o-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -ms-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: linear-gradient(to bottom, #599bb3 5%, #408c99 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#599bb3',
		endColorstr='#408c99', GradientType=0);
	background-color: #599bb3;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	border-radius: 8px;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 12px;
	font-weight: bold;
	padding: 13px 32px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #3d768a;
}

.myButton:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #408c99
		), color-stop(1, #599bb3));
	background: -moz-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -webkit-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -o-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -ms-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: linear-gradient(to bottom, #408c99 5%, #599bb3 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#408c99',
		endColorstr='#599bb3', GradientType=0);
	background-color: #408c99;
}

.myButton:active {
	position: relative;
	top: 1px;
}


.myButton1 {
	-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
	-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
	box-shadow: 0px 1px 0px 0px #f0f7fa;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
	background:-moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2',GradientType=0);
	background-color:#33bdef;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #057fd0;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px -1px 0px #5b6178;
}
.myButton1:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
	background:-moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef',GradientType=0);
	background-color:#019ad2;
}
.myButton1:active {
	position:relative;
	top:1px;
}



</style>


<script type="text/javascript">
	function doCheckedAll() {
		var items = document.getElementsByName("chkItems");
		for (var i = 0; i < items.length; i++) {
			items[i].checked = true;
		}
	}

	function doUnCheckedAll() {
		var items = document.getElementsByName("chkItems");
		for (var i = 0; i < items.length; i++) {
			items[i].checked = false;
		}
	}

	function delStudents() {

		var items = document.getElementsByName("chkItems");
		var ids = "";
		for (var i = 0; i < items.length; i++) {
			if (items[i].checked) {
				ids += "'" + items[i].value + "',";
			}
		}

		if (ids == "") {
			alert("至少要选择一个学生操作。");
			return;
		}

		ids = ids.substring(0, ids.length - 1);
		//alert(ids);
		if (window.confirm("你确定要删除选中的项？")) {
			window.location.href = "${path}/removeStudents.action?ids=" + ids;
		}

	}

	function modifyStudent() {
		var id = "";
		var items = document.getElementsByName("chkItems");
		var count = 0;
		for (var i = 0; i < items.length; i++) {
			if (items[i].checked) {
				id = items[i].value;
				count++;
			}
		}

		if (count != 1) {
			alert("只能选择一个选项进行修改操作。");
			return;
		}

		window.location.href = "${path}/modify.jsp?id=" + id;

	}
	
	function viewStudent(_id) {
		window.location.href = "${path}/view.jsp?id=" + _id;
	}
	
	function selectedItems(_obj) {
		//alert(_obj.value);
		
		window.location.href = 
			"${path}/main.jsp?pagerNO=1&pagerSize=" + _obj.value + "";
	}
	
	function btnSearch(){
		
		var _keywords = document.getElementById("txtKeywords").value;
		window.location.href = 
			"${path}/main.jsp?pagerNO=1&pagerSize=${sessionScope.selectedValue}"  + "&keywords=" + _keywords;
	}
</script>
</head>
<%--
	JDBC : Java DataBase Connectivity
	Java Application 连接数据库的规范
	
	Java App   -----  JDBC API ----- 数据库厂商
	1）要求编程成员按照这个规范来连接数据库
	  a）面向对象 接口|对象操作
	  b）步骤 套路
	  c）连接：桥连（不用）|直连 （*）
	2）要求各大数据库厂商按照JDBC API 规范提供相应的驱动jar包
	
	java.sql.*
	Connection
	DriverManager
	PreparedStatement(Statement)
	CallableStatement
	ResultSet
	
	--- student表的CRUD---
	Create Read Update Delete
	Service：New Get Modify Remove
	Dao：Insert Select Update Delete
--%>
<body>
	<center>
		<hr>
			<input type="text" style="width:70%;height: 30px;"
				id="txtKeywords"> &nbsp;<button class="myButton1"
				onclick="btnSearch();">搜索</button>
		<hr>
		当前第${requestScope.pager.pagerNO}页
		&nbsp;
		<c:forEach begin="1" end="${requestScope.pager.pagerCount}"
			var="p">
			
			<button 
			class="myButton1"
				onclick="window.location.href='main.jsp?pagerNO=${p}&pagerSize=${requestScope.pager.pagerSize}&keywords=${param.keywords}'">${p}</button>
			 &nbsp;
		</c:forEach>
		&nbsp;
		共${requestScope.pager.pagerCount}页
		&nbsp;
		<button 
			class="myButton1"
			onclick="window.location.href='main.jsp?pagerNO=${requestScope.pager.pagerNO + 1} '">下一页</button>
		<button 
			class="myButton1"
			onclick="window.location.href='main.jsp?pagerNO=${requestScope.pager.pagerNO  - 1}'">上一页</button>
		&nbsp;
		
		<button 
			class="myButton1"
			onclick="window.location.href='main.jsp?pagerNO=1'">首页</button>
		<button 
			class="myButton1"
			onclick="window.location.href='main.jsp?pagerNO=${requestScope.pager.pagerCount}'">尾页</button>
		
		
		<c:choose>
			<c:when test="${sessionScope.selectedValue == 3}"> 
				<select onchange="selectedItems(this);">
					<option value="3" selected="selected">每页3条</option>
					<option value="5" >每页5条</option>
					<option value="10">每页10条</option>
				</select>
			</c:when>
			<c:when test="${sessionScope.selectedValue == 5}"> 
				<select onchange="selectedItems(this);">
					<option value="3" >每页3条</option>
					<option value="5" selected="selected">每页5条</option>
					<option value="10">每页10条</option>
				</select>
			</c:when>
			<c:otherwise>
				
				<select onchange="selectedItems(this);">
					<option value="3">每页3条</option>
					<option value="5">每页5条</option>
					<option value="10" selected="selected">每页10条</option>
				</select>
			
			</c:otherwise>
		</c:choose>
		
		
		
		<h5>学生信息系统</h5>
		<table  class="imagetable">
			

			<tr>
				<th>
					<button onclick="doCheckedAll()" class="myButton">全选</button>
					<button onclick="doUnCheckedAll()" class="myButton">全不选</button>
				</th>
				<th>ID</th>
				<th>学生姓名</th>
				<th>学生年龄</th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.pager.list}" var="s">
				<tr style="text-align: center;">
					<td><input type="checkbox" name="chkItems" value="${s.id}">
					</td>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>
						<button class="myButton1"
							onclick="viewStudent('${s.id}')">查看详情</button>
					</td>
				</tr>
			</c:forEach>

		</table>

		<hr>
		<button class="myButton1" onclick="window.location.href='new.jsp'">新增学生信息</button> 
		&nbsp; 
		<button class="myButton1" onclick="delStudents()">删除选中学生信息</button>
		 &nbsp; <button
			onclick="modifyStudent()" class="myButton1">修改一个选中学生信息</button>
		<hr>
	</center>

</body>
</html>