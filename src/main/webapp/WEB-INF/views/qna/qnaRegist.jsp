<%@page import="com.study.qna.service.QnaServiceImpl"%>
<%@page import="com.study.qna.service.IQnaService"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/inc/header.jsp" %>  
<title>qnaRegist.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp" %>
<div class="container">

<!--   영진 jsp:useBean 을 사용하지 말자고 하셔서 -->
<jsp:useBean id="qna" class="com.study.qna.vo.QnaVO" />
<jsp:setProperty property="*" name="qna" />
<jsp:setProperty property="boIp" name="qna" value="${pageContext.request.remoteAddr}"  />
<%	
	// free.setBoIp(request.getRemoteAddr());
	/* 
	FreeBoardVO free = new FreeBoardVO();
	pageContext.setAttribute("free", free);
	free.setBoTitle( request.getParameter("boTitle") );
	free.setBoWriter( request.getParameter("boWriter") );
	free.setBoPass( request.getParameter("boPass") );
	free.setBoCategory( request.getParameter("boCategory") );
	free.setBoContent( request.getParameter("boContent") );	
	free.setBoIp( request.getRemoteAddr() ); // <--- 영진엄마가 채워야 할 부분   
	*/

	IQnaService qnaService = new QnaServiceImpl();
	qnaService.registQna(qna);
%>
	<p>글 등록 완료!~~~~ </p>
 <div class="pull-left">
   <a href="freeList.jsp" class="btn btn-default btn-sm"> 
     <span class="glyphicon glyphihcon-list" aria-hidden="true"></span>
     &nbsp;&nbsp;목록
   </a>
 </div>
</div>
</body>



</html>