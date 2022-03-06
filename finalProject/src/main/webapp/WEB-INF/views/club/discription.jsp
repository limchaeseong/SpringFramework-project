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
<link href="resources/css/club/view.css" rel="stylesheet">
<title>모임 소개</title>
</head>
<body>
	<form name="myForm" action="./discription" method="post">
	<c:set var="c_id" value="${c_id}"/>
		<div>
			<h2>모임 소개</h2>
		</div>
		<div>
		<textarea class="textArea" rows="" cols="" name="c_discription" placeholder="모임 소개말을 입력하세요."></textarea>	
		</div>
		
		<div >
			<button class="discriptionBtn" type="button" onclick="goSubmit(${c_id});">저장</button>
		</div>
	</form>
</body>
<script>
	function goSubmit(c_id) {
	    window.opener.name = "view"; // 부모창의 이름 설정
	    document.myForm.target = "view"; // 타켓을 부모창으로 설정
	    document.myForm.action = "/discription";
	    document.myForm.submit();
	    self.close();
	}
</script>
</html>