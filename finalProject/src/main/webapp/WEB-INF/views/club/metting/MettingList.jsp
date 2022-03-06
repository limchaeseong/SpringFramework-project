<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 리스트</title>
<link href="resources/css/metting/MettingList.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<script type="text/javascript">
	function schedule(){
		window.open("/schedule","meeting",'width=700px,height=800px,scrollbars=yes');
	}
	
	document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          locale : "ko",
          events: [
        	  <c:forEach var="metting" items="${MettingList}">
        	  {
        		  title : ${metting.cutMT_NAME()},
        		  start : ${metting.cutSdate()},
        		  end : ${metting.cutFdate()}
        		  
        	  },
        	  </c:forEach>
        	  {
        		  title : 'event1'
        	  }
          ]        
        });
        calendar.render();
      });
	
	$(document).ready(function(){
		$(".m_info").click(function(){
			var tr = $(this);
			var td = tr.children();

			window.open("","metting",'width=700px,height=800px,scrollbars=yes');
			
			var m_no = td.eq(0).text();
			console.log(m_no);
			
			var m_form = document.createElement('form');
			m_form.name='m_form';
			m_form.method='post';
			m_form.action="/m_detail";
			m_form.target="metting";
			
			var metting = document.createElement('input');
			metting.setAttribute('type','hidden');
			metting.setAttribute('name','m_no');
			metting.setAttribute('value',m_no);
			m_form.appendChild(metting);
			document.body.appendChild(m_form);
			m_form.submit();
			
		})
	})
</script>
<style>
	*{
		margin:0;
		padding:0;
	}
</style>
</head>
<body class="viewBody">
	<c:import url="../header.jsp" />
	<aside>
		<div>
			<div>
				<span>
					<a href="./listDetail?c_id=${club.c_id}">
						<img alt="" src="${club.c_photo}" width="208" height="157">
					</a>
				</span>			
			</div>
			<div><a class="clubName" href="./listDetail?c_id=${club.c_id}">${club.c_name}</a></div>
			<p class="memberName">
				<span>멤버 ${mCount} · </span>
				<span>${avo.a_name}</span>
			</p>
			<c:set var="name" value="${ap.ap_state}"/>
			<c:choose>
				<c:when test="${fn:contains(name, 'Y')}">
				</c:when>
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
	<main>
	
		<c:set var="name" value="${ap.ap_state}"/>
		<c:choose>
			<c:when test="${fn:contains(name, 'Y')}">
				<div></div>
			</c:when>
			<c:otherwise>	
				<div>
					<h4>모임 소개</h4>
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
				<div>게시판</div>
				<a href="/mettingList">일정 보기</a>
				<div id='calendar'></div>
				<div id="buttonDiv">
					<button class="button1" style="width:100%" onclick="schedule();">일정 만들기</button>
				</div>
				<div id="m_div">
				<table class="mt_table">
					<tr class="title">
						<th>No</th>
						<th>일정 이름</th>
						<th>시작</th>
						<th>종료</th>
						<th>인원(신청/정원)</th>
					</tr>
					<c:forEach var="metting" items="${MettingList}">
					<tr class="m_info">
						<td>${metting.MT_ID}</td>
						<td>${metting.MT_NAME}</td>
						<td>${metting.MT_SDATE}</td>
						<td>${metting.MT_FDATE}</td>
						<td>${metting.a_people}/${metting.MT_P}</td>
					</tr>	
					</c:forEach>
				</table>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</main>		

	
</body>
</html>