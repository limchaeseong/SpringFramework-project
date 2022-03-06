console.log('외부스크립트 연결');

// 아이디 확인
function u_id() {
	var id = document.getElementsByName('userid')[0];
	var msg = document.getElementById('id_msg');
	
	// 정규식 (영문 대/소문자, 숫자 5~20자)
	var id_chk = /^[A-Za-z0-9]{5,20}$/; 
	
	if(id.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		if(!id_chk.test(id.value)) {
            msg.innerText = '5~20자의 영문 대/소문자와 숫자만 사용 가능합니다.';
        } else {
			msg.innerText = '';	
		}
	}
}

// 비밀번호
function pw() {
	var pw = document.getElementsByName('password')[0];
	var msg = document.getElementById('pw_msg');
	
	// 정규식 (영문 대/소문자, 숫자, 특수문자 반드시 사용 8~20자)
	var pw_chk = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/

	if(pw.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		if(!pw_chk.test(pw.value)) {
            msg.innerText = '8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.';
        } else {
			msg.innerText = '';	
		}
	}
}

// 비밀번호 & 비밀번호 확인
function pw_check() {
	var pw = document.getElementsByName('password')[0];
	var pw_chk = document.getElementsByName('password_chk')[0];
	var msg = document.getElementById('pw_chk_msg');
	
	if(pw_chk.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {		
		if(pw.value !== pw_chk.value) {
			msg.innerText = '비밀번호가 일치하지 않습니다.';
		} else {
			msg.innerText = '';
		}
	}
}

// 이름
function nm() {
	var name = document.getElementsByName('username')[0];
	var msg = document.getElementById('name_msg');
	
	if(name.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		msg.innerText = '';
	}
}

// 생년월일 확인
function birth_chk() {
	var birth = document.getElementsByName('birth')[0];
	var msg = document.getElementById('birth_check_msg');
	
	// 정규식
	var birth_chk = /^(19[0-9][0-9]|20\d{2})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	
	if(birth.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		if(!birth_chk.test(birth.value)) {
            msg.innerText = '생년월일을 다시 확인해주세요.(숫자만 입력해주세요.)';
        } else {
			msg.innerText = '';
		}
	}
}


// 성별
function gen() {
	var gen = document.getElementsByName('gender')[0];
	var msg = document.getElementById('gen_msg');
	
	if(gen.value === '성별') {
		msg.innerText = '성별을 선택하세요.';
	} else {
		msg.innerText = '';
	}
}

// 성별 값 가져와서 select 하기
document.addEventListener("DOMContentLoaded", function(event){
	var gen = document.getElementsByName('gender')[0];
	var gender_check = document.getElementById('gender_check');	// 성별

	// select
	if(gender_check.value === 'M') {
		gen.value = 'M';
	} else if(gender_check.value === 'W') {
		gen.value = 'W';
	}
});

// 주소
function addr() {
	var addr = document.getElementsByName('address_1')[0];
	var msg = document.getElementById('addr_msg');
	
	if(addr.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		msg.innerText = '';
	}
}


// 이메일
function e_mail() {
	var email = document.getElementsByName('email')[0];
	var msg = document.getElementById('email_msg');
	
	// 정규식
	var email_chk = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	
	if(email.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		if(!email_chk.test(email.value)) {
            msg.innerText = '이메일 주소를 다시 확인해주세요.';
        } else {
			msg.innerText = '';	
		}
	}
}

// 휴대전화
function phone() {
	var phone = document.getElementsByName('phone_num')[0];
	var msg = document.getElementById('phone_msg');
	
	// 정규식
	var phone_chk = /^\d{3}\d{3,4}\d{4}$/;
	
	if(phone.value === '') {
		msg.innerText = '필수 정보입니다.';
	} else {
		if(!phone_chk.test(phone.value)) {
            msg.innerText = '휴대전화 번호를 다시 확인해주세요.(숫자만 입력해주세요.)';
        } else {
			msg.innerText = '';
		}
	}
}

// 주소 검색 클릭 시 주소검색 창 띄우기 (주소 검색 버튼을 클릭하면 카카오지도 발생)
function searchMap() {
	new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementsByName('address_1')[0].value = data.address; // 주소 넣기

				// 주소 입력란이 빈칸으로 되어있는 경우, 아닌 경우
				var addr = document.getElementsByName('address_1')[0];
				console.log(addr);
				var msg = document.getElementById('addr_msg');
				
				if(addr.value === '') {
					console.log(addr.value);
					msg.innerText = '필수 정보입니다.';
				} else {
					console.log(addr.value);
					msg.innerText = '';
				}

                document.querySelector("input[name=address_2]").focus(); //상세입력 포커싱
            }
    }).open();


}

