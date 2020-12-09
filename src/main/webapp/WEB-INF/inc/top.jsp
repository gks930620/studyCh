<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
             role="button" aria-expanded="false">관리자<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
						<li><a href="<%=request.getContextPath()%>/member/memberList.wow">회원관리</a></li>
            <li><a href="#">통계</a></li>            
            <li class="divider"></li>
            <li><a href="#">컴공파이팅</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
             role="button" aria-expanded="false">게시판<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
						<li><a href="<%=request.getContextPath()%>/free/freeList.wow">자유게시판</a></li>
            <li><a href="#">공지사항</a></li>            
            <li class="divider"></li>
            <li><a href="#">자료실</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <%
      	UserVO loginUser = (UserVO)session.getAttribute("USER_INFO");	
      	if(loginUser == null){	
      %>
        	<li><a href="<%=request.getContextPath() %>/login/login.wow">
        				<i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>
        				&nbsp;&nbsp;로그인
        			</a>
        	</li>
      <%
      	}else{
      %>  
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
             role="button" aria-expanded="false">
             	<i class="glyphicon glyphicon-user" aria-hidden="true"></i>&nbsp;&nbsp;
             	<%=loginUser.getUserName() %>님 방가
             	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">
			<li><a href="#">
					<i class="glyphicon glyphicon-equalizer" aria-hidden="true"></i>&nbsp;&nbsp;
					마이 페이지
				</a>
			</li>
            <li><a href="#"><i class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
            </i>&nbsp;&nbsp;주문현황</a></li>            
            <li><a href="#"><i class="glyphicon glyphicon-list" aria-hidden="true">
            </i>&nbsp;&nbsp;1:1 문의게시판</a></li>
            <li class="divider"></li>
            
            <li><a href="<%=request.getContextPath() %>/login/logout.wow">
            <i class="glyphicon glyphicon-log-out" aria-hidden="true">
            </i>&nbsp;&nbsp;로그아웃</a></li>
            
          </ul>
        </li>
       <% 
       	}
       %> 
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
    