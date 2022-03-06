<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/account/find.css"/>">
<style>
</style>
<title>Find Password</title>
</head>
<body>
	<header>
		<div>
			<img src="<c:url value="/resources/img/account/logo.png"/>" alt="모여로고" style=" width: 30%;" />
		</div>
	</header>
	<div id="form_div">
		<div class="title">
			<strong style="font-size: 32px; color: #598BAF;">비밀번호 찾기</strong>
		</div>
		<form id="f_findPass" action="./findPass" method="post">
			<div id="line">
				<label></label>
				<input type="text" id="id_input" class="username" name="a_uid" value="${param.a_uid}" placeholder="아이디">
				<input type="hidden" id="id_button" class="btn" value="" tabindex="-1" readonly>	
			</div>
			
			<div>
			<label></label>
				<input type="text" id="email_id" name="e_first" value="${param.e_first}" title="이메일 아이디" placeholder="이메일" /> @ 
				<input type="text" id="email_domain" name="e_last" value="${param.e_last}" title="이메일 도메인" placeholder="직접입력" /> 
				<select class="select" title="이메일 도메인 주소 선택" onclick="setDomain(this.value);return false;">
				    <option value="">-선택입력-</option>
				    <option value="naver.com">naver.com</option>
				    <option value="gmail.com">gmail.com</option>
				    <option value="hanmail.net">hanmail.net</option>
				    <option value="korea.com">korea.com</option>
				    <option value="nate.com">nate.com</option>
				    <option value="yahoo.com">yahoo.com</option>
				</select>
				<div id="mail_div" class="btn_margin">
					<button id="b_send" class="btn" type="button" onclick="sendEmail(this.form);">인증 메일 발송하기</button>
				</div>
			</div>
		</form>
	
		<form id="f_authKey" action="./authKey" method="post">
			<div id="auth_div">
				<input type="text" id="authInput" name="authKey" value="" placeholder="인증번호를 입력하세요." maxlength="10" />
				<span class="time" style="color:red; font-size: 24px" ></span>
				<div id="time_div" class="btn_align">
					<button type="button" id="refresh">시간연장</button>
				</div>
			</div>
			<div id="submit_div" class="btn_margin"">
				<button class="btn" type="submit">확인</button>	
			</div>
		</form>
		<c:if test="${unmatch ne null}">
			<script> window.onload = function(){
						alert("인증번호가 다릅니다. 다시 시도해주세요.");
				 	 }
			</script>
		</c:if>
	</div>
</body>
<script>
//이메일 도메인 set
function setDomain(str){
	$('#email_domain').val(str);
};
//가입한 아이디 확인
$('.username').on('blur', function(){
	var input = $(this).val();
		$.ajax({
			url: "./nameCheck", 	
			type: "get", 	
			data: {
				a_uid: input
			}, 	
			dataType: "json",	
		//	context: $('#id_button'),
			success: function(data) {
				if(data.state === "success"){
					if($('.username').val() !== ''){
						$('#id_button').prop({"type":"button", "value":data.msg});	
						$('#f_findPass').find('.btn[value="'+data.msg+'"]').css({
						    'background': "white",
						    'color': "blue",
						    'border': "1px solid blue",
						   });
					}
				}
				if (data.state === "fail") {
					if($('.username').val() !== ''){
						$('#id_button').prop({"type":"button", "value":data.msg});
						$('#f_findPass').find('.btn[value="'+data.msg+'"]').css({
						    'background': "white",
						    'color': "red",
						    'border': "1px solid red"
						   });
					}
				}
			}
			
		});
});
//메일 발송
function sendEmail(f){
		$.ajax({
			url: "./sendEmail", 	
			type: "POST", 	
			data: {
				a_uid: f.a_uid.value,
				e_first: f.e_first.value,
				e_last: f.e_last.value
			}, 	
			dataType: "json",	
			success: function(data) {
				if(data.state === "success"){
					console.log('성공');
					countStart();
				}
				if (data.state === "fail") {
					console.log('실패');
					alert(data.msg);
				}
			}
		});
}
//인증번호 입력 시간 카운트	
function countStart(){	
	//중지를 위해
	var timer = null;
	var isRunning = false;
	// 유효시간 설정
	var leftSec = 180; 
	var display = $(".time");
	// 인증번호 입력 박스 초기화
    $("#authInput").attr("disabled", false);
  	startTimer(leftSec, display);

	// 버튼 클릭 시 시간 연장
	$("#refresh").on("click", function() {
	  if (isRunning){
	    clearInterval(timer);
	    startTimer(leftSec, display);
	  }
	});
	    
	function startTimer(count, display) {  
	  var minutes, seconds;
	  timer = setInterval(function () { //1초(1000ms) 간격으로 호출
	    minutes = parseInt(count / 60, 10);
	    seconds = parseInt(count % 60, 10);
	
	    minutes = minutes < 10 ? "0" + minutes : minutes; 
	    seconds = seconds < 10 ? "0" + seconds : seconds;

	    display.html(minutes + ":" + seconds);

	    // 타이머 끝
	    if (count-- < 0) { //전위연산하면 1에서 alert
	      clearInterval(timer);
	      alert("시간초과");
	      display.html("입력 시간이 초과되었습니다. 메일을 다시 발송하세요");
	      $("#authInput").attr("disabled", true);
	      isRunning = false;
	    }
	  }, 1000);
	  isRunning = true;
	}
}

</script>
</html>