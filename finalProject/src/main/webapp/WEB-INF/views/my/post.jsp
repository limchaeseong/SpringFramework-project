<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글 | 모여</title>
<link rel="stylesheet" href="${path }/resources/css/my/post.css">
</head>
<body>
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
			<div class="contentBox">
				<ul>
					<c:forEach var="post" items="${myPost}" >
					<li class="postBox">
					<h2 class="clubName">
						<a href="/viewDetail?c_id=${post.c_id}" class="clubNameLink" target="_blank">
						<c:out value="${post.c_name}"/>
						</a>
					</h2>
					<div>
						<div class="postAuthor">
							<div class="Photo">
								<img class="img" src="<c:out value ="${post.a_photo}"/>" onerror="this.src='/resources/img/my/photoNoNo_B.png'"/>
							</div>
							<div class="NameDate">
								<span class="postName"><c:out value="${post.a_uid}"/></span>
								<div class="postDate"><c:out value="${post.b_date}"/></div>
							</div>
						</div>
						<div class="postMain">
						<div class="postBody">
						<!-- 게시글 링크(해당 모임으로 Go!) -->
						<a a href="/viewDetail?c_id=${post.c_id}" target="_blank">
							<div class="postText">
								<p class="textBody"><strong><c:out value="${post.b_name}"/></strong></p>
								<p class="textBody"><c:out value="${post.b_content}" escapeXml="false"/></p>
							</div>				
						</div>
						</div>
						<div class="postCount">
							<span class="good">
							<img class="img" src="<c:out value ="${path}/resources/img/icon/heart_black.png"/>" onerror=""/>
							</span>
							<span class="count"><c:out value="${post.b_good }"/></span>
							<span class="comment">댓글</span>
							<span class="count"><c:out value=""/>0</span><!-- 미구현 -->
						</div>	
						<div class="postAdded">
						</div>
						</a>
					</div>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>