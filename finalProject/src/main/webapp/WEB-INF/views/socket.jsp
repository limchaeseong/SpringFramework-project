<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Socket</title>
</head>
<body>
	<div>
		<button type="button" onclick="socketConnect();">웹소켓 연결</button>
		<button type="button" onclick="socketClose();">연결해제</button>
	</div>
	<div>
		<input type="text" id="sendMsg">
		<button type="button" onclick="sendMessage(sendMsg.value);">전송</button>
	</div>
</body>
<script type="text/javascript">

var ws;

function sendMessage(data){
	ws.send(data);
}

function socketConnect(){
	console.log("웹소켓 연결을 시작합니다.");
	var name = prompt("닉네임을 입력하세요.");
	ws = new WebSocket("ws://localhost/websock?name=" + name);
	
	ws.onopen = function(){
		console.log("소켓 연결이 되었습니다.");
		
	};
	ws.onmessage = function(event){
		//서버가 메시지 보내면 동작을 하는 이벤트
		console.log(event.data);

	};
	
	ws.onclose = function(){
		console.log("웹 소켓 연결을 해제했습니다.");
	};
}

function socketClose(){
	ws.close();
}

<!-- 깃 확인용 주석 -->
</script>
</html>