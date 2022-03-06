<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<c:url var="jq_url" value="/static/jq"/>
<script type="text/javascript" src="${jq_url}/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/resources/css/metting/schedule.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/resources/js/club/metting.js"></script>
<title>일정 생성</title>
</head>
<body>
	<div class="image_logo">
		<img class="logo" src="/resources/join/logo.png" alt="로고">
	</div>
	<div style="width:360px; margin:auto; text-align:center;">
		<h1>일정 만들기</h1>
		<hr>
		<form action="./metting" method="POST" enctype="multipart/form-data">
			<div style="text-align:left">
				<label>일정 제목 </label><input type="text" name="mt_name" placeholder="일정 제목을 입력해주세요" style="width:270px;" required/><br>
				<label>일정 설명 </label><textarea cols="23" name="mt_discription" rows="10" placeholder="일정 설명해주세요" style="width:270px;" required></textarea><br>
				<label>일정 사진 </label><input type="file" name="img" style="border:none"accept="image/gif, image/jpeg, image/png" />
			</div>
			<hr>
			<div style="text-align:left">
				<label>시작 </label><input type="date" name="s_date" required/><input type="time" name="s_time" id="s_time" required /><br>
				<label>종료 </label><input type="date" name="f_date" required/><input type="time" name="f_time" id="f_time" required /><br>
				<label>	   </label><input type="checkbox" id="all_day"/><label>종일 일정</label><br>
				<label>위치 </label><input type="text" name="address1" id="address1" required/><br>
				<label>	   </label><input type="text" name="address2" id="address2" required/>
			</div>
			<hr>
			<div style="text-align:left">
				<label>참가비 </label><input type="number" name="mt_price" style="text-align:right" id="cost" min="0" placeholder="참가비를 입력해주세요." required/><span>원</span>
				<select id="sel_cost">
					<option selected>선택</option>
					<option value="0">없음</option>
					<option value="5000">5000원</option>
					<option value="10000">10000원</option>
					<option value="15000">15000원</option>
					<option value="20000">20000원</option>
					<option value="-1">직접입력</option>
				</select><br>
				<label>참가인원</label><input type="number" name="mt_people" style="text-align:right" id="num" min="1" placeholder="참가 가능 인원을 선택 하세요" required/><span>명</span>
				<select id="sel_num">
					<option selected>선택</option>
					<option value="1">1명</option>
					<option value="2">2명</option>
					<option value="3">3명</option>
					<option value="4">4명</option>
					<option value="5">5명</option>
					<option value="-1">직접입력</option>
				</select><br>
			</div>
			<div style="text-align:left">
				<label>조 번호</label><input type="number" name="c_id" value="${c_id}" readonly>
			</div>
			<hr>
				<button id="complete">완료</button>
				<button id="cancle" onclick="window.close()">취소</button>
		</form>
	</div>
</body>
</html>