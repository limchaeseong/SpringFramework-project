<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글/좋아요</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Font+Name">
<link type="text/css" rel="stylesheet" href="/resources/css/commentView/commentView.css">
<style type="text/css">
	.b_content p img {
		width: 100%!important;
	}
	
	p {
		margin: 5px;
	}
</style>
</head>
<body>
<div class="grid-container-center">
	<div class="all_area">
		<!-- 게시글이 없는 경우 -->
		<c:if test="${postViewDatas.size() == 0}">
		    <!-- 게시글 없는 경우 클릭하면 글쓰기 페이지로 이동하게 해야 됨 -->
	        <div class="centerBox">
	            <span id="nonBoardIcon" class="material-icons">post_add</span>
	            <div class="content1">그룹 게시판</div>
	            <div class="content2">첫 게시글을 작성해보세요!</div>
	        </div>   
		</c:if>
	
		<!-- 게시글 존재 -->
		<c:forEach var="postView" items="${postViewDatas}">
		<div>
			<div class="cy_area1-modalView" onclick="modalOpen(${postView.getB_id()});">
				<!-- 프로필 조회 (사진, 이름, 게시글 작성일/시간 -->
				<div class="grid-layout-Profile">
					<div class="grid-left-Profile">
						<c:choose>
							<c:when test="${postView.getA_photo() eq null}">
								<span class="NonPhotoView${postView.getB_id()}">사진 없음</span>
							</c:when>
							<c:otherwise>
								<img class="photoView${postView.getB_id()}" alt="X" src="${postView.getA_photo()}" style="width: 20px; height: 20px;">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="grid-top-Profile">${postView.getA_name()}</div>
					<div class="grid-bottom-Profile">${postView.getB_date()}</div>
				</div>
		
				<!-- 게시글 조회 (내용, 사진, 좋아요수, 댓글수, 방문자수) -->
				<div>
					<div class="b_content">${postView.getB_content()}</div>
				
					<!-- 게시글 사진(여러 개일 수도 있음) -->
					<c:forEach var="photo" items="${photoDatas}">
						<c:if test="${postView.getB_id() eq photo.getB_id()}">
							<img class="b_photo" alt="X" src="${photo.getP_name()}">
						</c:if>
					</c:forEach>
				
				</div>
				
				<!-- 좋아요수 -->
				<div class="like">
					<span id="heartIcon${postView.getB_id()}" class="material-icons">favorite_border</span>		
					<span class="likeCount${postView.getB_id()}">${postView.getB_good()}</span>
				</div>
				
				<!-- 댓글수 -->
				<c:set var="i" value="0"></c:set>
				<c:forEach var="commentView" items="${commentViewDatas}">
					<c:if test="${postView.getB_id() eq commentView.getB_id()}">
						<span style="display: none;">${i = i+1}</span>
					</c:if>
				</c:forEach>
				<div class="comm">
	                <span id="cmIcon${postView.getB_id()}" class="material-icons">comment</span>
					<span class="cmCount${postView.getB_id()}">${i}</span>
				</div>
				
				<!-- 방문자수 -->
				<div class="visit">
					<span id="visitIcon" class="material-icons">visibility</span>
					<span class="visitCount${postView.getB_id()}">${postView.getB_people()}</span>
				</div>
			</div>
		
		
			<!-- 버튼 (좋아요 / 댓글쓰기) -->
			<div class="cy_area2-grid-layout-likeCmBtn">
				<!-- 좋아요 버튼 -->
				<div class="grid-left-likeCmBtn">
					<span id="btnHeartIcon" class="material-icons">favorite</span>
					<button class="btn1" type="button" onclick="heartClick(${postView.getB_id()})">좋아요</button>
				</div>
				
				<!-- 댓글쓰기 버튼 -->
				<div class="grid-right-likeCmBtn">
		            <span id="btnCommentIcon" class="material-icons">comment</span>
		            <button class="btn1" type="button" onclick="a(${postView.getB_id()});">댓글쓰기</button>
				</div>
			</div>
		
	
			<!-- 댓글 조회 (프로필 사진, 이름, 댓글 작성일/시간) -->
			<div class="cmViewArea${postView.getB_id()}">
			<c:forEach var="comment" items="${commentViewDatas}">
				<c:if test="${postView.getB_id() eq comment.getB_id()}">
					<div class="cy_area3-grid-layout-comment${postView.getB_id()}">
						<div class="grid-left-comment${postView.getB_id()}">
							<c:choose>
								<c:when test="${comment.getA_photo() eq null}">
									<span class="NonPhotoView${postView.getB_id()}">사진 없음</span>
								</c:when>
								<c:otherwise>
									<img class="photoView${postView.getB_id()}" alt="X" src="${comment.getA_photo()}" style="width: 20px; height: 20px;">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="grid-top-comment">${comment.getA_name()}</div>
						<div class="grid-center-comment">${comment.getCm_content()}</div>
						<div class="grid-bottom-comment">${comment.getCm_date()}</div>
					</div>
				</c:if>
			</c:forEach>
			</div>

		
			<!-- 댓글 작성 (입력칸, 보내기 버튼) -->
			<div class="cy_area4">
				<textarea class="cmwrite${postView.getB_id()}" rows="" cols="30" name="cm_content" placeholder="댓글을 남겨주세요."></textarea>
				<button class="btncmwrite" type="button" onclick="cmWriteClick(${postView.getB_id()});">보내기</button>
			</div>	
		</div>
		
	
		<!-- 모달 창 띄울 내용 -->
		<!-- 프로필 조회 (사진, 이름, 게시글 작성일/시간 -->
		<div id="my_modal${postView.getB_id()}" style="display: none;">
			
			<!-- 닫기 버튼 -->
			<a class="modal_close_btn" style="float: right; font-size: 20px; font-weight: bolder; cursor: pointer;">닫기</a>
			
			<div>
				<div class="cy_area1" onclick="modalOpen(${postView.getB_id()});">
					<!-- 프로필 조회 (사진, 이름, 게시글 작성일/시간 -->
					<div class="grid-layout-Profile">
						<div class="grid-left-Profile">
							<c:choose>
								<c:when test="${postView.getA_photo() eq null}">
									<span class="NonPhotoView${postView.getB_id()}">사진 없음</span>
								</c:when>
								<c:otherwise>
									<img class="photoView${postView.getB_id()}" alt="X" src="${postView.getA_photo()}" style="width: 20px; height: 20px;">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="grid-top-Profile">${postView.getA_name()}</div>
						<div class="grid-bottom-Profile">${postView.getB_date()}</div>
					</div>
			
					<!-- 게시글 조회 (내용, 사진, 좋아요수, 댓글수, 방문자수) -->
					<div>
						<div class="b_content">${postView.getB_content()}</div>
					
						<!-- 게시글 사진(여러 개일 수도 있음) -->
						<c:forEach var="photo" items="${photoDatas}">
							<c:if test="${postView.getB_id() eq photo.getB_id()}">
								<img class="b_photo" alt="X" src="${photo.getP_name()}">
							</c:if>
						</c:forEach>
					</div>
					
					<!-- 좋아요수 -->
					<div class="like">
						<span id="heartIcon${postView.getB_id()}" class="material-icons">favorite_border</span>		
						<span class="likeCount${postView.getB_id()}">${postView.getB_good()}</span>
					</div>
					
					<!-- 댓글수 -->
					<c:set var="i" value="0"></c:set>
					<c:forEach var="commentView" items="${commentViewDatas}">
						<c:if test="${postView.getB_id() eq commentView.getB_id()}">
							<span style="display: none;">${i = i+1}</span>
						</c:if>
					</c:forEach>
					<div class="comm">
		                <span id="cmIcon${postView.getB_id()}" class="material-icons">comment</span>
						<span class="cmCount${postView.getB_id()}">${i}</span>
					</div>
					
					<!-- 방문자수 -->
					<div class="visit">
						<span id="visitIcon" class="material-icons">visibility</span>
						<span class="visitCount${postView.getB_id()}">${postView.getB_people()}</span>
					</div>
				</div>
		
				<!-- 댓글 조회 (프로필 사진, 이름, 댓글 작성일/시간) -->
				<div class="cmViewArea${postView.getB_id()}">
				<c:forEach var="comment" items="${commentViewDatas}">
					<c:if test="${postView.getB_id() eq comment.getB_id()}">
						<div class="cy_area3-grid-layout-comment${postView.getB_id()}">
							<div class="grid-left-comment${postView.getB_id()}">
								<c:choose>
									<c:when test="${comment.getA_photo() eq null}">
										<span class="NonPhotoView${postView.getB_id()}">사진 없음</span>
									</c:when>
									<c:otherwise>
										<img class="photoView${postView.getB_id()}" alt="X" src="${comment.getA_photo()}" style="width: 20px; height: 20px;">
									</c:otherwise>
								</c:choose>
							</div>
							<div class="grid-top-comment">${comment.getA_name()}</div>
							<div class="grid-center-comment">${comment.getCm_content()}</div>
							<div class="grid-bottom-comment">${comment.getCm_date()}</div>
						</div>
					</c:if>
				</c:forEach>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>	
</div>
</body>
<script type="text/javascript" src="/resources/join/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/commentView/commentView.js"></script>
</html>