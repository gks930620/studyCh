<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
/* 
	// 현재 세션에 "USER_INFO" 가 존재할때만 현재페이지가 처리되어야 합니다.
	UserVO loginInfo = (UserVO)session.getAttribute("USER_INFO");
	if(loginInfo == null) {
		response.sendRedirect(request.getContextPath() + "/login/login.jsp");
		return;
	}
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>회원 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
		<div>
			<h1>
				회원정보 - <small>회원 목록</small>
			</h1>
			<p>JDBC로 구현해 보기</p>
		</div>

		<!-- START : 검색 폼  -->
		<div class="panel panel-default">
			<div class="panel-body">
				<form name="frm_search" action="memberList.wow" method="post"
					class="form-horizontal">
					<input type="hidden" name="curPage" value="${searchVO.curPage}">
					<input type="hidden" name="rowSizePerPage" value="${searchVO.rowSizePerPage}">
					<div class="form-group">
						<label for="id_searchType" class="col-sm-1 control-label">검색</label>
						<div class="col-sm-2">
							<select id="id_searchType" name="searchType"
								class="form-control input-sm">
								<option value="I" ${searchVO.searchType == "I" ? "selected='selected'" : "" }>아이디</option>
								<option value="N" ${searchVO.searchType == "N" ? "selected='selected'" : "" }>이름</option>
								<option value="T" ${searchVO.searchType == "T" ? "selected='selected'" : "" }>연락처</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input type="text" name="searchWord"
								class="form-control input-sm" value="${searchVO.searchWord}"
								placeholder="검색어">
						</div>
						<label for="id_searchJob"
							class="col-sm-2 control-label">직업</label>
						<div class="col-sm-2">
							<select id="id_searchJob" name="searchJob"
								class="form-control input-sm">
								<option value="">-- 전체 --</option>
								<c:forEach items="${jobList}" var="code">
									<option value="${code.commCd}"  
										${searchVO.searchJob == code.commCd ? "selected='selected'" : ""}>${code.commNm}</option>
								</c:forEach>
							</select>
						</div>
						<label for="id_searchLike"
							class="col-sm-2 control-label">취미</label>
						<div class="col-sm-2">
							<select id="id_searchLike" name="searchLike"
								class="form-control input-sm">
								<option value="">-- 전체 --</option>
								<c:forEach items="${hobbyList}" var="code">
									<option value="${code.commCd}"
										${searchVO.searchLike == code.commCd ? "selected='selected'" : ""}>${code.commNm}</option>
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
		${searchVO}
		<!-- START : 목록건수 및 회원등록 버튼  -->
		<div class="row" style="margin-bottom: 10px;">
			<div class="col-sm-3 form-inline">
				전체 ${searchVO.totalRowCount} 건 조회 <select id="id_rowSizePerPage"
					name="rowSizePerPage" class="form-control input-sm">
					<option value="10" ${searchVO.rowSizePerPage == 10 ? "selected='selected'" : "" }>10</option>
					<option value="20" ${searchVO.rowSizePerPage == 20 ? "selected='selected'" : "" }>20</option>
					<option value="30" ${searchVO.rowSizePerPage == 30 ? "selected='selected'" : "" }>30</option>
					<option value="50" ${searchVO.rowSizePerPage == 50 ? "selected='selected'" : "" }>50</option>
				</select>
			</div>
			<div class="col-sm-2 col-sm-offset-7 text-right">
				<a href="memberForm.wow" class="btn btn-primary btn-sm"> <span
					class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					&nbsp;회원등록
				</a>
			</div>
		</div>
		<!-- END : 목록건수 및 회원등록 버튼  -->
		<table class="table table-striped">
			<colgroup>
				<col width="15%" />
				<col width="15%" />
				<col />
				<col width="20%" />
				<col width="15%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>회원명</th>
					<th>주소</th>
					<th>직업</th>
					<th>HP</th>
					<th>마일리지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="vo">
				<tr>
					<td>${vo.memId}</td>
					<td>
						<a href="memberView.wow?memId=${vo.memId}">
							${vo.memName}
						</a>
					</td>
					<td>${vo.memAdd1} ${vo.memAdd2}</td>
					<td>${vo.memJobNm}</td>
					<td>${vo.memHp}</td>
					<td>${vo.memMileage}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- START : 페이지네이션  -->
		<nav class="text-center">
			<ul class="pagination">

				<!-- 이전 페이지 -->
				<c:if test="${searchVO.firstPage > 1}">
					<li><a href="?curPage=${searchVO.firstPage - 1}"
						data-page="${searchVO.firstPage - 1}" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<!-- 페이지 넘버링  -->
				<c:forEach begin="${searchVO.firstPage}" end="${searchVO.lastPage}"
					var="i">
					<c:if test="${i != searchVO.curPage}">
						<li><a href="?curPage=${i}" data-page="${i}">${i}</a></li>
					</c:if>
					<c:if test="${i == searchVO.curPage }">
						<li class="active"><a>${i}</a></li>
					</c:if>
				</c:forEach>

				<!-- 다음  페이지  -->
				<c:if test="${searchVO.lastPage < searchVO.totalPageCount}">
					<li><a href="?curPage=${searchVO.lastPage + 1}"
						data-page="${searchVO.lastPage + 1}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- END : 페이지네이션  -->
	</div>
</body>
<script type="text/javascript">
	// 1. 전연변수 정의
	var $frm = $('form[name=frm_search]');
	
	// 2. 일반 함수 정의
	
	// 3. 객체 이벤트 정의
	
	// 페이지네이션의 a 링크 클릭
	$('ul.pagination a[href]').click(function(e) {
		e.preventDefault();
		// jQery에서 data 속성조회하는 메서드는 ?
		// this는 자바스크립트 객체, 이를 jQery 객체로 변경 $(this)
		p = $(this).data("page");
		$frm.find('[name=curPage]').val(p);
		$frm.submit();
	}); //$('nav a[href]').click
	
	// id_rowSizePerPage가 변경했을 때 처리
	$('#id_rowSizePerPage').change(function() {
		// 해당 값을 $frm의 rowSizePerPage의 값으로 설정
		p = $(this).val();
		$frm.find('[name=rowSizePerPage]').val(p);
		
		// $frm의 curPage 는 1로 설정
		$frm.find('[name=curPage]').val(1);
		
		// $frm.submit();
		$frm.submit();
	}); // $('#id_rowSizePerPage').change
	
	// 초기화 버튼 클릭
	$('#id_btn_reset').click(function() {
		$frm.find('input[name=curPage]').val(1);
		$frm.find('input[name=searchWord]').val('');
		$frm.find('select[name=searchType]').val('I');
		$frm.find('select[name=searchJob]').val('');
		$frm.find('select[name=searchLike]').val('');
	});
	
	// 4. 초기값, 초기화 함수 호출
</script>
</html>