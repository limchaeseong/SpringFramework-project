<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path }/resources/css/header.css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function Chat(){
		if(document.getElementById("mychat").style.display==="block") {
			document.getElementById("mychat").style.display="none";
		} else {
			document.getElementById("mychat").style.display="block";
		}
	}
	$(document).ready(function(){
		$(".chatMenu").click(function(){
			var name = $(this).text();
			var no = $(this).next().val();
			window.open("","chatting",'width=700px,height=800px,scrollbars=yes');
			$('#c_name').val(name);
			$('#c_no').val(no);
			console.log($('#c_name').val());
			var chatForm = document.cForm;
			chatForm.action="/chat2";
			chatForm.method="post";
			chatForm.target="chatting";
			chatForm.submit();
		})
	})
</script>
</head>
<body>
<header id="header">
	<div class="inner">
		<!-- 로고 -->
		<a href="/"><div class="logoBox"></div></a>
		<!-- 검색창 -->
		<form action="./search" method="post">
		<div class="searchBox">
			<input type="hidden" />
			<input type="text" class="s_input" name="keyword" id="search_input" autocomplete="off"
				placeholder="모임, 게시글 검색" title="모임, 게시글 검색"/>
			<button type="submit" class="s_btn" id="search_btn">검색</button>
		</div>
		</form>
		<!-- 위젯 -->
		<c:choose>
			<c:when test="${sessionScope.logined ne null}">
				<!-- 로그인 후 위젯 -->
				<ul class="widget">
					<!-- 채팅 -->
					<li class="chat">
						<button id="chatbtn" onclick="Chat();">채팅</button>
						<ul class="info" id="mychat" style="display:none">
							<c:forEach var="c_room" items="${sessionScope.c_list }">
								<li class="chatMenu">
									${c_room.getC_NAME() }
								</li>
								<input type="hidden" value="${c_room.getC_ID() }">
							</c:forEach>
						</ul>
					</li>
					<!-- 프로필 메뉴 -->
					<li class="setting">
						<button id="test" onclick="openClose();">
						<span>
						<img src="<c:out value ="${photo}" default="${sessionScope.account.a_photo}"/>" id="myPhotoH" onerror="this.src='/resources/img/my/photoNoNo_W.png'"/>
						</span>
						</button>
						<ul class="info" id="myLayer" style="display:none">
							<li class="infoMenu"><a href="./profile">내 정보</a></li>
							<li class="infoMenu"><a href="./post">내가 쓴 글</a></li>
							<li class="infoMenu"><a href="./logout">로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</c:when>
			<c:otherwise>
				<!-- 로그아웃 위젯 -->
				<ul class="widget">
					<li class="find"><a class="logoutMenus" href="/join">가입</a></li>
					<li class="push"><a class="logoutMenus" href="/login">로그인</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</header>
<form name="cForm">
	<input type="hidden" name="c_no" id="c_no"/>
	<input type="hidden" name="c_name" id="c_name"/>
</form>
<script src="${path }/resources/js/header.js"></script>
</body>
</html>