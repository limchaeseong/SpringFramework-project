package com.web.home.chat.model;

import org.springframework.stereotype.Component;

@Component
public class ChatVO {
	private int C_ID;
	private String C_NAME;
	
	public int getC_ID() {
		return C_ID;
	}
	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}
	public String getC_NAME() {
		return C_NAME;
	}
	public void setC_NAME(String c_NAME) {
		C_NAME = c_NAME;
	}
	@Override
	public String toString() {
		return "ChatVO [C_ID=" + C_ID + ", C_NAME=" + C_NAME + "]";
	}
	
	
	
}
