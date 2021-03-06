<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>자유게시판 - 글 수정</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp"%>
<div class="container">
  <div class="page-header">
    <h3>자유게시판 - <small>글 수정</small></h3>
  </div>
 qna
<form:form action="qnaModify.wow" modelAttribute="qna">
	<form:hidden path="boNo"/>	
	
	<table class="table table-striped table-bordered">
		<colgroup>
			<col width="20%" />
			<col/>
		</colgroup>
		<tr>
      <th>글번호</th>
      <td>${qna.boNo}</td>
    </tr>
		<tr>
			<th>제목</th>
			<td><form:input path="boTitle" cssClass="form-control input-sm"  />					
					<form:errors path="boTitle" />
			</td>
			
		</tr>
		<tr>
			<th>작성자</th>
			<td>
					<form:input path="boWriter" cssClass="form-control input-sm" />					
					<form:errors path="boWriter" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><form:password path="boPass" cssClass="form-control input-sm" />
				   <span class="text-danger">
				    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> 
				    글 등록시에 입력한 비밀번호를 입력하세요.
				  </span> 
				  <form:errors path="boPass" />
			</td>
		</tr>
		<tr>
			<th>분류 ${qna.boCategory}</th>
			<td>
				<form:select path="boCategory" cssClass="form-control input-sm" >
					<option value="">== 선택 ==</option>
					<form:options items="${categoryList}" itemValue="commCd" itemLabel="commNm" />
				</form:select>			
			  <form:errors path="boCategory" />
			</td>
		</tr>					
		<tr>
			<th>내용</th>
			<td>				
				<form:textarea path="boContent" cssClass="form-control input-sm" rows="10" />				
			</td>
		</tr>
    <tr>
      <th>IP</th>
      <td>${qna.boIp}</td>
    </tr>
    <tr>
      <th>조회수</th>
      <td>${qna.boHit}</td>
    </tr>
    <tr>
      <th>등록일자</th>
      <td>${qna.boRegDate}</td>
    </tr>   		
		<tr>
			<td colspan="2">
          <div class="pull-left">
              <a href="freeList.wow" class="btn btn-default btn-sm"> 
                <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
                &nbsp;&nbsp;목록
              </a>
            </div>
            <div class="pull-right">
              <!-- 문제점 : 사용자가 입력박스에서 엔터를 치면 첫번째 submit의 formaction 방향으로 이동한다.  -->
              <button type="submit"  formaction="qnaDelete.wow" class="btn btn-sm btn-danger"> 
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                &nbsp;&nbsp;삭제
              </button>
              <button type="submit" class="btn btn-sm btn-primary" > 
                <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                &nbsp;&nbsp;저장
              </button>              
            </div>					
			</td>
		</tr>
	</table>
	</form:form>

</div><!-- container -->
</body>
</html>


