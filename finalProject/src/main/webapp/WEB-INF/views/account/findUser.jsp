<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.6.0.min.js"/>"></script> 
<link rel="stylesheet" href="<c:url value="/resources/css/account/find.css"/>">
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script>
function setDomain(str){
	$('#email_domain').val(str);
}
</script>
</head>
<body>
	<header>
		<div>
			<img src="<c:url value="/resources/img/account/logo.png"/>" alt="모여로고" style=" width: 30%;" />
		</div>
	</header>
	<div id="form_div">
		<div class="title">
			<strong style="font-size: 32px; color: #598BAF;">아이디 찾기</strong>
		</div>
	
		<form action="./findUser" method="post">
			<div>
				<input type="text" id="name" name="a_name" value="" placeholder="성명" maxlength="18" /> 
			</div>
			<div>
				<input type="text" id="email_id" name="e_first" value="" title="이메일 아이디" placeholder="이메일" maxlength="18" /> @ 
				<input type="text" id="email_domain" name="e_last" value="" title="이메일 도메인" placeholder="직접입력" maxlength="18"/> 
				<select class="select" title="이메일 도메인 주소 선택" onclick="setDomain(this.value);return false;">
				    <option value="">-선택-</option>
				    <option value="naver.com">naver.com</option>
				    <option value="gmail.com">gmail.com</option>
				    <option value="hanmail.net">hanmail.net</option>
				    <option value="korea.com">korea.com</option>
				    <option value="nate.com">nate.com</option>
				    <option value="yahoo.com">yahoo.com</option>
				</select>
			</div>
			<div id="submit_div" class="btn_align" style="margin: 2em;">
				<button class="btn" type="submit">아이디 찾기</button>
			</div>
		</form>
		<c:if test="${a_uid ne null}">
			<div class="find_pop">
				<strong style="font-size: 20px; color: #598BAF;">가입하신 아이디는</strong>
				<input type="text" value= "${a_uid}" style="width: 200px; text-align:center;"readonly disabled>
				<strong style="font-size: 20px; color: #598BAF;">입니다.</strong>
			</div>
		</c:if>
	</div>
</body>
</html>