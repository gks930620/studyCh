<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   request.setCharacterEncoding("UTF-8");
%> 
<%
	// valid 유효한(의미있는, 타당한) , validate 유효화시키다.
	session.invalidate(); // 세션을 무효화 시키다...
	
	response.sendRedirect( request.getContextPath() + "/index.jsp");
%>
