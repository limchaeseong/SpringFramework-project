<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.home.club.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/club/member.css" rel="stylesheet">
<title>모임</title>
<style>
.modal{
  margin-top:2em;
}
</style>
</head>
<c:import url="../header.jsp" />
<body class="viewBody"> 
	<form action="./view" method="post">
	<aside>
		<div>
			<div>
				<span>
					<a href="./viewDetail?c_id=${club.c_id}">
						<img alt="" src="${club.c_photo}" width="208" height="157">
					</a>
				</span>			
			</div>
			<div><a class="clubName" href="./viewDetail?c_id=${club.c_id}">${club.c_name}</a></div>
			<p class="memberName">
				<span>멤버 ${mCount} · </span>
				<span>${avo.a_name}</span>
			</p>
			<c:set var="name" value="${ap.ap_state}"/>
			<c:choose>
			<c:when test="${fn:contains(name, 'Y')}">
				<c:set var="discription" value="${club.c_discription}"/>
					<c:choose>
						<c:when test="${empty discription}">
							<c:choose>
								<c:when test="${yN eq 'Y'}">
									<div class="memberName">
										<a onclick="showPopUp();">모임 소개 설정 ></a>
									</div>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
							<div >
								<p class="memberName">${club.c_discription}</p>
							</div>
						</c:otherwise>
					</c:choose>
			</c:when>
			<c:otherwise>
			<div class="btnBox">
				<button type="submit" class="joinBtn">모임 가입하기</button>
			</div>
			</c:otherwise>
			</c:choose>
			<div class="openText">
				<c:set var="name" value="${club.c_open}"/>
				<c:choose>
					<c:when test="${fn:contains(name, 'Y')}">
						<p><small>누구나 모임을 검색으로 찾을 수 있고, 모임 소개와 게시글을 볼 수 있습니다.</small></p>
					</c:when>
					<c:otherwise>
						<p><small>누구나 밴드를 검색으로 찾아 밴드 소개를 볼 수 있지만, 게시글은 멤버만 볼 수 있습니다.</small></p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</aside>
	</form>
	<main>
		<c:set var="name" value="${ap.ap_state}"/>
		<c:choose>
			<c:when test="${fn:contains(name, 'Y')}">
				<div class="menu_btn_area">
					<button id="menu_btn1" onclick="location.href='./viewDetail?c_id=${club.c_id}'">게시글</button>
					<button id="menu_btn2" onclick="location.href='./viewMetting?c_id=${club.c_id}'">일정</button>
					<button id="menu_btn3" onclick="location.href='./member'">멤버관리</button>
				</div>
		<div class="memCount">
		<h4 class="memText">멤버</h4>
		<label class="memNum">&nbsp; ${mCount}</label>
		</div>	
	<div>
		<div>
			<c:choose>
				<c:when test="${yN eq 'Y'}">
					<c:forEach items="${manager}" var="m">
						<ul class="memUl">
							<li class="memLi">
								<div class="profileImg">
									<img class="profileImg" alt="" src="${m.a_photo}">
								</div>
								&nbsp; ${m.a_name} &nbsp; 모임장
								<button class="setBtn" id="modify" value="${m.a_id}" onclick="showPopUp(value)">설정</button>
							</li>
						</ul>
					</c:forEach>
					<c:forEach items="${lDto}" var="a">
						<ul class="memUl">
							<li class="memLi">
								<div class="profileImg">
									<img alt="" src="${a.a_photo}">
								</div>
								&nbsp; ${a.a_name}
								<button class="setBtn" id="modify" value="${a.a_id}" onclick="showPopUp(value)">설정</button>
							</li>
						</ul>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach items="${aDto}" var="aId">
						<ul class="memUl">
							<li class="memLi">
								<div class="profileImg">
								 	<img  class="profileImg" alt="" src="${aId.a_photo}">
								</div>
								&nbsp; ${aId.a_name}
								<button id="modify" value="${aId.a_id}" onclick="showPopUp(value)">설정</button>
							</li>
						</ul>
					</c:forEach>
					<c:forEach items="${manager}" var="m">
						<ul class="memUl">
							<li class="memLi">
								<div class="profileImg">
									<img class="profileImg" alt="" src="${m.a_photo}">
								</div>
								&nbsp; ${m.a_name} &nbsp; 모임장
							</li>
						</ul>
					</c:forEach>
					<c:forEach items="${lDto}" var="a">
						<ul class="memUl">
							<li class="memLi">
								<div class="profileImg">
									<img class="profileImg" alt="" src="${a.a_photo}">
								</div>
								&nbsp; ${a.a_name}
							</li>
						</ul>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
			</c:when>
			<c:otherwise>
			<div>
				<h4>모임 소개</h4>
				<div>
					<p>${club.c_discription}</p>
				</div>
			</div>
			<div>
				<p class="cateName">${cgName.cg_name}</p>
			</div>
			<div>
				<p>이 모임의 활동 정보</p>
				<p>개설일 ${club.c_sDate}</p>
			</div>
			<div>
				<div>
					<img alt="" src="">
					<p>멤버만 볼 수 있습니다.</p>
					<p>모임에 가입해보세요!</p>
				</div>
			</div>
			</c:otherwise>
		</c:choose>
		<c:set var="name" value="${club.c_open}"/>
		<c:choose>
			<c:when test="${fn:contains(name, 'Y')}">

			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</main>
	<script type="text/javascript"> 
	function showPopUp(value) { 
		//창 크기 지정 
		var width = 320; 
		var height = 360; 
		//pc화면기준 가운데 정렬 
		var left = (window.screen.width / 2) - (width/2); 
		var top = (window.screen.height / 4); 
		//윈도우 속성 지정 
		var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes'; 
		//연결하고싶은url 
		var a_id = value;
		const url = "./modify?a_id="+a_id; 
		//등록된 url 및 window 속성 기준으로 팝업창을 연다. 
		window.open(url, "hello popup", windowStatus); } 
	</script>
</body>
</html>