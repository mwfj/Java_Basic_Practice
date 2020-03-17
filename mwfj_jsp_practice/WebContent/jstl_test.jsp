<%@page import="java_bean.JSTL_label_test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is the JSTL and EL label Page</title>
</head>
<!-- 用javabean读取类
	用c标签设置类的属性
	用el 表达式来输出相应的属性	
 -->
<body>
	<center>
	<h1>This is the JSTL and EL label test</h1>
	<jsp:useBean id="jstl_test" class ="java_bean.JSTL_label_test" scope ="session" />
	<c:set target = "${sessionScope.jstl_test}" property="name" value="liergou"/>
	<h2>
	姓名：${ sessionScope.jstl_test['name']}</h2>
	<h2>cout 输出结果: <c:out value="${ sessionScope.jstl_test.name}"></c:out></h2>
	<c:set target="${sessionScope.jstl_test}" property="age" value="88"/>
	<h2>
	年龄：${ sessionScope.jstl_test.age}</h2>
	<h3>
	<c:if test="${empty sessionScope.jstl_test.age || sessionScope.jstl_test.age<=0 }">
<h1>	The age you input is illegal!!!<br>
			Please input a legal age again!!!
</h1>
	</c:if>
	<c:if test="${!empty sessionScope.jstl_test.age &&sessionScope.jstl_test.age>0}">
				<c:choose>
						<c:when test="${ sessionScope.jstl_test.age>0&&sessionScope.jstl_test.age<12}"> you are the kids</c:when>
						<c:when test="${ sessionScope.jstl_test.age<18}"> you are the teenager</c:when>
						<c:when test="${ sessionScope.jstl_test.age>=18}"> you are the adult</c:when>
						<c:otherwise> you are the old man</c:otherwise>
				</c:choose>
	</c:if></h3>
	<c:set target="${sessionScope.jstl_test}" property="recommand">true</c:set>
	<h2>
	推荐与否：${ sessionScope.jstl_test.recommand}</h2><br>
	</center>
	
</body>
</html>