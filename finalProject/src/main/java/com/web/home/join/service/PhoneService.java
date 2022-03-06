package com.web.home.join.service;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class PhoneService {
	
	public void certification(String phoneNum, int checkNum) {
		String api_key = "NCSYZH5USMDSRT78";
		String api_secret = "THOXLZSADQFNMHR5MADLGDXL9RSMVXN5";
		
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("to", phoneNum);
		params.put("from", "01094767545");
		params.put("type", "SMS");
		params.put("text", "인증번호는 [" + checkNum + "] 입니다.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
