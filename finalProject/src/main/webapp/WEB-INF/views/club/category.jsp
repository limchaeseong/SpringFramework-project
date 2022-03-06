<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url var="catePhoto" value="resources/img/club/" />
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/club/category.css" rel="stylesheet">
<title>모임 만들기</title>
</head>
<body class="body">
	<c:import url="../header.jsp" />
	<div class="cateBody">
		<h2 class="title">만들고 싶은 모임을 선택하세요.</h2>
		<label class="desc">모여는 멤버들과 함께 하는 공간입니다.</label>
		<ul class="list">
			<li class="cateItem">
				<span class="cateType" id="cg_id1" onclick="cateSelect(id)">
					<img alt="취미,동호회" src="${catePhoto}camera.png">
					<input type="hidden" name="cg_id1" value="1">
					<label class="cateName">취미, 동호회</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id2" onclick="cateSelect(id)">
					<img alt="가족" src="${catePhoto}family.png">
					<input type="hidden" name="cg_id2" value="2">
					<label class="cateName">가족</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id3" onclick="cateSelect(id)">
					<img alt="학교, 동아리" src="${catePhoto}school.png">
					<input type="hidden" name="cg_id3" value="3">
					<label class="cateName">학교, 동아리</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id4" onclick="cateSelect(id)">
					<img alt="운동 모임" src="${catePhoto}sport.png">
					<input type="hidden" name="cg_id4" value="4">
					<label class="cateName">운동 모임</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id5" onclick="cateSelect(id)">
					<img alt="온라인 클래스" src="${catePhoto}online.png">
					<input type="hidden" name="cg_id5" value="5">
					<label class="cateName">온라인 클래스</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id6" onclick="cateSelect(id)">
					<img alt="회사, 팀" src="${catePhoto}company.png">
					<input type="hidden" name="cg_id6" value="6">
					<label class="cateName">회사, 팀</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id7" onclick="cateSelect(id)">
					<img alt="게임" name="cg_id" id="7" src="${catePhoto}game.png">
					<input type="hidden" name="cg_id7" value="7">
					<label class="cateName">게임</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id8" onclick="cateSelect(id)">
					<img alt="스터디" name="cg_id" id="8" src="${catePhoto}study.png">
					<input type="hidden" name="cg_id8" value="8">
					<label class="cateName">스터디</label>
				</span>
			</li>
			<li class="cateItem">
				<span class="cateType" id="cg_id0" onclick="cateSelect(id)">
					<img alt="직접 만들기" src="${catePhoto}plus.png" class="imgPlus" >
					<input type="hidden" name="cg_id0" value="0">
					<label class="cateName">직접 만들기</label>
				</span>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
	function cateSelect(id) {
		var cg_id = document.getElementsByName(id)[0].value;
		location.href="/create?cg_id="+cg_id;
	}
	</script>
</body>
</html>