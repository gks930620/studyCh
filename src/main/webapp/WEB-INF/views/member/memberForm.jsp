<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		<form action="memberRegist.wow" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="memId" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="memPass" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>회원명</th>
						<td><input type="text" name="memName" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input type="text" name="memZip" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="memAdd1" class="form-control input-sm">
							<input type="text" name="memAdd2" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>생일</th>
						<td><input type="date" name="memBir" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>메일</th> 
						<td><input type="text" name="memMail" class="form-control input-sm" id="email">
						<input type="button" onclick="fn_emailSend()">인증메일발송
							
						</td>

					</tr>
					<tr>
						<th>헨드폰</th>
						<td><input type="tel" name="memHp" class="form-control input-sm"></td>
					</tr>
					<tr>
						<th>직업</th>
						<td><select name="memJob" class="form-control input-sm">
								<option value="">-- 직업 선택 --</option>
								<c:forEach items="${jobList}" var="code">
									<option value="${code.commCd}">${code.commNm }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>취미</th>
						<td><select name="memLike" class="form-control input-sm">
								<option value="">-- 취미 선택 --</option>
								<c:forEach items="${hobbyList}" var="code">
									<option value="${code.commCd}">${code.commNm }</option>
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
	</div>


<script type="text/javascript">
//이메일인증하기  인증메일보내기 
	function fn_emailSend() {
		event.preventDefault(); //form으로인해 insertMessage넘어가는거 패스 
		var v_email = document.getElementById("email").value;
		alert("메일을 보냈습니다. 확인해주세요"+v_email);
		$.ajax({
			url : "signUp.edu?email=" + v_email,
			type : "post",
			//dataType : "json",
			//data : {},
			success : function(data) {
				console.log(data);  //data는 난수 6자리
				$("#sendedRandom").attr("value",data);	
			},
			error : function(request, status, error) {
				console.log(request);
				console.log(status);
				console.log(error);
			}
		})
	}
</script>



<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소">
<input type="text" id="sample4_extraAddress" placeholder="참고항목">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>

</body>
</html>