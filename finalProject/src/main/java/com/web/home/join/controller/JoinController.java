package com.web.home.join.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.home.join.model.JoinVO;
import com.web.home.join.service.JoinService;

@Controller
public class JoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private JoinService service;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		logger.info("GET -> 회원가입 페이지");
		
		return "join/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(JoinVO vo, Model model) {
		logger.info("POST -> 회원가입 페이지");
		logger.debug(vo.toString());
		
		boolean result = false; 
		
		try {
			result = service.insertJoin(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("controller -> " + result);
		
		if(result) {
			System.out.println("성공");
			return "redirect:/";
		} else {
			System.out.println("실패");
			model.addAttribute("joinVO", vo);
			return "join/join";
		}
	}
	
	// 아이디 중복 검사
	@RequestMapping(value="/join/checkId", method=RequestMethod.GET)
	@ResponseBody
	public String joinCheckId(String id) {
		logger.info("GET -> 아이디 중복체크");
		logger.debug("id -> " + id);
		
		int cnt = service.selectIdCheck(id);
		
		String num = Integer.toString(cnt);
		
		return num;
	}
}
