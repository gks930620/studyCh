<%@page import="com.study.util.CookieUtils"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
	 <div class="form-signin">
		<form action="loginCheck.jsp" method="post">
			<h2>로그인</h2>
			<%
				String msg = (String)request.getAttribute("msg");
			
				String saveId = "";
				String checkedRemember = "";
				CookieUtils cookieUtils = new CookieUtils(request);
				if(cookieUtils.getValue("SAVE_ID") != null ){
					saveId = cookieUtils.getValue("SAVE_ID");
					checkedRemember = "checked='checked'";
				}
				
				/* 
				Cookie[] cookies = request.getCookies();
				for(int i = 0; i<cookies.length;i++){
					if(cookies[i].getName().equals("SAVE_ID")){
						saveId = URLDecoder.decode(cookies[i].getValue(), "utf-8");
						checkedRemember = "checked='checked'";
						break;  // for 문 중지 
					}
				}
				*/
			%>
			<p><%=msg %></p>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" class="form-control input-sm" value="<%=saveId%>"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass"	class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2">
							<label>
								<input type="checkbox" name="rememberMe" value="Y" <%=checkedRemember %> > ID 기억하기
							</label>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</div>
	<!-- container -->
</body>
</html>