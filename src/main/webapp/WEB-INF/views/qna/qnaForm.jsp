<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>자유게시판 - 글 등록</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
		<div class="page-header">
			<h3>
				자유게시판 - <small>글 등록</small>
			</h3>
		</div>

		<div class="panel panel-body">
			<form:errors path="qna" />
		</div>

		<form:form action="qnaRegist.wow" modelAttribute="qna">
			<form:input path="boGroupNo" />
			<form:input path="boGroupDepth" />
			<table class="table table-striped table-bordered">
				<colgroup>
					<col width="20%" />
					<col />
				</colgroup>
				<tr>
					<th>제목</th>
					<td><form:input path="boTitle"
							cssClass="form-control input-sm" /> <form:errors path="boTitle" />
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><form:input path="boWriter"
							cssClass="form-control input-sm" /> <form:errors path="boWriter" />
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="boPass" value=""
						class="form-control input-sm"> <!-- required="required" pattern="\w{4,}" title="알파벳과 숫자로 4글자 이상 입력"  -->
						<span class="text-danger"> <span
							class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							수정 또는 삭제시에 필요합니다.
					</span> <form:errors path="boPass" /></td>
				</tr>
				<tr>
					<th>분류</th>
					<td><select name="boCategory" class="form-control input-sm">
							<option value="">-- 선택하세요--</option>
							<c:forEach items="${categoryList}" var="code">
								<option value="${code.commCd}"
									${code.commCd eq free.boCategory ? 'selected="selected"' : ''}>${code.commNm}</option>
							</c:forEach>
					</select> <form:errors path="boCategory" /></td>
				</tr>
				<tr>
					<th>IP</th>
					<td><%=request.getRemoteAddr()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" name="boContent" class="form-control"
							id="p_content">${qna.boContent}</textarea> <script
							type="text/javascript">
								CKEDITOR.replace('p_content', {
									height : 500
								});
							</script></td>
				</tr>
				<tr>
					<th>메일</th>
					<td><input type="text" name="memMail"
						class="form-control input-sm" id="email">

						<button onclick="fn_emailSend()">인증메일발송</button> <input
						type="text" name="memMail" class="form-control input-sm"
						id="emailCheck">
						<button onclick="fn_emailCheck()">이메일인증</button></td>

				</tr>
				<tr>
					<td colspan="2">
						<div class="pull-left">
							<a href="qnaList.wow" class="btn btn-default btn-sm"> <span
								class="glyphicon glyphicon-list" aria-hidden="true"></span>
								&nbsp;&nbsp;목록
							</a>
						</div>
						<div class="pull-right">
							<button type="submit" class="btn btn-sm btn-primary">
								<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
								&nbsp;&nbsp;저장
							</button>
						</div>
					</td>
				</tr>
			</table>
		</form:form>

	</div>
	<!-- container -->
</body>
<script>
	//이메일인증하기  인증메일보내기 
	function fn_emailSend() {
		event.preventDefault(); //form으로인해 insertMessage넘어가는거 패스 
		var v_email = document.getElementById("email").value;
		alert("메일을 보냈습니다. 확인해주세요");
		$.ajax({
			url : "signUp.edu?email=" + v_email,
			type : "post",
			//dataType : "json",
			//data : {},
			success : function(data) {
				console.log(data); //data는 난수 6자리

			},
			error : function(request, status, error) {
				console.log(request);
				console.log(status);
				console.log(error);
			}
		})
	}
</script>
</html>


