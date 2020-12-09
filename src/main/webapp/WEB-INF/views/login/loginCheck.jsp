<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.util.UserList"%>
<%@page import="com.study.util.CookieUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp" %>
<div class="container">
  <ul>
    <%
    CookieUtils utils = new CookieUtils(request);
    %>
    <li>세션아이디 : <%=session.getId() %>    
    <li>JSESSIONID : <%=utils.getValue("JSESSIONID") %>
    <%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date  date = new Date();
    date.setTime(session.getCreationTime());
    %>
    <li>생성 시간 : <%=sdf.format(date) %>
    <%
    date.setTime(session.getLastAccessedTime());
    %>    
    <li>마지막 접근시간 : <%=sdf.format(date) %>
    <li>유지시간 : <%=session.getMaxInactiveInterval() %>
  </ul>
  <% 
      // 로그인 체크 
      String id = request.getParameter("userId");
      String pw = request.getParameter("userPass");
      UserList userList = new UserList();
      out.println(id + ", " + pw);     
      
      UserVO user = userList.getUser(id);
      
      if(user != null){
    	  
        if(user.getUserPass().equals(pw)){        	
        	// 브라우저에게 /index.jsp 로 리다이렉트 요청        	   
        	// 세션에 user 를 "USER_INFO" 로 저장
        	String remember = request.getParameter("rememberMe");
        	Cookie cookie = null;
        	if(remember == null){
        		cookie = CookieUtils.createCookie("SAVE_ID", "", "/", 0);        		
        	}else{
        		cookie = CookieUtils.createCookie("SAVE_ID", id, "/", 60 * 60 * 24 * 30);        		
        	}
        	response.addCookie(cookie);
        	
        	session.setAttribute("USER_INFO", user);
        	response.sendRedirect(request.getContextPath() + "/index.jsp");
        	// out.println("로그인 성공!!");
        }else{
        	// request 속성에 "msg", "비번이 틀려요" 담고 
        	// login.jsp 포워드  (전기백 아찌)        	
        	request.setAttribute("msg", "비번이 틀려요");
        	pageContext.forward("login.jsp");
        	// out.println("비번이 틀려요..");
        }
      }else{
    	  // 403 에러를 발생 (우연경 엄마)
    	  response.sendError(HttpServletResponse.SC_FORBIDDEN,"넌 누구니?");
    	  //out.println("넌 누구니??");
      }
  %>
  


</div>
</body>
</html>




