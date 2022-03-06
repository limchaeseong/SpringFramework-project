<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>passwordModal</title>
<link rel="stylesheet" href="${path }/resources/css/my/passwordModal.css">
</head>
<body>
	<!-- 1. 비밀번호 확인(modal)  -->
	<div class="modal_bg" id="pwCheck">
		<div class="modal_content">
			<header class="headerPw">
				<h1 class="title">비밀번호 확인</h1>
			</header>
			<div class="mainPw">
				<h3 class="textPw">현재 사용 중인 비밀번호를 입력하세요.</h3>
				<div class="inputSpace">
					<input class="inputPw" type="password" name="a_pw" placeholder="비밀번호를 입력하세요." />
				</div>
				<p class="inputErr" id="inputErr">inputError</p>
			</div>
			<footer class="footerPw">
				<button type="button" class="confirmModal" id="ConfirmPw">확인</button>
				<button type="button" class="editBtModal" id="btCancelPwCheck">취소</button>
			</footer>
		</div>
	</div>
	<!-- 2. 비밀번호 변경(modal) -->
	<div class="modal_bg" id="pwUpdate">
		<div class="modal_content">
			<header class="headerPw">
				<h1 class="title">비밀번호 변경</h1>
			</header>
			<div class="mainPw">
				<h3 class="textPw">새로운 비밀번호는 알파벳과 숫자, 특수문자를 포함 총 8자이상이어야 합니다.</h3>
				<div class="inputSpace">
					<input class="inputPw" type="password" placeholder="비밀번호를 입력하세요." id="re_enterPw" />
				</div>
				<div class="inputSpace">
					<input class="inputPw" type="password" placeholder="비밀번호를 다시 한 번 입력하세요." id="pwCheck1" />
				</div>
				<p class="inputErr" id="Error">error</p>
			</div>
			<footer class="footerPw">
				<button type="button" class="confirmModal" id="Confirm">확인</button>
				<button type="button" class="editBtModal" id="btCancelPw">취소</button>
			</footer>
		</div>
	</div>
</body>
</html>