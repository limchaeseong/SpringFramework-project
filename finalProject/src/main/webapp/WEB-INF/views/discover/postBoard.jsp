<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/><!-- css 연결 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 검색 | 모여</title>
<link rel="stylesheet" href="${path }/resources/css/discover/postBoard.css">
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
			<h1 class="findTitle"> 게시글 검색결과 : <strong>${keyword}</strong></h1>
			<ul class="searchList">
				<c:choose>
				<c:when test="${not empty sessionScope.postBoard}">
				<c:forEach var="board" items="${postBoard}" >
				<li class="searchPostItem">
					<!-- 게시글 링크(모임으로 Go!) -->
					<a href="/viewDetail?c_id=${post.b_id}" class="postGo">
						<div class="clubTextTitle"><c:out value="${board.b_name }"/>제목</div>
						<div class="clubText">
						<c:out value="${board.b_content }" escapeXml="false"/>
						</div>
					<div class="comment">
						<div class="goodArea">
							<span class="good"><img class="img" src="<c:out value ="${path}/resources/img/icon/heart_black.png"/>" onerror=""/></span>
							<span class="goodPoint"><c:out value="${board.b_good }"/></span>
						</div>
						<span class="commentName">댓글</span>
						<span class="commentCount">00</span><!-- 미구현 -->
						<span class="commentDate"><c:out value="${board.b_date }"/></span>
					</div>
					</a>
					<a href="/viewDetail?c_id=${post.b_id}" class="clubGo">
					<div class="clubBox">
						<div class="clubImage">
							<span class="clubInner"><img class="img" src="<c:out value ="${board.c_photo}"/>" onerror=""/></span>
						</div>
						<span class="clubName"><c:out value ="${board.c_name}"/></span>
					</div>
					</a>
				</li>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<li class="searchClubItem">
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