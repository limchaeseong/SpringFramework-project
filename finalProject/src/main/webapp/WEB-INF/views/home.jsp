<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"/><!-- css 연결 -->
<html>
<head>
	<title>MOYEO</title>
	<link rel="stylesheet" href="${path }/resources/css/home.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400&display=swap" rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp" />
	<section class="myPage">
		<c:choose>
			<c:when test="${not empty sessionScope.clubList}">
				<div class="myClubListArea">
					<div class="mainWrap">
					<header class="head">
						<h2 class="mainTitle">[ 내 모임 목록 ]</h2>
					</header>
					<div class="clubListRegion">
						<ul class="clubList">
							<li class="clubListItem">
								<div class="uCover">
									<div class="clubInner">
										<a href="/category" class="clubCreate">
											<div class="cover">
												<span class="iconcreate"></span>
											</div>
											<div class="clubName">
												<span class="clubText">모임 만들기</span>
											</div>
										</a>
									</div>
								</div>
							</li>
							<c:forEach var="clubclub" items="${clubList}" >
							<li class="clubListItem">
								<div class="uCover">
									<div class="clubInner">
										<a href="/viewDetail?c_id=${clubclub.c_id}" class="clubCreate">
											<div class="ClubCoverImg">
												<span class="coverInner">
													<img src="${clubclub.c_photo}" class="coverImg" />
												</span>
											</div>
											<div class="clubName_">
												<span class="clubText"><c:out value ="${clubclub.c_name}"/></span>
												<span class="member">개설일 : <c:out value ="${clubclub.c_sdate}"/></span>
											</div>
										</a>
									</div>
								</div>
							</li>
							</c:forEach>
						</ul>
					</div>
					</div>
				</div>
			</c:when>
			<c:when test="${empty sessionScope.clubList && not empty sessionScope.logined}">
				<div class="myClubListArea">
					<div class="mainWrap">
					<header class="head">
						<h2 class="mainTitle2">지금 모임을 시작하세요!</h2>
					</header>
					<div class="clubListRegion">
						<ul class="clubList">
							<li class="clubListItem">
								<div class="uCover">
									<div class="clubInner">
										<a href="/category" class="clubCreate">
											<div class="cover">
												<span class="iconcreate"></span>
											</div>
											<div class="clubName">
												<span class="clubText">모임 만들기</span>
											</div>
										</a>
									</div>
								</div>
							</li>
						</ul>
					</div>
					</div>
				</div>			
			</c:when>
			<c:when test="${sessionScope.logined eq null}">
				<div class="logoutMenu">
					<div class="logoImg"></div>
					<h3 class="logoutTitle"> 모임을 위한 공간, 모여!</h3>
					<div class="logoutText">모여는 멤버와 함께 하는 공간입니다.<br>동호회, 스터디, 주제별 모임을 모여에서 시작하세요.</div>
				</div>
			</c:when>
		</c:choose>
	</section>
<div style="background-color:#e4edf2; max-width:1100px; margin:auto; padding-top:10px">
	<div style="width:1000px; margin:auto; margin-top:20px;">
		<span style="display:block; font-size:40px; margin:0 0 10px 30px; font-family: 'Nanum Gothic', sans-serif;">이런 모임은 어떠신가요?</span>
	</div>
	<div style="width:1000px; margin:auto; text-align:center;">
		<c:forEach items="${datas}" var="d">	
			<div style="display:inline-block; width:200px; margin:15px 20px; background-color:#82cbc4;" onclick="view(${d.c_id})">
				<input type="hidden" name="c_id" value="${d.c_id}">
				<img style="display:block; margin:0; width:200; height:180;" alt="" src="${d.c_photo}" width="100%">
				<div style="margin:5px 0; font-family: 'Nanum Gothic', sans-serif; font-size:15px;">${d.c_name}</div>
			</div>
		</c:forEach>
		<c:out value="${path}" /> 
	</div>
</div>
</body>
<script type="text/javascript">
	function view(value) {
		location.href = "./viewDetail?c_id="+value;
	}
</script>
</html>
