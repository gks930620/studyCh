<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="resource.message" prefix="menu." >   

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Study</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="<%=request.getContextPath()%>/">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
             role="button" aria-expanded="false">
             	<fmt:message key="board.title" />
             	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">
						<li><a href="#"><fmt:message key="board.free" /></a></li>
            <li><a href="#"><fmt:message key="board.notice" /></a></li>            
            <li class="divider"></li>
            <li><a href="#"><fmt:message key="board.pds" /></a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <%
      	UserVO loginUser = (UserVO)session.getAttribute("USER_INFO");	
      	if(loginUser == null){	
      %>
        	<li>
        		<a href="<%=request.getContextPath() %>/13/login.jsp"><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>
        			&nbsp;&nbsp;<fmt:message key="login.title" />
        		</a>
        	</li>
      <%
      	}else{
      %>  
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
             role="button" aria-expanded="false">
             	<i class="glyphicon glyphicon-user" aria-hidden="true"></i>&nbsp;&nbsp;
             	<%=loginUser.getUserName() %><fmt:message key="login.welcome" />
             	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">
					<li><a href="#">
							<i class="glyphicon glyphicon-equalizer" aria-hidden="true"></i>&nbsp;&nbsp;
							<fmt:message key="login.mypage" />
						</a>
					</li>
            <li><a href="#"><i class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
            </i>&nbsp;&nbsp;<fmt:message key="login.order" /></a></li>            
            <li><a href="#"><i class="glyphicon glyphicon-list" aria-hidden="true">
            </i>&nbsp;&nbsp;<fmt:message key="login.qna" /></a></li>
            <li class="divider"></li>
            
            <li><a href="<%=request.getContextPath() %>/13/logout.jsp">
            <i class="glyphicon glyphicon-log-out" aria-hidden="true">
            </i>&nbsp;&nbsp;<fmt:message key="login.logout" /></a></li>
            
          </ul>
        </li>
       <% 
       	}
       %> 
       <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
             role="button" aria-expanded="false">
             	Lang
             	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">
						<li><a href="<%=request.getContextPath()%>/17/localeChange.jsp?lang=en">eng</a></li>
						<li><a href="<%=request.getContextPath()%>/17/localeChange.jsp?lang=ko">ko</a></li>
						<li><a href="<%=request.getContextPath()%>/17/localeChange.jsp?lang=ja">ja</a></li>
          </ul>
        </li>
       
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
</fmt:bundle>
    