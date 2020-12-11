<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>자유게시판 - 글 목록</title>

</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
		<div class="page-header">
			<h3>
				자유게시판 - <small>글 목록</small>
			</h3>
		</div>

		<!-- START : 검색 폼  -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form name="frm_search" action="qnaList.wow" method="post"
					class="form-horizontal">
					<input type="hidden" name="curPage" value="${searchVO.curPage }">
					<input type="hidden" name="rowSizePerPage"
						value="${searchVO.rowSizePerPage }">
					<div class="form-group">
						<label for="id_searchType" class="col-sm-2 control-label">검색</label>
						<div class="col-sm-2">
							<select id="id_searchType" name="searchType"
								class="form-control input-sm">
								<option value="T"
									${searchVO.searchType == "T" ? "selected='selected'" : "" }>제목</option>
								<option value="W"
									${searchVO.searchType == "W" ? "selected='selected'" : "" }>작성자</option>
								<option value="C"
									${searchVO.searchType == "C" ? "selected='selected'" : "" }>내용</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input type="text" name="searchWord"
								class="form-control input-sm" value="${searchVO.searchWord}"
								placeholder="검색어">
						</div>
						<label for="id_searchCategory"
							class="col-sm-2 col-sm-offset-2 control-label">분류</label>
						<div class="col-sm-2">
							<select id="id_searchCategory" name="searchCategory"
								class="form-control input-sm">
								<option value="">-- 전체 --</option>
								<c:forEach items="${categoryList}" var="code">
									<option value="${code.commCd}"
										${code.commCd eq searchVO.searchCategory ? "selected='selected'" :""}>${code.commNm}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2 col-sm-offset-9 text-right">
							<button type="button" id="id_btn_reset"
								class="btn btn-sm btn-default">
								<i class="fa fa-sync"></i> &nbsp;&nbsp;초기화
							</button>
						</div>
						<div class="col-sm-1 text-right">
							<button type="submit" class="btn btn-sm btn-primary ">
								<i class="fa fa-search"></i> &nbsp;&nbsp;검 색
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- END : 검색 폼  -->

		<hr>
		${searchVO}
		<!-- START : 목록건수 및 새글쓰기 버튼  -->
		<div class="row" style="margin-bottom: 10px;">
			<div class="col-sm-3 form-inline">
				전체 ${searchVO.totalRowCount } 건 조회 <select id="id_rowSizePerPage"
					name="rowSizePerPage" class="form-control input-sm">
					<option value="10"
						${searchVO.rowSizePerPage == 10 ? "selected='selected'" : "" }>10</option>
					<option value="20"
						${searchVO.rowSizePerPage == 20 ? "selected='selected'" : "" }>20</option>
					<option value="30"
						${searchVO.rowSizePerPage == 30 ? "selected='selected'" : "" }>30</option>
					<option value="50"
						${searchVO.rowSizePerPage == 50 ? "selected='selected'" : "" }>50</option>
				</select>
			</div>
			<div class="col-sm-2 col-sm-offset-7 text-right">
				<a href="qnaForm.wow?boGroupNo=-1&boGroupDepth=-1" class="btn btn-primary btn-sm"> <span
					class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					&nbsp;새글쓰기
				</a>
			</div>
		</div>
		<!-- END : 목록건수 및 새글쓰기 버튼  -->

		<table class="table table-striped table-bordered table-hover">
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col />
				<col width="10%" />
				<col width="15%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
		 	<th>글번호</th>
					<th>분류</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
					<th>답글</th>
					<th>group</th>
					<th>depth</th> 
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${qnaList}" var="qna">
					<tr class="text-center">
					
						<td>${qna.boNo}</td>
						<%-- 		<td>${qna.boCategoryNm}</td> --%>
						<td>${qna.boCategory}</td>
						<td class="text-left"><a href="qnaView.wow?boNo=${qna.boNo}">
								${qna.boTitle} </a></td>
						<td>${qna.boWriter}</td>
						<td>${qna.boRegDate}</td>
						<td>${qna.boHit}</td>
						<td><a href="qnaForm.wow?boGroupNo=${qna.boGroupNo}&boGroupDepth=${qna.boGroupDepth}">
								답글쓰기</a></td>
						<td>${qna.boGroupNo}</td>
						<td>${qna.boGroupDepth}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- START : 페이지네이션  -->
		<mytag:pagination pageObject="${searchVO}" />
		<!-- END : 페이지네이션  -->

	</div>
	<!-- container -->
</body>
<script type="text/javascript">
	// 1. 전역변수 정의
	var $frm = $('form[name=frm_search]');

	// 2. 일반 함수 정의
	// 3. 객체 이벤트 정의

	// 페이지네이션의 a 링크 클릭
	$('ul.pagination a[href]').click(function(e) {
		e.preventDefault();
		// jQuery 에서 data 속성조회 하는 메서드는?
		// this 는 자바스크립트 객체, 이를 jQuery 객체로 변경하려면 $(this)		
		p = $(this).data("page");
		$frm.find('[name=curPage]').val(p);
		$frm.submit();
	}); // 'nav a[href]'.click

	// id_rowSizePerPage 가 변경했을때 처리 (컴공)
	$('#id_rowSizePerPage').change(function() {
		$frm.find('input[name=rowSizePerPage]').val($(this).val());
		$frm.find('input[name=curPage]').val(1);
		$frm.submit();
	}); // '#id_rowSizePerPage').change

	// 초기화 버튼 클릭 
	$('#id_btn_reset').click(function() {
		$frm.find('input[name=curPage]').val(1);
		$frm.find('input[name=searchWord]').val('');
		$frm.find('select[name=searchType]').val('T');
		$frm.find('select[name=searchCategory]').val('');
	}); // '#id_btn_reset').click

	// 4. 초기화 함수 호출
</script>
</html>




