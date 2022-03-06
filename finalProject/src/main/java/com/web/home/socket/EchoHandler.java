package com.web.home.socket;


import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{

	public WebSocketSession getSession() {
		return null;
	}
}
