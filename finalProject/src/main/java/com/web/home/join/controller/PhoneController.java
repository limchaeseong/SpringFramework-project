package com.web.home.join.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.home.join.service.PhoneService;

@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private PhoneService service;
	
	@RequestMapping(value="/join/phoneCheck", method=RequestMethod.GET)
	@ResponseBody
	public String sendSMS(String phone) {
		
		// 뷰(View)로부터 넘어온 데이터 확인
        logger.info("핸드폰 데이터 전송 확인");
        logger.info("핸드폰 : " + phone);
        
     // 인증번호 생성
        Random r = new Random();
        int checkNum = r.nextInt(888888) + 111111;
        logger.info("인증번호 : " + checkNum);
        
        service.certification(phone, checkNum);
        
        return Integer.toString(checkNum);
	}
}
