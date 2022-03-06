<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/resources/css/metting/calendar.css">
<!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      locale : "ko",
	      editable : false,
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
</script>
<style>

</style>
<meta charset="UTF-8">
<title>일정(댤력)</title>
</head>
<body>
	<div id='button_area'><button type="button" class="button1" onclick="location.href='/blank';">창닫기</button></div>
    <div id='calendar'></div>
</body>
</html>