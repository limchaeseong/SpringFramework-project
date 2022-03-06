<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>웹소켓 채팅</title>
	<c:url var="jq_url" value="/static/jq"/>
	<script type="text/javascript" src="${jq_url}/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div style="width:30%;">
		<div style="min-width:600px; max-width:700px; display:flex; justify-content: space-between; background-color:rgb(89, 139, 175)">
			<span style="color:white;">NickName : ${nickname}</span>
			<span style="color:white;">${band_name}</span>
			<span><button id="leave">퇴장</button></span>
		</div>
		<div id = "chatroom" style = "min-width:600px; max-width:700px; height: 450px; board: 1px solid; background-color: rgb(255,245,235); word-break:break-all; overflow-y:auto;">
		</div>
		<div style="min-width:600px; max-width:700px;">
			<input type="text" id="message" style="height: 30px; min-width:500px; max-width:600px;" placeholder="내용을 입력하세요" autofocus>
			<button id="send">전송</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		var webSocket;
		var nickname = "<c:out value='${nickname}' />";
		var band_id = "<c:out value='${band_id}'/>";
		connect();
		document.getElementById("send").addEventListener("click",function(){
			send();
		})
		document.getElementById("leave").addEventListener("click",function(){
			webSocket.send(JSON.stringify({chatRoomId : band_id, type:'LEAVE',writer:nickname}));
			webSocket.close();
			window.close();
		})	
		function connect(){
			webSocket = new WebSocket("ws://localhost/websock");
			webSocket.onopen = onOpen;
			webSocket.onmessage = onMessage;
		}
		function send(){
			console.log("send");
			msg = document.getElementById("message").value;
			webSocket.send(JSON.stringify({chatRoomId : band_id, type:'CHAT',writer:nickname,message : msg}));
			document.getElementById("message").value="";
		}
		function onOpen(){
			webSocket.send(JSON.stringify({chatRoomId : band_id, type:'ENTER',writer:nickname}));
		}
		function onMessage(e){
			data = e.data;
			chatroom = document.getElementById("chatroom");
			chatroom.innerHTML = chatroom.innerHTML + "<br>" +data;
		}
	});
</script>
</html>