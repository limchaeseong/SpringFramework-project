<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 다음 주소검색 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/join/join.css">
</head>
<body>
	<a href="/">
	<div class="image_logo">
        <img class="logo" src="/resources/join/logo.png" alt="로고">
    </div>
    </a>

	<div class="form_area">
		<form action="./join" method="post" onsubmit="return all_check();">
			<div>
				<label>아이디</label>
				<input type="text" name="userid" class="input_area1" maxlength="20" onblur="u_id();" oninput="checkId();" value="${joinVO.userid}">
				<span id="id_msg"></span>
				<span id="id_check_msg"></span>
			</div>
			<div>
				<label>비밀번호</label>
				<input type="password" name="password" class="input_area1" maxlength="20" onblur="pw();">
				<span id="pw_msg"></span>
			</div>
			<div>
				<label>비밀번호 재확인</label>
				<input type="password" name="password_chk" class="input_area1" onblur="pw_check();">
				<span id="pw_chk_msg"></span>
			</div>
			<div>
				<label>이름</label>
				<input type="text" name="username" class="input_area1" onblur="nm();" value="${joinVO.username}">
				<span id="name_msg"></span>
			</div>
			<div>
				<label>생년월일</label>
				<input type="text" name="birth" class="input_area1" placeholder="예) 19990101" maxlength="8" onblur="birth_chk();" value="${joinVO.birth}">
				<span id="birth_check_msg"></span>
			</div>
			<div>
				<label>성별</label>
				<input type="hidden" id="gender_check" value="${joinVO.gender}">
				<select name="gender" onblur="gen();">
					<option>성별</option>
					<option value="M">남자</option>
					<option value="W">여자</option>
				</select>
				<span id="gen_msg"></span>
			</div>
			<div>
				<label>주소</label>
				<div class="addr_area">
					<input type="text" name="address_1" class="input_area2" onblur="addr();" value="${joinVO.address_1}">
					<button type="button" class="addr_button" onclick="searchMap();">주소검색</button>
				</div>
				<input type="text" name="address_2" class="input_area1" placeholder="나머지 주소를 입력하세요" value="${joinVO.address_2}">
				<span id="addr_msg"></span>
			</div>
			<div>
				<label>이메일</label>
				<div class="emailphone_area">
					<input type="email" name="email" class="input_area3" onblur="e_mail();" value="${joinVO.email}">
					<button type="button" class="emailphone_button" onclick="sendEmail();">이메일 인증번호 받기</button>
				</div>
				<input type="text" id="email_num_chk" class="input_area1" placeholder="인증번호를 입력하세요" disabled="disabled" onblur="e_check();">
				<span id="email_msg"></span>
				<span id="emailCheck_msg"></span>
			</div>
			<div>
				<label>휴대전화</label>
				<div class="emailphone_area">
					<input type="text" name="phone_num" class="input_area3" placeholder="예) 01012345678" maxlength="11" onblur="phone();" value="${joinVO.phone_num}">
					<button type="button" class="emailphone_button" onclick="sendPhone();">휴대폰 인증번호 받기</button>
				</div>
				<input type="text" id="phone_num_chk" class="input_area1" placeholder="인증번호를 입력하세요" disabled="disabled" onblur="p_check();">
				<span id="phone_msg"></span>
				<span id="phoneCheck_msg"></span>
			</div>
			<div>
				<button type="submit" class="join_button">가입하기</button>
				<span id="all_check_msg"></span>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="/resources/join/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/join/join.js"></script>
</html>