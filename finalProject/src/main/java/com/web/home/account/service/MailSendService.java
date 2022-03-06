package com.web.home.account.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.web.home.account.model.MailUtils;

@Service
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int size;
	
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}
	
	private String getAuthCode() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;

        while(sb.length() < size) {
            num = random.nextInt(10);
            sb.append(num);
        }

        return sb.toString();
    }
	
	//인증메일 보내기
	public String snedAuthMail(String email) {
		//6자리 난수 인증번호 생성
        String authKey = getKey(6);
        
        //인증메일 보내기
        try {
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("비밀번호 찾기 이메일 인증");
            sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
    		.append("<span style='font-weight: bold; font-size: 24px;'>인증번호 : </span>")		
            .append("<mark style='font-weight: bold; font-size: 24px;'>" + authKey + "</mark>")
            .toString());
            
			sendMail.setFrom("epikbb1234@gmail.com", "관리자");
            sendMail.setTo(email);
            sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
          return authKey;
	}

}
