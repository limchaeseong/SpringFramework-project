<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script> 
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<link rel="stylesheet" href="<c:url value="/resources/css/account/login.css"/>">
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="512219327714-3bci5aa51480pv1btj2sd9gqf4k0gmo1.apps.googleusercontent.com">
<title>로그인 페이지</title>
<style>

</style>
</head>
<body>
	<header>
		<div>
			<a href="/">
			<img src="<c:url value="/resources/img/account/logo.png"/>" alt="모여로고" style=" width: 15%;" />
			</a>
		</div>
	</header>
	<div id="bound">
		<nav>
			<div>
				<p style="font-size: 38px; margin: 0;">모임이 쉬워진다!<br/>모두 여기로 모여!</p>
				<p>당신의 모임도 MOYEO 로 시작하세요</p>
				<img src="<c:url value="/resources/img/account/gathering.jpg"/>" alt="모임사진" style=" width: 100%;" />
			</div>
		</nav>
		<section>
			<div id="form_div">
				<div class="title" style="margin-bottom: 1em;">
					<strong style="font-size: 32px; color: #598BAF;">로그인</strong>
				</div>
				<form action="./login" method="post">
					<div>
						<label></label>
						<input id="id_input" type="text" name="a_uid" value="${param.a_uid}" placeholder="아이디">
					</div>
					<div>
					<label></label>
						<input id="pass_input" type="password" name="a_pw" placeholder="비밀번호">
					</div>
					<!-- 로그인 에러면 에러 메시지 출력 -->
						<c:if test="${error}"> 
							<div>
								<span id="fail">${error_msg}</span>
							</div>
						</c:if>
					<c:if test="${nextUrl ne null}">
						<div>
							<input type="hidden" name="nextUrl" value="${nextUrl}">
						</div>
					</c:if>
					<div>
						<button type="submit" id="login_btn">로그인</button>
					</div>
				</form>
				<div>
					<button class="link_btn" type="button" onclick="window.open('./findPass','window 팝업','width= 700,height= 900');">비밀번호 찾기</button>
					<button class="link_btn" type="button" onclick="window.open('./findUser','window 팝업','width= 700,height= 900');">아이디 찾기</button>
					<button class="link_btn" type="button" onclick="window.open('./join')">회원가입</button>
				</div>
				<div id="btn_div">
				<!-- 카카오톡 로그인 -->
					<a href="javascript:kakaoLogin();"><img src="<c:url value="/resources/img/account/kakao_login.png"/>" 
					alt="카카오계정 로그인" style="height: 50px; width: 200px;"/></a>
			    <!-- 구글 로그인 -->
					<div id="GgCustomLogin" class="g-signin2" data-onsuccess="onSignIn" style="display: inline-block; padding: 1em;"></div>
				</div>
			</div>
		</section>
	</div>
	<footer style="margin-right: 13em; margin-top: 2em; text-align: right;">
		<div>
			<a href="javascript:kakaoLogout();">카카오톡 로그아웃(토큰만료)</a>
			<a href="javascript:secession();">카카오톡-사용자 연결끊기</a>
			<a href="javascript:signOut();">구글 로그아웃</a>
		</div>
	</footer>
<script>
//카카오톡
    window.Kakao.init('326a2586241061f24eee67017353a51a');
    function kakaoLogin() {
    	var k_id;
    	var k_email;
    	var k_nickname;
        window.Kakao.Auth.login({
            scope: 'profile_nickname, account_email', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
            success: function(response) {
                console.log(response) // 로그인 성공하면 받아오는 데이터
                //카카오 SDK에 사용자 토큰을 설정한다.
                window.Kakao.Auth.setAccessToken(response.access_token);
                window.Kakao.API.request({ // 카카오에서 사용자 정보 가져오기 
                    url: '/v2/user/me',
                    success: (res) => {
                        const kakao_account = res.kakao_account; //상수화를 통해 값 변화 일어나지 않게
                        console.log(kakao_account);
                        
                        k_id = res.id;
                        k_email = kakao_account.email;
                        nickname = kakao_account.profile.nickname;
                        
                        //console.log(k_id, k_email, nickname);
                        getInfo(k_id, k_email, nickname);
                    }
                });   
            },
            fail: function(error) {
                console.log(error);
            }
        });
    }
    //카카오톡로그인으로 가져온 사용자정보
    function getInfo(k_id, k_email, nickname){
    	$.ajax({
			url: "./kakaoLogin", 	
			type: "POST", 	
			data: {
				//kNickname: nickname
				kId: k_id,
				kEmail: k_email
			}, 	
			dataType: "json",	
			success: function(data) {
				if(data.state === "success"){
					alert('카카오 로그인 되셨습니다.<br>원활한 이용을 위해 회원정보를 수정 해주세요.');
					window.location.href='/' //로그인 후 리다이렉트 되는 코드
				}
				if (data.state === "fail") {
					alert('카카오 로그인 실패');
					window.location.href='./login'
				}
			}
		});
    }
    //카카오톡 로그아웃
  //window.Kakao.init('본인 JAVASCRIPT API 키');
	function kakaoLogout() {
    	if (!Kakao.Auth.getAccessToken()) {
		    console.log('Not logged in.');
		    return;
	    }
	    Kakao.Auth.logout(function(response) {
    		alert(response +' logout');
		    window.location.href='./login'
	    });
	};
	//카카오톡 연결끊기
 function secession() {
 	Kakao.API.request({
     	url: '/v1/user/unlink',
     	success: function(response) {
     		console.log(response);
     		window.location.href='./login'
     	},
     	fail: function(error) {
     		console.log('탈퇴 미완료')
     		console.log(error);
     	},
 	});
 };
 
//구글
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	
	  //서버에 id토큰 보내기 (토큰 일정 시간 지나면 만료) 연결 끊기로 토큰만료하려면 작업 더 필요
	  var id_token = googleUser.getAuthResponse().id_token;
	  var xhr = new XMLHttpRequest();
	  //open 통해 함수 초기화
	  xhr.open('POST', './kakaoLogin');
	  xhr.setRequestHeader('Content-Type', 'application/json');
	  xhr.onload = function() { 
	    console.log('Signed in as: ' + xhr.responseText);
	    
	  };
	  const data = {
			  //gName: profile.getName(),
			  //imageUrl: profile.getImageUrl(),
			  gId: id_token, 
			  gEmail: profile.getEmail()
	  };
	  xhr.onreadystatechange = function(){
		  if(xhr.status === 200){
			  console.log('서버처리결과성공');
			  window.location.href='/';
		  }
	  };
	  xhr.send(JSON.stringify(data));
	}
	
	function signOut() {
	  var auth2 = gapi.auth2.getAuthInstance();
	  auth2.signOut().then(function () {
		  //Disconnecting and revoking scopes 범위 연결 해제 및 취소 
		  gapi.auth2.getAuthInstance().disconnect();
	    console.log('User signed out.');
	    //'signed in' -> '로그인'
	    window.location.href='./login'
	  });
	}
</script>
</body>
</html>