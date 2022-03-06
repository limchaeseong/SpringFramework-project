package com.web.home.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebSocketSample extends TextWebSocketHandler  {
	
	private ChatRoomRepository chatRoomRepository;
	private ObjectMapper objectMapper;
	
	public WebSocketSample() {
		this.chatRoomRepository = new ChatRoomRepository();
		this.objectMapper = new ObjectMapper();
	}


	public WebSocketSample(ChatRoomRepository chatRoomRepository,ObjectMapper objectMapper) {
		this.chatRoomRepository = chatRoomRepository;
		this.objectMapper = objectMapper;
	}
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("connect");
	}
	
//	@Override
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		System.out.println("send");
//		super.handleMessage(session, message);
//		
//	}
	
	
	// 클라이언트가 서버로 메세지 전송 처리
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		System.out.println("websocketSample : " + msg);
		ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
		int romm_id = chatMessage.getChatRoomId();
		System.out.println(chatMessage);
		Chatroom chatroom = new Chatroom();
		if(chatRoomRepository.findRoomnBoolean(romm_id)) {
			chatroom = chatRoomRepository.findRoomById(romm_id);
		} else {
			chatroom = chatRoomRepository.createChatRoom(romm_id);
		}
		System.out.println(chatroom);
		chatroom.handleTextMessage(session, chatMessage, objectMapper);
		if(chatMessage.getType()==MessageType.LEAVE) {
			if(chatRoomRepository.MemberNum(romm_id)==0) {
				System.out.println("Member : " + chatRoomRepository.MemberNum(romm_id));
				chatRoomRepository.Delete_Chatroom(romm_id);
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("close");
		super.afterConnectionClosed(session, status);
	}

}
