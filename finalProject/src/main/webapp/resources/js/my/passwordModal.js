
// 1번: 비밀번호 확인 , 2번: 비밀번호 변경 모달창 크아앙
// profile.jsp 비밀번호에서 변경 클릭: 1번 열기
$('#modalPw').click(function () {
	$('#pwCheck').fadeIn();
});

    $('#ConfirmPw').click(function () {
    	var inputPw = $('.inputPw').val();
        if(inputPw === '') {
            $('#inputErr').show();
			$('#inputErr').text('비밀번호를 입력하세요.');
			return;
        }
        $.ajax ({
            url: "/profile.pwCheck",
            type: "POST",
            data: {inputPw: inputPw},
            success: (function(result) {
                    if(result == "no") {
                        $('#inputErr').show();
						$('#inputErr').text('등록된 비밀번호와 다르오니 다시 입력바랍니다.');
						alert("등록된 비밀번호와 다르오니 다시 입력바랍니다.");
                    } else if(result == "go") {
                        alert("비밀번호 확인완료!");
                        $('#pwUpdate').fadeIn();
                        $('#pwCheck').fadeOut();
                    }
                })
            });
    });

	// 2번: 새로운 비밀번호(유효성검사) + 비밀번호 확인을 통과한 비밀번호를 컨트롤러에 전달하여 db에 저장한다.
	// 오류 발생! 이 코드로 실행 시 뭘 넣던지(혹은 안넣어도) 3번 째 if문 출력과 함께 새로운(re_pw)비밀번호가 변경됨.
	$('#Confirm').click(function() {
		var pw_chk = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/
		var re_pw = $('#re_enterPw').val();
		var re_pwchk = $('#pwCheck1').val();
		var err = $('#Error');
		console.log(re_pw + "|" + re_pwchk);
		if(re_pw === "" || re_pwchk === "") {
			err.show()
			err.css('color','red')
			err.text('비밀번호를 입력하세요.')
			alert("비밀번호를 입력하세요.");
			$('#re_enterPw').focus();
			return;
		}
		if(!pw_chk.test(re_pw)) {
			err.show()
			err.css('color','red')
			err.text('비밀번호는 알파벳과 숫자와 특수문자를 포함, 8자리 이상이어야 합니다.');
			alert("비밀번호 형식이 옳바르지 않습니다.");
			$('#re_enterPw').focus();
			return;

		}
		if(re_pwchk !== re_pw) {
			err.show()
			err.css('color','red')
			err.text('비밀번호가 일치하지 않습니다.');
			alert("비밀번호가 일치하지 않습니다.");
		}
		$.ajax ({
             url: "/profile.pwUpdate",
             type: "POST",
             data: {re_pw: re_pw},
             success: function(data) {
				if(data == 0) {
					alert("[실패] 비밀번호를 다시 확인해주세요.");
					return;
				}
				alert("[성공] 비밀번호 변경이 완료되었습니다.");
			 	$("#pwupdateForm").submit();
				location.href="/profile";
			}
		});
	});
	
					
					
	$('#btCancelPw').click(function () {
		$('#pwUpdate').fadeOut();
		location.reload();
		});
	$('#btCancelPwCheck').click(function () {
		$('#pwCheck').fadeOut();
		location.reload();});
