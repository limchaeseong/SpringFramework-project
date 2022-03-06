<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 검색 | 모여</title>
<link rel="stylesheet" href="${path }/resources/css/discover/searchClub.css">
</head>
<body>
	<c:import url="../header.jsp"/>
	<div class="searchMenu">
		<ul class="topMenuArea">
			<li class="topMenuItem">
				<a href="./searchClub" class="topMenuLink">모임</a>
			</li>
			<li class="topMenuItem">
				<a href="./postBoard" class="topMenuLink">게시글</a>
			</li>
		</ul>
	</div>
	<div class="listBack">
	<div class="findList">
		<div class="searchBox2">
			<h1 class="findTitle">모임 검색결과 : <strong>${keyword}</strong></h1>
			<ul class="searchList">
				<c:choose>
				<c:when test="${not empty sessionScope.searchClub}">
				<c:forEach var="club" items="${searchClub}" >
				<li class="searchClubItem">
					<div class="clubListArea">
					<div class="cover">
						<div class="coverImage">
							<span class="coverInner">
							<img class="img" src="<c:out value ="${club.c_photo}"/>" onerror=""/>
							</span>
						</div>
					</div>
					<div class="clubName">
						<div class="name">
							<!-- 모임 주소연결 -->
							<a href="/viewDetail?c_id=${club.c_id}" class="clubGo" target="_blank"><c:out value=""/>${club.c_name}</a>
						</div>
						<p class="culbText"><c:out value="${club.c_discription}"/></p>
						<p class="member">
							<span class="total">이 모임의 <strong><c:out value=""/></strong></span><!-- 멤버 미구현 -->
							<span class="leader">리더 : <strong><c:out value="${club.a_uid }"/></strong></span>
						</p>
					</div>
					</div>
				</li>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<li class="notSearchClubItem">
					<div class="nothing">검색한 결과가 없습니다.</div>
				</li>
				</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	</div>
</body>
</html>