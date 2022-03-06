package com.web.home.websocket;

import java.util.*;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Chatroom {
	private int roomId;
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	public static Chatroom create(int roomId) {
		Chatroom chatroom = new Chatroom();
		chatroom.roomId = roomId;
		return chatroom;
	}
	
	public void handleTextMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) throws Exception {
		if(chatMessage.getType() == MessageType.ENTER) {
			sessionList.add(session);
			chatMessage.setMessage(chatMessage.getWriter() + "님이 입장하셨습니다.");
			this.send(chatMessage,objectMapper);
		} else if(chatMessage.getType() == MessageType.CHAT) {
			chatMessage.setMessage(chatMessage.getWriter() + " : " + chatMessage.getMessage());
			this.send(chatMessage,objectMapper);
		} else {
			System.out.println("세션삭제");
			chatMessage.setMessage(chatMessage.getWriter()+ "님이 퇴장하셨습니다.");
			this.send(chatMessage,objectMapper);	
			sessionList.remove(session);
		}
					
	}
	
	private void send(ChatMessage chatMessage, ObjectMapper objectMapper) throws Exception{
		TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(chatMessage.getMessage()));
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(textMessage);
		}
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public List<WebSocketSession> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<WebSocketSession> sessionList) {
		this.sessionList = sessionList;
	}
	
}
