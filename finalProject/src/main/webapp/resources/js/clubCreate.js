// 페이징 클릭시
$('.paging a').on('click', function(){
	var index =  $(this).index();
	$('.wrap_con .con').removeClass('on');
	$('.wrap_con .con').eq(index).addClass('on'); // 해당 내용 보임
	$('.paging a').removeClass('on');
	$(this).addClass('on'); // 불 들어옴
});

var nowIdx = 0; // 현재 페이지

// 기본 함수
function show(i) { 
	nowIdx = i; // 클릭횟수
	var j = i * 3; // 클릭해서 넘어간 1번째 페이지
	$('.paging a').removeClass('on view');
	$('.paging a').eq(j).addClass('on'); // 클릭해서 넘어간 1번째 페이징 불
	$('.paging a').eq(j).addClass('view'); // 클릭해서 넘어간 페이징 3개 보임
	$('.paging a').eq(j+1).addClass('view');
	$('.paging a').eq(j+2).addClass('view');
	$('.wrap_con .con').removeClass('on');
	$('.wrap_con .con').eq(j).addClass('on'); // 클릭해서 넘어간 1번째 페이지 해당 내용 보임
}

// 페이징 123일때 함수
function showFirst() { 
	$('.paging a').removeClass('view');
	$('.paging a').eq(0).addClass('view'); // 페이징 3개 보임 (불 처리 안함)
	$('.paging a').eq(1).addClass('view');
	$('.paging a').eq(2).addClass('view');
}

// 페이징 마지막일때 함수
function showLast(i) { 
	nowIdx = i; // 클릭횟수
	var j = i * 3; // 클릭해서 넘어간 1번째 페이지
	$('.paging a').removeClass('view');
	$('.paging a').eq(j).addClass('view'); // 페이징 마지막 3개 보임 (불 처리 안함)
	$('.paging a').eq(j+1).addClass('view');
	$('.paging a').eq(j+2).addClass('view');
}

var total =  $('.paging a').length;
var result = parseInt(total/3); // 3페이징씩 몇개인지

$('.next').on('click', function(){ // 다음버튼 클릭시
	var viewIdx = nowIdx + 1; // 현재 클릭수 = 이전 클릭수 + 1
	if(viewIdx > result){ // 마지막 페이지인데 다음버튼 클릭하면 (클릭수 초과)
		viewIdx = result; // 계속 마지막 페이지이게
		showLast(viewIdx); // 마지막 페이지 함수 실행
	} else {show(viewIdx);} // 마지막 페이지 아니면 기본 함수 실행
	
});

$('.prev').on('click', function(){ // 이전버튼 클릭시
	var viewIdx = nowIdx - 1; // 현재 클릭수 = 이전 클릭수 -1
	if(viewIdx < 0){ // 첫번째 페이지인데 이전버튼 클릭하면 (클릭수 음수)
		viewIdx = 0; // 계속 첫번째 페이지이게
		showFirst(); // 첫번째 페이지 함수 실행
	} else {show(viewIdx);} // 첫번째 페이지 아니면 기본 함수 실행
	
});

$('.first').on('click', function(){
	show(0);
});

$('.last').on('click', function(){
	show(result);
	$('.paging a').removeClass('on');
	$('.paging a').last().addClass('on');
});