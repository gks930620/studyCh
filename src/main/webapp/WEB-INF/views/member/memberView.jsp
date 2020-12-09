<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>memberView.jsp</title>
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
			<table class="table">
				<colgroup>
					<col width="20%" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${member.memId}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>${member.memPass}</td>
					</tr>
					<tr>
						<th>회원명</th>
						<td>${member.memName}</td>
					</tr>
					<tr>
						<th>생일</th>
						<td>${member.memBir}</td>
					</tr>
					<tr>
						<th>헨드폰</th>
						<td>${member.memHp}</td>
					</tr>
					<tr>
						<th>직업</th>
						<td>${member.memJobNm}</td>
					</tr>
					<tr>
						<th>취미</th>
						<td>${member.memLikeNm}</td>
					</tr>
					<tr>
						<th>마일리지</th>
						<td>${member.memMileage}</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="pull-left">
								<a href="memberList.wow" class="btn btn-default">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span> &nbsp;&nbsp; 목록</a>
							</div>
							<div class="pull-reight">
								<a href="memberEdit.wow?memId=${member.memId}" class="btn btn-default"> 
								<span class="glyphicon glyphicon-font" aria-hidden="true"></span>&nbsp;&nbsp; 수정</a>
							</div>
					</tr>
				</tbody>
			</table>
			</c:if>
	</div>

</body>
</html>