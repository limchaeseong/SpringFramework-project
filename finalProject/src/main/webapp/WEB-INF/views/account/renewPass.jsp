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
<link rel="stylesheet" href="<c:url value="/resources/css/account/find.css?after"/>">
<title>패스워드 변경</title>
</head>
<body>
	<header>
		<div>
			<img src="<c:url value="/resources/img/account/logo.png"/>" alt="모여로고" style=" width: 30%;" />
		</div>
	</header>
	<form id="form_div" action="./renewPass" method="post">
		<div class="title">
			<strong style="font-size: 32px; color: #598BAF;">비밀번호 변경</strong>
		</div>
		<div>
		<label></label>
			<input type="password" id="pass" name="new_password" placeholder="새 비밀번호" required>
		</div>
		<div>
		<label></label>
			<input type="password" id="chk_pass" name="chk_password" placeholder="새 비밀번호 확인" required>
			<input type="hidden" id="h_input">
		</div>
		<div>
		<input type="hidden" name="a_id" value="${sessionScope.a_id}">	
		<button id= "change_btn" class= "btn_margin" type="submit">변경하기</button>
		</div>
	</form>
</body>
<script>
//패스워드 확인 체크용
$('#chk_pass').on('input', passChk);
$('#pass').on('input', passChk);

function passChk(){
	var chk_pass = $('#chk_pass').val();
	var pass = $('#pass').val();
	
	if(chk_pass == '' || pass == ''){
		$('#h_input').prop("type","hidden");
	} else {
		if(chk_pass !== pass){
			$('#h_input').prop({"type":"button", "value":"일치하지 않습니다."});
		} else {
			$('#h_input').prop({"type":"button", "value":"일치합니다."})
		}
		if($('#h_input').val() == "일치합니다."){
			$('#h_input').css({"color":"green", "background-color":"white", "border":"1px solid green"});
		}else{
			$('#h_input').css({"color":"red", "background-color":"white", "border":"1px solid red"});
		}
	}
}
</script>
</html>