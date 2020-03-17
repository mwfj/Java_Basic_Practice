<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

<c:if test="${sessionScope.User == null}">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if> 

