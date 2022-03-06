<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path }/resources/css/my/myPhotoModal.css">
</head>
<body>
	<div class="modal_back" id="myPhotoModal">
		<div class="myPhoto_content">
			<header class="myPhoto_header"><h1 class="myPhoto_title">프로필 설정</h1></header>
			<form action="/myPhotoEdit" method="post" enctype="multipart/form-data">
				<div class="myPhoto_body">
					<div class="photoBox">
						<span class="profileLine">
							<img src="${myInfo.a_photo}" class="imgPhoto" onerror="this.src='/resources/img/my/photoNoNo_B.png'"/>
						</span>
					</div>
					<div>
						<input type="file" multiple="multiple" class="inputfile" name="a_photo">
						<span style="font-size: 13px;">[안내] 파일 선택을 눌러 변경할 사진을 선택해주세요.</span>				
					</div>
				</div>
				<div class="myPhoto_footer">
					<button type="submit" class="profileBtn">확인</button>
					<button type="button" class="myCancelBtn">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>