// 필수사항 입력이 하나라도 안되어있으면 Submit X
function all_check() {
	var msg = document.getElementById('all_check_msg');
	msg.style.color = 'red';
	msg.style.fontSize = '15px';
	
	if(document.getElementsByName('userid')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;		
	} else if(document.getElementsByName('password')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;		
	} else if(document.getElementsByName('password_chk')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;		
	} else if(document.getElementsByName('username')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;		
	} else if(document.getElementsByName('birth')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;		
	} else if(document.getElementsByName('gender')[0].value === '성별') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;
	} else if(document.getElementsByName('address_1')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;
	} else if(document.getElementsByName('email')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;
	} else if(document.getElementsByName('phone_num')[0].value === '') {
		msg.innerHTML = '필수 정보를 입력해주세요.';
		return false;
	} else if(document.getElementById('emailCheck_msg').innerText !== '인증번호가 일치합니다.') {
		msg.innerHTML = '이메일 인증번호를 다시 확인해주세요.';
		return false;
	} else if(document.getElementById('phoneCheck_msg').innerText !== '인증번호가 일치합니다.') {
		msg.innerHTML = '휴대전화 인증번호를 다시 확인해주세요.';
		return false;
	} else if(document.getElementById('pw_chk_msg').innerText !== '') {
		msg.innerHTML = '비밀번호 재확인을 다시 확인해주세요.';
		return false;
	} else if(document.getElementById('id_msg').innerText === '5~20자의 영문 대/소문자와 숫자만 사용 가능합니다.') {
		msg.innerHTML = '아이디 규칙을 확인해주세요.';
		return false;
	} else if(document.getElementById('pw_msg').innerText === '8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.') {
		msg.innerHTML = '비밀번호 규칙을 확인해주세요.';
		return false;
	} else if(document.getElementById('birth_check_msg').innerText === '생년월일을 다시 확인해주세요.(숫자만 입력해주세요.)') {
		msg.innerHTML = '생년월일을 다시 확인해주세요.';
		return false;
	} else if(document.getElementById('id_check_msg').innerText === '사용 불가능한 아이디 입니다.') {
		msg.innerHTML = '사용 불가능한 아이디입니다. 아이디를 다시 확인해주세요.';
		return false;
	}
	form.submit();
}

var code = '';

// 이메일 버튼 클릭 시 인증번호 발송
function sendEmail() {
    
    var email = document.getElementsByName('email')[0].value;	// 입력한 이메일
	var checkBox = document.getElementById('email_num_chk');	// 인증번호 입력란		  

    $.ajax({
      
        type:"GET",
        url:"./join/mailCheck?email=" + email,
        success:function(data){
            console.log("data : " + data);
			checkBox.disabled = false;
			code = data;
        }
                
    });  
}

// 이메일 인증번호 확인
function e_check() {
	
	var inputCode = document.getElementById('email_num_chk').value;
	var msg = document.getElementById('emailCheck_msg');
	
	if(inputCode === code) {
		msg.innerText = '인증번호가 일치합니다.';
		msg.style.color = 'green';
		msg.style.fontSize = '15px';
	} else {
		msg.innerText = '인증번호를 다시 확인해주세요.';
		msg.style.color = 'red';
		msg.style.fontSize = '15px';
	}
}

// 휴대폰 버튼 클릭 시 인증번호 발송
function sendPhone() {
    
    var phone = document.getElementsByName('phone_num')[0].value;	// 입력한 휴대번호
	var checkBox = document.getElementById('phone_num_chk');		// 인증번호 입력란		  

    $.ajax({
      
        type:"GET",
        url:"./join/phoneCheck?phone=" + phone,
        success:function(data){
            console.log("data : " + data);
			checkBox.disabled = false;
			code = data;
        }
                
    });  
}

// 휴대폰 인증번호 확인
function p_check() {
	
	var inputCode = document.getElementById('phone_num_chk').value;
	var msg = document.getElementById('phoneCheck_msg');
	
	if(inputCode === code) {
		msg.innerText = '인증번호가 일치합니다.';
		msg.style.color = 'green';
		msg.style.fontSize = '15px';
	} else {
		msg.innerText = '인증번호를 다시 확인해주세요.';
		msg.style.color = 'red';
		msg.style.fontSize = '15px';
	}
}

// 아이디 중복체크
function checkId() {
	var id = document.getElementsByName('userid')[0].value;
	var msg = document.getElementById('id_check_msg');
	
	$.ajax({
		url: "./join/checkId",
		type: "get",
		data: {id: id},
		dataType: "json",
		success: function(data) {
			console.log('data : ' + data);
			
			if(data > 0) {
				msg.style.color = 'red';
				msg.style.fontSize = '15px';
				msg.innerText = '사용 불가능한 아이디 입니다.';
			} else {
				if(id.length < 5) {
		            msg.innerText = '';
		        } else {
					msg.style.color = 'green';
					msg.style.fontSize = '15px';
					msg.innerText = '사용 가능한 아이디 입니다.';	
				}
			}
			if(!id) {
				msg.innerText = '';
			}
		}
	});
	
}