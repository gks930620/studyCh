<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>memberForm.jsp</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
		<div class="page-header">
			<h3>회원가입</h3>
		</div>
		<c:if test="${not empty ex }">
			<h2>해당 회원이 존재하지 않습니다.</h2>
			<div class="pull-left">
				<a href="memberList.wow" class="btn btn-default">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span> &nbsp;&nbsp; 목록</a>
			</div>
		</c:if>
		<c:if test="${empty ex }">
		<form action="memberModify.wow" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="hidden" name="memId" class="form-control input-sm" value="${member.memId}">${member.memId}</td>
						
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="memPass" class="form-control input-sm" value="${member.memPass}"></td>
					</tr>
					<tr>
						<th>회원명</th>
						<td><input type="text" name="memName" class="form-control input-sm" value="${member.memName}"></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input type="text" name="memZip" class="form-control input-sm" value="${member.memZip}"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="memAdd1" class="form-control input-sm" value="${member.memAdd1}">
							<input type="text" name="memAdd2" class="form-control input-sm" value="${member.memAdd2}"></td>
					</tr>
					<tr>
						<th>생일</th>
						<td><input type="date" name="memBir" class="form-control input-sm" value="${member.memBir}"></td>
					</tr>
					<tr>
						<th>메일</th>
						<td><input type="text" name="memMail" class="form-control input-sm" value="${member.memMail}"></td>
					</tr>
					<tr>
						<th>헨드폰</th>
						<td><input type="tel" name="memHp" class="form-control input-sm" value="${member.memHp}"></td>
					</tr>
					<tr>
						<th>직업</th>
						<td><select name="memJob" class="form-control input-sm">
								<option value="">-- 직업 선택 --</option>
								<c:forEach items="${jobList}" var="code">
									<option value="${code.commCd}" ${member.memJob == code.commCd ? "selected='selected'" : "" }>${code.commNm }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>취미</th>
						<td><select name="memLike" class="form-control input-sm">
								<option value="">-- 취미 선택 --</option>
								<c:forEach items="${hobbyList}" var="code">
									<option value="${code.commCd}" ${member.memLike == code.commCd ? "selected='selected'" : "" }>${code.commNm }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="pull-left">
								<a href="memberList.wow" class="btn btn-default">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span> &nbsp;&nbsp; 목 록</a>
							</div>
							<div class="pull-reight">
								<button type="submit" class="btn btn-default"> 
								<span class="glyphicon glyphicon-font" aria-hidden="true"></span>&nbsp;&nbsp; 저 장</button>
							</div>
					</tr>
				</tbody>
			</table>
		</form>
			</c:if>
	</div>

</body>
</html>