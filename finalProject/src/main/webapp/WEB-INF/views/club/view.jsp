<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.home.club.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url var="join" value="resources/img/club/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/club/view.css" rel="stylesheet">
<!-- 임채연 시작 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Font+Name">
<link type="text/css" rel="stylesheet" href="/resources/css/commentView/commentView.css">
<!-- 임채연 끝 -->
<title>모임</title>
<style>
.modal{
  margin-top:2em;
}

/* 임채연
.b_content p img {
	width: 100%!important;
	height: auto!important;
}

p {
	margin: 5px;
} */
</style>
</head>
<c:import url="../header.jsp" />
<body class="viewBody"> 
   <form action="./view" method="post">
   <aside>
      <div>
         <div>
            <span>
               <a href="./viewDetail?c_id=${club.c_id}">
                  <img alt="" src="${club.c_photo}" width="208" height="157">
               </a>
            </span>         
         </div>
         <div><a class="clubName" href="./viewDetail?c_id=${club.c_id}">${club.c_name}</a></div>
         <p class="memberName">
            <span>멤버 ${mCount} · </span>
            <span>${avo.a_name}</span>
         </p>
         <c:set var="name" value="${ap.ap_state}"/>
         <c:choose>
         <c:when test="${fn:contains(name, 'Y')}">
            <c:set var="discription" value="${club.c_discription}"/>
               <c:choose>
                  <c:when test="${empty discription}">
                     <c:choose>
                        <c:when test="${yN eq 'Y'}">
                           <div class="memberName">
                              <a onclick="showPopUp();">모임 소개 설정 ></a>
                           </div>
                        </c:when>
                     </c:choose>
                  </c:when>
                  <c:otherwise>
                     <div >
                        <p class="memberName">${club.c_discription}</p>
                     </div>
                  </c:otherwise>
               </c:choose>
         </c:when>
         <c:otherwise>
         <div class="btnBox">
            <button type="submit" class="joinBtn">모임 가입하기</button>
         </div>
         </c:otherwise>
         </c:choose>
         <div class="openText">
            <c:set var="name" value="${club.c_open}"/>
            <c:choose>
               <c:when test="${fn:contains(name, 'Y')}">
                  <p><small>누구나 모임을 검색으로 찾을 수 있고, 모임 소개와 게시글을 볼 수 있습니다.</small></p>
               </c:when>
               <c:otherwise>
                  <p><small>누구나 밴드를 검색으로 찾아 밴드 소개를 볼 수 있지만, 게시글은 멤버만 볼 수 있습니다.</small></p>
               </c:otherwise>
            </c:choose>
         </div>
      </div>
   </aside>
   </form>
   <main>
      <c:set var="name" value="${ap.ap_state}"/>
      <c:choose>
         <c:when test="${fn:contains(name, 'Y')}">
         	<div class="menu_btn_area">
         		<button id="menu_btn1" onclick="location.href='./viewDetail?c_id=${club.c_id}'">게시글</button>
         		<button id="menu_btn2" onclick="location.href='./viewMetting?c_id=${club.c_id}'">일정</button>
         		<button id="menu_btn3" onclick="location.href='./member'">멤버관리</button>
         	</div>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src = "<c:url value="${pageContext.request.contextPath}/ckeditor/ckeditor.js"/>"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <div>
               <img class="write" src="<c:url value="/resources/img/board/boardWrite.png"/>" alt="글쓰기" data-toggle="modal" data-target="#myModal" style="width:540px; border:1px solid light-gray;" />
            </div>
            <div class="modal fade" id="myModal" role="dialog"> 
               <div class="modal-dialog modal-lg" > 
                  <div class="modal-content" style="width:80%; height:70%"> 
                     <div class="modal-header">
                         <h5 class="modal-title">게시판 글쓰기</h5>
                         <div>
                            <button type="button" class="close" data-dismiss="modal" style="position: absolute; right:2em">x</button>
                         </div>
                     </div>
                     <div class="modal-body">
                          <form method = "post" action = "./boardWrite" >
                           <div class="form-group">
                              <input name ="name" id = "title" class="form-control" style="width:100%" placeholder = "글제목을 입력하세요" value="">
                           </div>
                           <textarea id = "description" name = "content" style="width:90%"  placeholder= "글내용을 적어주세요." value=""></textarea> 
                           <div style = "text-align:right;" >
                              <button type = "submit" class="btn btn-primary" name = "submit">게시글쓰기</button>
                           </div>
                        </form>
                     </div>
                     <div class="modal-footer">
                          <p>팝업 footer</p>
                     </div>
                   </div>
                </div>
            </div>
            
            <!-- 게시글 조회 (cy) -->
            <div class="fullarea">
				<div class="all_area">
					<!-- 게시글이 없는 경우 -->
					<c:if test="${postViewDatas.size() == 0}">
						<div class="grid-container-center">
						    <!-- 게시글 없는 경우 클릭하면 글쓰기 페이지로 이동하게 해야 됨ㅜㅜ -->
					        <div class="centerBox">
					            <span id="nonBoardIcon" class="material-icons">post_add</span>
					            <div class="content1">그룹 게시판</div>
					            <div class="content2">첫 게시글을 작성해보세요!</div>
					        </div>   
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
											<span class="NonPhotoView${postView.getB_id()}"></span>
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
												<span class="NonPhotoView${postView.getB_id()}"></span>
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
												<span class="NonPhotoView${postView.getB_id()}"></span>
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
													<span class="NonPhotoView${postView.getB_id()}"></span>
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
			<!-- 게시글 조회 끝 -->
         </c:when>
      <c:otherwise>
			<div class="clubTitle">
				<h4>모임 소개</h4>
				<div class="clubDis">
					<p>${club.c_discription}</p>
				</div>
			</div>
			<div>
				<p class="cateName">${cgName.cg_name}</p>
			</div>
			<div class="clubInfo">
				<p class="infoText">이 모임의 활동 정보</p>
				<p class="infoDate">개설일 ${club.c_sDate}</p>
			</div>
			<div>
				<div class="clubJoin">
					<img class="joinImg" alt="회원가입" src="${join}joinMember.png">
					<p>멤버만 볼 수 있습니다.</p>
					<p>모임에 가입해보세요!</p>
				</div>
			</div>
			<div class="mainHeight">
			</div>
		</c:otherwise>
     </c:choose>
