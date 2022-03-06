package com.web.home.account.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.home.account.model.AccountDTO;
import com.web.home.account.service.AccountService;
import com.web.home.account.service.MailSendService;
import com.web.home.chat.model.*;

@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountDTO dto;
	@Autowired
	private AccountService service;
	@Autowired
	private MailSendService mss;
	@Autowired
	private ChatService c_service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		logger.info("method: GET, login(), 로그인 페이지 요청");
		if(request.getParameter("next") != null) {
			String nextUrl = request.getParameter("next");
			model.addAttribute("nextUrl", nextUrl); //login.jsp
		}
		return "account/login"; 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String a_uid, String a_pw, Model model, HttpServletRequest request) { 
		logger.info("method: POST, login(), 로그인 처리 요청");
		logger.debug("a_uid: {}, a_pw: {}", a_uid, a_pw);
		
		dto = service.login(a_uid, a_pw);
		List<ChatVO> c_list = c_service.getChat(dto.getA_id());
		for(ChatVO c : c_list) {
			System.out.println(c.getC_ID()+c.getC_NAME());
		}
		HttpSession session = request.getSession();
		if(dto != null) {
			session.setAttribute("s_a_id", dto.getA_id()); 
			session.setAttribute("logined", true);
			session.setAttribute("account", dto);
			session.setAttribute("c_list",c_list);
			if(request.getParameter("nextUrl") != null) {
				String nextUrl = request.getParameter("nextUrl");
				return "redirect:" + nextUrl;
			}
			return "redirect:/";
		}
		session.setAttribute("logined", false);
		model.addAttribute("error", true);
		model.addAttribute("error_msg", "아이디 또는 패스워드를 확인하세요.");
		return "account/login"; 
		
	}
	//카카오 로그인, 회원가입 (이메일 선택동의)
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public String kakaoLogin(String kId, String kEmail, HttpSession session, HttpServletRequest request) {
		String gId, imageUrl, gEmail, line = null;
		//카카오톡 로그인
		logger.info("KakaoLogin post ajax");
		System.out.println(kId+ ", " +kEmail);
		if(kId != null) {
			dto.setA_kakao(kId);
			if(kEmail != null) {
				dto.setA_email(kEmail);
			}
			int res = service.join(dto);
			JSONObject json = new JSONObject();
			if(res != 0) {
				dto = service.login(dto);
				session.setAttribute("s_a_id", dto.getA_id()); 
				session.setAttribute("logined", true);
				session.setAttribute("account", dto);
				json.put("state", "success");
				System.out.println("세션에 저장");
			} 
			else {
				json.put("state", "fail");
			}
			return json.toJSONString();
			
		//구글 로그인 	
		} else {
			//초기화
			AccountDTO dto = new AccountDTO();
			StringBuffer sb = new StringBuffer();
			try {
				BufferedReader br = request.getReader();
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(sb.toString());
				gId = ((String) obj.get("gId")).substring(0,14); //자름
				gEmail = (String) obj.get("gEmail");
				dto.setA_google(gId);
				System.out.println("구글 dto" + dto);
				if(gEmail != null) {
					dto.setA_email(gEmail);
				}
				int res = service.join(dto);
				
				//JSONObject json = new JSONObject();
				if(res != 0) {
					dto = service.login(dto);
					session.setAttribute("s_a_id", dto.getA_id()); 
					session.setAttribute("logined", true);
					session.setAttribute("account", dto);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return "home";
	}
	//아이디 찾기
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	public String findUser() {
		logger.info("findUser get");
		
		return "account/findUser";
	}
	//아이디 찾기
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public String findUser(String e_first, String e_last, String a_name, Model model) {
		logger.info("findUser post");
		String email = e_first + "@" + e_last;
		System.out.println(email);
		
		dto.setA_email(email);
		dto.setA_name(a_name);
		
		AccountDTO account = service.findUser(dto);
		if(account != null) {
			model.addAttribute("a_uid", account.getA_uid());
			return "account/findUser";
		}
		return "account/findUser";
	}
	
	//비밀번호찾기 시 아이디 체크
	@RequestMapping(value = "/nameCheck", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public String nameCheck(String a_uid, Model model) {
		logger.info("nameCheck get ajax");
		String inputUid = a_uid;
		System.out.println("inputUid :"+ inputUid);
		
		JSONObject json = new JSONObject();
		if(inputUid != null) {
			String db_a_uid = service.findUser(inputUid);

			if(inputUid.equals(db_a_uid)) {
				json.put("state", "success");
				json.put("msg", "가입하신 아이디가 맞습니다.");
				model.addAttribute("db_a_uid", db_a_uid);
			} else {
				json.put("state", "fail");
				json.put("msg", "가입하신 아이디가 아닙니다.");
			}
		}
		return json.toJSONString();
	}
	
	//비밀번호 찾기 메일발송
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public String sendMail(String a_uid, String e_first, String e_last,
			Model model, HttpSession session) {
		logger.info("sendMail post ajax");
		String email = e_first + "@" + e_last;
		
		JSONObject json = new JSONObject();
		
		if(a_uid != null && email != "@") {
			dto.setA_email(email);
			dto.setA_uid(a_uid);
			AccountDTO account = service.findUser(dto); 
			//가입한 유저라면
			if(account != null) {
				//인증메일 보냄
				String authKey = mss.snedAuthMail(email);
				json.put("state", "success");
				model.addAttribute("a_uid", a_uid);
				model.addAttribute("e_first", e_first);
				model.addAttribute("e_last", e_last);
				
				session.setAttribute("a_id", account.getA_id());
				session.setAttribute("authKey", authKey);
				System.out.println("메일 발송 후 세션에 인증키, a_id 담음"); 
			} else {
				json.put("state", "fail");
				json.put("msg", "가입하신 정보와 달라 메일이 전송되지 않았습니다.");
			}
		}
		return json.toJSONString();
	}
	
	@RequestMapping(value = "/findPass", method = RequestMethod.GET)
	public String findPass() {
		logger.info("findPass get");
		
		return "account/findPass";
	}

	//비밀번호찾기 인증번호 사용자 입력값과 비교하기
	@RequestMapping(value = "/authKey", method = RequestMethod.POST)
	public String send(HttpSession session, String authKey, Model model) {
		logger.info("authKey post");
		if(authKey != null) {
			if(session.getAttribute("authKey").equals(authKey)) {
				System.out.println("일치해양");
				return "account/renewPass";
			} else {
				model.addAttribute("unmatch","인증번호가 일치하지 않습니다.");
			}
		}
		return "account/findPass";
	}
	
	//테스트임시
	@RequestMapping(value = "/renewPass", method = RequestMethod.GET)
	public String renewPass(HttpSession session, String authKey) {
		return "account/renewPass";
	}
	
	//비밀번호 찾기를 한 사용자 비밀번호 변경
	@RequestMapping(value = "/renewPass", method = RequestMethod.POST)
	public String renewPass(int a_id, String new_password) {
		//a_id 와 new_password 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a_id", a_id);
		map.put("new_password", new_password);
		
		int res = 0;
		res = service.changeA_pw(map);
		if(res == 1) {
			//비밀번호 업데이트 성공 시 로그인 페이지로 리다이렉트
			return "redirect:/login";
		} else {
			//비밀번호 업데이트 진행 실패
			return "account/renewPass";
		}
	}
	
	
}
