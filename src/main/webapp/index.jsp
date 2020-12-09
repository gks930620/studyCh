<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/header.jsp" %>  
<title>/index.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp"%>
<div class="container">
<h1>세진홈에 오신걸 환영합니다.</h1>
<hr>
<a href="<%=request.getContextPath()%>/05/login.jsp" >로그인</a>
<hr>
	<%=request.getParameter("msg") %>
</div>
</body>
</html>