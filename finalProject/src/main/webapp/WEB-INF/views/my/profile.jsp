<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<c:set var="photo" value="${myInfo.a_photo}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보 | 모여</title>
<link rel="stylesheet" href="${path }/resources/css/my/profile.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<c:import url="../header.jsp" />
	<div id="container">
	 <div id="aside">
		 <nav class="sideNav">
			<ul>
				<li class="aside_li"><a class="aside_a" href="./profile">내 정보</a></li>
				<li class="aside_li"><a class="aside_a" href="./post">내가 쓴 글</a></li>				
			</ul>
		 </nav>
	 </div>
	 <div class="main">
	   <h1 class="infoTitle">내 정보</h1>
		<div class="infoBox">
			<div class="infoProfile">
				<h2 class="subTitle">프로필</h2>
				<div class="pBox">
					<ul>
					<!-- 프로필사진(팝업으로 사진변경), 이름(변경불가) -->
					<li class="boxItem">
						<h3 class="label">프로필 사진</h3>
						<div class="content">
						<img src="<c:out value ="${myInfo.a_photo}"/>" id="myPhoto" onerror="this.src='/resources/img/my/photoNoNo_B.png'"/>
						<span class="yourId">[ID : ${myInfo.a_uid}]</span>
						</div>
						<div class="profileBt"><button class="editBt" id="photoBtn">변경</button></div>
						<!-- 파일 선택하기 모달창 띄우기 -->
					
					</li>
					</ul>
				</div>
			</div>
			<div class="infoProfile">
			  <h2 class="subTitle">개인정보</h2>
				<div class="pBox">
					<ul>
						<!-- 아이디(변경불가) -->
						<li class="boxItem">
							<h3 class="label">성명</h3>
							<div class="content">${myInfo.a_name}</div>
							<div class="content" style="visibility:hidden;"></div>
						</li>
						<!-- 비밀번호 (모달 창을 활용) -->
						<li class="boxItem" id="itemPw" style="display:flex;">
							<h3 class="label">비밀번호</h3>
							<div class="content" style="visibility:hidden;"></div>
							<div class="profileBt"><button class="editBt" id="modalPw">변경</button></div>
							<!-- 모달 창관련 jsp 연결 -->
							<c:import url="./passwordModal.jsp" />
						</li>
						<!-- 성별 -->
						<li class="boxItem" id="itemOneG" style="display:flex;">
						  <h3 class="label">성별</h3>
							<div class="content">
								<c:choose>
									<c:when test="${fn:contains(myInfo.a_gender, 'M')}">
									  <div><input class="content" value="M" readonly style="display: none;">남자</div>
									</c:when>
									<c:when test="${fn:contains(myInfo.a_gender, 'W')}">
									  <div><input class="content" value="W" readonly style="display: none;">여자</div>
									</c:when>
								</c:choose>
							</div>
							<div class="profileBt"><button class="editBt" id="btGender">변경</button></div>
						</li>
						<li class="boxItem" id="itemTwoG" style="display:none;">
						  <h3 class="label">성별</h3>
							<div class="content">
								<div>
									<input type="radio" class="a_gender" name="a_gender" value="M">남자
									<input type="radio" class="a_gender" name="a_gender" value="W">여자
								</div>
							</div>
							<div class="profileBt">
								<button type="button" class="editBt -done" id="ConfirmG">확인</button>
								<button type="button" class="editBt" id="btCancelG">취소</button>
							</div>
						</li>
						<!-- 생년월일 -->
						<li class="boxItem" id="itemOneB" style="display:flex;">
							<h3 class="label">생년월일</h3>
							<div class="content">
								${myInfo.a_bdate.substring(0,4)}년 ${myInfo.a_bdate.substring(5,6)}월 ${myInfo.a_bdate.substring(7,8)}일
							</div>
							<div class="profileBt"><button class="editBt" id="btBirthday">변경</button></div>
						</li>
						<li class="boxItem" id="itemTwoB" style="display:none;">
							<h3 class="label">생년월일</h3>
							<div class="content"><input type="text" placeholder="ex)19990101" class="a_bdate" id="datepicker"/></div>
							<div class="profileBt">
								<button type="button" class="editBt -done" id="ConfirmB">확인</button>
								<button type="button" class="editBt" id="btCancelB">취소</button>
							</div>
						</li>
						<!-- 휴대폰 (인증처리 후 진행) -->
						<li class="boxItem" id="itemOneP" style="display:flex;">
							<h3 class="label">휴대폰</h3>
							<div class="content">
								${myInfo.a_phone.substring(0,3)}-${myInfo.a_phone.substring(3,7)}-${myInfo.a_phone.substring(7)}
							</div>
							<div class="profileBt"><button class="editBt" id="btPhone">변경</button></div>
						</li>
						<li class="boxItem" id="itemTwoP" style="display:none;">
							<h3 class="label">휴대폰</h3>
							<div class="content"><input type="number" placeholder="ex)01012345678" class="a_phone" maxlength="8"/></div>
							<div class="profileBt">
								<button type="button" class="editBt -done" id="ConfirmP">확인</button>
								<button type="button" class="editBt" id="btCancelP">취소</button>
							</div>
						</li>
						<!-- 이메일 (중복확인 후 진행) -->
						<li class="boxItem" id="itemOneE" style="display:flex;">
							<h3 class="label">이메일</h3>
							<div class="content">${myInfo.a_email}</div>
							<div class="profileBt"><button class="editBt" id="btEmail">변경</button></div>
						</li>
						<li class="boxItem" id="itemTwoE" style="display:none;">
							<h3 class="label">이메일</h3>
							<div class="content"><input type="text"  placeholder="ex)ex123@moyeo.com" id="a_email"/></div>
							<div class="profileBt">
								<button type="button" class="editBt -done" id="ConfirmE">확인</button>
								<button type="button" class="editBt" id="btCancelE">취소</button>
							</div>
						</li>
						<!-- 주소 (API 이용) -->
						<li class="boxItem" id="itemOneA" style="display:flex;">
							<h3 class="label">주소</h3>
							<div class="content">${myInfo.a_ad}</div>
							<div class="profileBt"><button class="editBt" id="btAd">변경</button></div>
						</li>
						<li class="boxItem" id="itemTwoA" style="display:none;">
							<h3 class="label">주소</h3>
							<div class="content">
								<input type="text" name="a_ad" placeholder="클릭하여 주소를 검색" class="a_ad" readonly/>
								<input type="text" name="a_ad" placeholder="상세주소를 입력해주세요." class="a_ad_detail"/>
								</div>
							<div class="profileBt">
								<button type="button" class="editBt -done" id="ConfirmA">확인</button>
								<button type="button" class="editBt" id="btCancelA">취소</button>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="infoProfile">
				<h2 class="subTitle">연결된 서비스</h2>
				<div class="pBox">
					<ul>
						<!-- 카카오 등록 해제, 연결 하기 -->
						<li class="boxItem">
							<div class="label"><img class="logo" src="/resources/img/icon/kakao-icon.png" style="width:30px; height: 30px;"></div>
							<div class="content" style="display:block;" name="a_kakao">${myInfo.a_kakao}</div>
							<div class="content" style="display:none;" name="a_kakao"><input type="text"></div>
							<div class="profileBt">
								<button class="editBt">연결 하기</button>
								<button class="editBt">등록 해제</button>
							</div>
						</li>
						<!-- 구글 등록 해제, 연결 하기 -->
						<li class="boxItem">
							<div class="label"><img class="logo" src="/resources/img/icon/google-icon.jpg" style="width:30px; height: 30px;"></div>
							<div class="content" style="display:block;" name="a_google">${myInfo.a_google}</div>
							<div class="content" style="display:none;" name="a_google"><input type="text"></div>
							<div class="profileBt">
								<button class="editBt">연결 하기</button>
								<button class="editBt">등록 해제</button>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	 </div>
	</div>
	<c:import url="./myPhotoModal.jsp" />
<script type="text/javascript" src="${path }/resources/js/my/passwordModal.js"></script>
<script type="text/javascript" src="${path }/resources/js/my/myPhotoModal.js"></script>
<script type="text/javascript" src="${path }/resources/js/my/profile.js"></script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
window.onload = function(){
    document.querySelector("input[name=a_ad]").addEventListener("click", function(){
        new daum.Postcode({oncomplete: function(data) {
                document.querySelector("input[name=a_ad]").value = data.address;
            }
        }).open();
    });
    
    $.datepicker.setDefaults({
    	changeMonth: true,
    	changeYear: true,
    	yearRange: '1900:2022',
        dateFormat: 'yymmdd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
        monthNamesShort: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });

    $(function() {
        $("#datepicker").datepicker();
    });
}
</script>
</body>
</html>