package com.web.home.join.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private JavaMailSenderImpl mailSenderYeon;
	
	// 이메일 인증
    @RequestMapping(value="/join/mailCheck", method=RequestMethod.GET)
    @ResponseBody
    public String mailCheckGET(String email) throws Exception{
        
        // 뷰(View)로부터 넘어온 데이터 확인
        logger.info("이메일 데이터 전송 확인");
        logger.info("이메일 : " + email);
        
        // 인증번호 생성
        Random r = new Random();
        int checkNum = r.nextInt(888888) + 111111;
        logger.info("인증번호 : " + checkNum);
        
        // 이메일 보내기
        String setFrom = "dlatlrpwjd134@gmail.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "홈페이지에 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 입력란에 입력해주시길 바랍니다.";
        
        try {
            
            MimeMessage message = mailSenderYeon.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSenderYeon.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        String num = Integer.toString(checkNum);
        
        return num;
    }
}
