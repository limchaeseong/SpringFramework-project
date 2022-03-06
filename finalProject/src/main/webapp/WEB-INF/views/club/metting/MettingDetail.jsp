<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/resources/css/metting/MettingDetail.css">
<script type="text/javascript">
$(document).ready(function(){
	$("#apply").click(function(){
		var mt_id = ${meeting.MT_ID};
		
		var mt_form = document.createElement('form');
		mt_form.name='mt_form';
		mt_form.method='post';
		mt_form.action="/mt_apply";
		
		var meeting = document.createElement('input');
		meeting.setAttribute('type','hidden');
		meeting.setAttribute('name','mt_id');
		meeting.setAttribute('value',mt_id);
		
		mt_form.appendChild(meeting);
		document.body.appendChild(mt_form);
		mt_form.submit();
	})
	
	$("#cancle").click(function(){
		var mt_id = ${meeting.MT_ID};
		
		var mt_form = document.createElement('form');
		mt_form.name='mt_form';
		mt_form.method='post';
		mt_form.action="/mt_cancle";
		
		var meeting = document.createElement('input');
		meeting.setAttribute('type','hidden');
		meeting.setAttribute('name','mt_id');
		meeting.setAttribute('value',mt_id);
		
		mt_form.appendChild(meeting);
		document.body.appendChild(mt_form);
		mt_form.submit();
	})
	
	$("#modify").click(function(){
		var mt_id = ${meeting.MT_ID};
		
		var mt_form = document.createElement('form');
		mt_form.name='mt_form';
		mt_form.method='post';
		mt_form.action="/mt_modify";
		
		var meeting = document.createElement('input');
		meeting.setAttribute('type','hidden');
		meeting.setAttribute('name','mt_id');
		meeting.setAttribute('value',mt_id);
		
		mt_form.appendChild(meeting);
		document.body.appendChild(mt_form);
		mt_form.submit();
	})
})
</script>
<title>일정 신청</title>
</head>
<body>
	<div class="image_logo">
		<img class="logo" src="/resources/join/logo.png" alt="로고">
	</div>
	<div class="meeting_area">
		<div class="title_div">
			<span class="title">일정 정보</span>
		</div>	
			<input type="hidden" id="mt_id" value="${meeting.MT_ID}" readonly>
		<div class="line">
			<label>일정 이름</label>
			<input type="text" class="input_area" value="${meeting.MT_NAME}" readonly>
		</div>
		<div class="line" style="display:inline-block">
			<label>일정 설명</label>
			<input type="text" class="input_area" value="${meeting.MT_DS}" readonly>
		</div>
		<div class="line">
			<label>장 소</label>
			<input type="text" class="input_area" value="${meeting.MT_AD}" readonly>
		</div>
		<div class="line">
			<label>시작 시간</label>
			<input type="text" class="input_area" value="${meeting.calcSdate()}" readonly>
		</div>
		<div class="line">
			<label>종료 시간</label>
			<input type="text" class="input_area" value="${meeting.calcFdate()}" readonly>
		</div>
		<div class="line">
			<label>모집 인원</label>
			<input type="number" class="input_area" value="${meeting.MT_P}" readonly>
		</div>
		<div>
			<label>신청 인원</label>
			<input type="number" class="input_area" value="${meeting.a_people}" readonly>
		</div>
		
	</div>
	<div class="button_area">
		<c:if test="${applyCheck eq null}">
			<c:if test="${meeting.a_people lt meeting.MT_P }">
				<button type="button" id="apply" class="button1">참가</button>
			</c:if>
		</c:if>	
		<c:if test="${applyCheck == 'true' }">
			<c:if test="${ masterCheck == 'true'}">
				<button type="button" id="modify" class="button1">수정</button>
			</c:if>
			<c:if test="${ masterCheck == 'false'}">
				<button type="button" id="cancle" class="button1">취소</button>
			</c:if>
		</c:if>
	</div>
	
</body>
</html>