$(document).ready(function(){
    // 성별
    $('#btGender').click(function(){
        $('#itemOneG').css('display','none');
        $('#itemTwoG').css('display','flex');
    });
    $('#btCancelG').click(function(){
        $('#itemOneG').css('display','flex');
        $('#itemTwoG').css('display','none');
    });
    // ajax로 회원정보 수정(update) : 성별
    $('#ConfirmG').click(function(){
	var gender = $('input[name=a_gender]:checked').val();
		if(!$('.gender').is(':checked')) {
			alert("성별을 선택해주세요.");
		} else {
		    $.ajax({
		        url : "/profile.genderUpdate",
		        type: "GET",
		        data : {"gender": gender},
		        success: function() {
		            alert("요청하신 내용으로 변경되었습니다.");
		            document.location.reload();
		        }
		    });
		}
    });

    // 생년월일
    $('#btBirthday').click(function(){
        $('#itemOneB').css('display','none');
        $('#itemTwoB').css('display','flex');
    });
    $('#btCancelB').click(function(){
        $('#itemOneB').css('display','flex');
        $('#itemTwoB').css('display','none');
    });
   	$('#ConfirmB').click(function(){
	var bdate = $('.a_bdate').val();
		if((bdate === '')) {
			alert("생년월일을 입력해주세요.");
		}
	    $.ajax({
	        url : "/profile.birthUpdate",
	        type: "POST",
	        data : {"bdate": bdate},
	        success: function() {
	            alert("요청하신 내용으로 변경되었습니다.");
	            document.location.reload();
	      }
	    });
    });

    // 이메일
    $('#btEmail').click(function(){
        $('#itemOneE').css('display','none');
        $('#itemTwoE').css('display','flex');
    });
    $('#btCancelE').click(function(){
        $('#itemOneE').css('display','flex');
        $('#itemTwoE').css('display','none');
    });
	 	$('#ConfirmE').click(function(){
		var email = $('#a_email').val();
		var email_chk = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/
			console.log(email);
			if(email === '') {
				alert("이메일을 입력해주세요.");
				$('#a_email').focus();
				return;
			} 
			if(!email_chk.test(email)){
				alert("이메일 주소를 다시 확인해주세요.");
				$('#a_email').focus();
				return;
			}
		    $.ajax({
			    url : "/profile.emailUpdate",
			    type: "POST",
			    data : {email: email},
			    success: function() {
				    alert("요청하신 내용으로 변경되었습니다.");
				    document.location.reload();
		            }
		        });
    	});


    // 휴대폰
    $('#btPhone').click(function(){
        $('#itemOneP').css('display','none');
        $('#itemTwoP').css('display','flex');
    });
    $('#btCancelP').click(function(){
        $('#itemOneP').css('display','flex');
        $('#itemTwoP').css('display','none');
    });
   	$('#ConfirmP').click(function(){
	var phone_check = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/
	var phone = $('.a_phone').val();
		if((phone === '')) {
			alert("휴대폰 번호를 입력해주세요.");
			$('.a_phone').focus();
			return;
		}
		if(!phone_check.test(phone)){
			alert("휴대폰 번호를 올바르게 입력해주세요.");
			$('.a_phone').focus();
			return;
		}
	    $.ajax({
	       url : "/profile.phoneUpdate",
	       type: "POST",
	       data : {"phone": phone},
	       success: function() {
	            alert("요청하신 내용으로 변경되었습니다.");
	            document.location.reload();
	            }
	        });
    });

    // 주소
    $('#btAd').click(function(){
        $('#itemOneA').css('display','none');
        $('#itemTwoA').css('display','flex');
    });
    $('#btCancelA').click(function(){
        $('#itemOneA').css('display','flex');
        $('#itemTwoA').css('display','none');
    });
    $('#ConfirmA').click(function(){
	var a_ad = $('.a_ad').val();
	var ad2 = $('.a_ad_detail').val();
		if(a_ad === '' || ad2 === null) {
			alert("주소를 입력하세요.");
			ad2.focus();
		}
	var ad = a_ad + ad2;
	
	        $.ajax({
	            url : "/profile.adUpdate",
	            type: "POST",
	            data : {"ad": ad},
	            success: function() {
	                alert("요청하신 내용으로 변경되었습니다.");
	                document.location.reload();
	            }
	        });

    });
});