</main>
      <script>   
      $('#myModal').on('hidden.bs.modal', function (e) {
          console.log('modal close');
        $(this).find('form')[0].reset()
      });
      
      $('.write').on('click', function(){
         $('#myModal').modal({backdrop: 'static', keyboard: false});
      });
      
      $('.close').on('click', function(){
         if(confirm('정말 글쓰기 창을 닫으시겠습니까? 작성된 내용은 삭제됩니다.')){
            CKEDITOR.instances.description.setData('');   
         }
      });
      
      CKEDITOR.replace("description",{
          filebrowserUploadUrl : "/boardWrite",
             width : '600px',  
              height : '300px',
              extraPlugins : 'confighelper'
      
      });
      CKEDITOR.config.resize_enabled = false; 
   </script>
   <script type="text/javascript"> 
      function showPopUp() { 
      //창 크기 지정 
      var width = 300; 
      var height = 300; 
      //pc화면기준 가운데 정렬 
      var left = (window.screen.width / 2) - (width/2); 
      var top = (window.screen.height / 4); 
      //윈도우 속성 지정 
      var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes'; 
      //연결하고싶은url 
      const url = "./discription"; 
      //등록된 url 및 window 속성 기준으로 팝업창을 연다. 
      window.open(url, "hello popup", windowStatus); } 
   </script>
</body>
<script type="text/javascript" src="/resources/join/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/commentView/commentView.js"></script>
</html>