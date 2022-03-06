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
<title>회원관리</title>
</head>
<body class="modifyBody">
	<form name="myForm"  action="./modify" method="post" >
		<c:set value="${aDto}" var="a"/>
		<c:set var="c_id" value="${c_id}"/>
		<div class="profileImg2">
			<img class="profileImg2" alt="" src="${a.a_photo}">		
		</div>
		<div class="area">
			<div class="areaText">
				<p>${a.a_name}</p>
			</div>
			<c:choose>
				<c:when test="${yN eq 'Y'}">
					<div>
						<button class="modifyBtn" type="button" onclick="deleteSubmit(${c_id});">모임 삭제</button>
						<button class="modifyBtn" onclick="window.close()">닫기</button>
						<input type="hidden" name="delete" id="delete" value="">
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<button class="modifyBtn" type="button" onclick="goSubmit(${c_id});">모임 탈퇴</button>
						<button class="modifyBtn" onclick="window.close()">닫기</button>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<input type="hidden" name="s_a_id" value="${a.a_id}">
	</form>
</body>
<script>
	function closeMe() {
	    var win=window.open("","_self");
	    win.close();
	}
	
	function goSubmit(c_id) {
	    window.opener.name = "member"; // 부모창의 이름 설정
	    document.myForm.target = "member"; // 타켓을 부모창으로 설정
	    document.myForm.action = "/modify";
	    document.myForm.submit();
	    self.close();
	}
	
	function deleteSubmit(c_id) {
	    window.opener.name = "member"; // 부모창의 이름 설정
	    document.myForm.target = "member"; // 타켓을 부모창으로 설정
	    document.myForm.action = "/modify";
	    document.getElementById("delete").value=="delete";
	    document.myForm.submit();
	    self.close();
	}
</script>
</html>