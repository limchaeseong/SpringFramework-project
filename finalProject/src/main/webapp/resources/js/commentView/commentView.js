console.log('확인');
	
// 좋아요 클릭 시
function heartClick(data) {
	var heartIcon = document.getElementById('heartIcon' + data);	// 하트아이콘
	var likeCount = document.getElementsByClassName('likeCount' + data)[0];	// 하트수
	
	if(heartIcon.innerText === 'favorite_border') {
		$.ajax({
			url: "./likeCount",
			type: "get",
			data: {
				b_id : data
			},
			success: function(data) {
				console.log(data);
				
				heartIcon.innerText = 'favorite';
				heartIcon.style.color = 'red';
				
				likeCount.innerText = data;
			}
			
		})
	} else {
		console.log('이미 꽉!!!!!!!');
		alert('이미 좋아요를 눌렀습니다!');
	}
	
}

// 댓글작성 보내기 클릭시 
function cmWriteClick(data) {
	var area = document.getElementsByClassName('cmViewArea' + data)[0];	// 댓글조회 영역
	var cmCount = document.getElementsByClassName('cmCount' + data)[0];	// 댓글수
	var cmWrite = document.getElementsByClassName('cmwrite' + data)[0];	// 댓글작성 내용		
	
	console.log(area);
	console.log(cmCount.innerText);
	console.log(cmWrite.value);
	console.log(data);
	
	$.ajax({
		url: "./commentWrite",
		type: "get",
		data: {
			b_id : data,
			cm_content : cmWrite.value
		},
		success: function(data) {
			console.log(data);
			console.log(data.cm_content);
			
			
			var cy_area3_grid = document.createElement('div');	// 바깥 영역
			var divphotoarea = document.createElement('div');	// 사진 영역
			var spanNonPhoto = document.createElement('span');	// 사진 없을 때
			var imgPhoto = document.createElement('img');		// 사진 존재
			var divName = document.createElement('div');		// 이름
			var divContent = document.createElement('div');		// 댓글내용
			var divDate = document.createElement('div');		// 작성일
			
			
			// 바깥 영역
			cy_area3_grid.className = 'cy_area3-grid-layout-comment' + data.b_id;
			
			// 사진 영역
			divphotoarea.className = 'grid-left-comment' + data.b_id;
			
			// 프로필 사진
			if(data.a_photo != null) {
				imgPhoto.className = 'photoView' + data.b_id;
				imgPhoto.src = data.a_photo;
			} else {
				spanNonPhoto.className = 'NonPhotoView' + data.b_id;
			}
			
			// 이름
			divName.className = 'grid-top-comment';
			divName.innerText = data.a_name;
			
			// 댓글 내용
			divContent.className = 'grid-center-comment';
			divContent.innerText = data.cm_content;
			
			// 댓글 작성일
			divDate.className = 'grid-bottom-comment';
			divDate.innerText = data.cm_date;
			
			area.append(cy_area3_grid);
			cy_area3_grid.append(divphotoarea, divName, divContent, divDate);
			
			if(data.a_photo != null) {
				divphotoarea.append(imgPhoto);
			} else {
				divphotoarea.append(spanNonPhoto);
			}
			
			cmWrite.value = '';
			
			cmCount.innerText = Number(cmCount.innerText) + 1;
		}
		
	})
}

// 게시글 클릭 시 모달창 열기
function modalOpen(data) {
	var body = document.getElementsByTagName('body')[0];
	body.style.overflow = 'hidden';
	body.style.marginRight = 'scrollBarWidth';
	
	// 모달창 열면 댓글 작성내용 삭제ㅜㅜ
	var cmWrite = document.getElementsByClassName('cmwrite' + data)[0];	// 댓글작성 내용
	cmWrite.value = '';
	
	modal('my_modal' + data);
	
	// 게시들 클릭 시 방문수 +1
	var visitCount = document.getElementsByClassName('visitCount' + data)[0];	// 하트수
	
	$.ajax({
		url: "./visitCount",
		type: "get",
		data: {
			b_id : data
		},
		success: function(data) {
			console.log(data);
			
			visitCount.innerText = data;
		}
		
	})
}

function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);
    
    
    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function() {
    	var body = document.getElementsByTagName('body')[0];
    	
        bg.remove();
        modal.style.display = 'none';
        body.style.overflow = 'scroll';
    });

    modal.setStyle({
    	width: '700px',
    	margin: '10px 0',
    	padding: '20px 10px',
    	backgroundColor: 'white',
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 스크롤 동작
        maxHeight: '100%',
        overflowY: 'auto',
        
        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}


//Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function(styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};

