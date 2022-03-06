<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<c:set var="photo" value="${myInfo.a_photo}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글 | 모여</title>
<link rel="stylesheet" href="${path }/resources/css/my/comment.css">
</head>
<body>
	<c:import url="../header.jsp" />
	<c:import url="../header.jsp" />
	<div id="container">
		<div id="aside">
			<nav class="sideNav">
				<ul>
					<li class="aside_li"><a class="aside_a" href="./profile">내 정보</a></li>
					<li class="aside_li"><a class="aside_a" href="./post">내가 쓴 글</a></li>
				</ul>
			</nav>
		</div>
		<div class="main">
			<div class="mainBox">
				<h1 class="infoTitle">내가 쓴 글</h1>
				<ul class="list">
					<li class="menu"><a class=".listItem" href="./post">게시글</a></li>
					<li class="menu"><a class=".listItem" href="./comment">댓글</a></li>
				</ul>
			</div>
			<div class="commentBox">
			<ul class="commentList">
				<c:forEach items="${myComment}" var="comment">
				<li class="commentItem">
					<!-- 댓글 링크 (모임으로 Go!) -->
					<a href="/viewDetail?c_id=${comment.b_id}" class="contentLink" target="_blank">
						<div>
						<h2 class="name">
							<strong><c:out value="${comment.a_uid}"/></strong>
							<span>댓글 [<c:out value="${comment.cm_date}"></c:out>]</span>
						</h2>
							<p class="pComment"><c:out value="${comment.cm_content}"/></p>
							<p class="pBody"><c:out value="${comment.b_name}"/></p>
							<p class="pBody"><c:out value="${comment.b_content }" escapeXml="false"/></p>
							<p class="pDate"><c:out value="${comment.b_date}"/></p>
						</div>
					<div class="bandLink">
					<div class="clubBox">
						<div class="clubImage">
							<span class="clubInner"><img class="img" src="<c:out value ="${comment.c_photo}"/>" onerror=""/></span>
						</div>
					</div>
						<span class="clubName"><c:out value="${comment.c_name }"/></span>
					</div>
					</a>
				</li>
				</c:forEach>
			</ul>
			</div>
		</div>
	</div>
</body>
</html>