package com.web.home.websocket;

public class ChatMessage {
	private int chatRoomId;
	private String writer;
	private String message;
	private MessageType type;
	
	public ChatMessage() {
		
	}
	
	public ChatMessage(int chatRoomId,String writer,MessageType type) {
		this.chatRoomId = chatRoomId;
		this.writer = writer;
		this.type = type;
		this.message = "";
	}
	
	public int getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	
	
}