package com.web.home.websocket.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.home.account.model.AccountDTO;
import com.web.home.websocket.ChatRoomRepository;
import com.web.home.websocket.Chatroom;

@Controller
public class ChatController {
	private final ChatRoomRepository chatRoomRepository;
	
	public ChatController() {
		chatRoomRepository = new ChatRoomRepository();
	}
	
	@RequestMapping(value = "/chatHome", method = RequestMethod.GET)
	public String chathome(Model model) {
		if(chatRoomRepository.findAllRoom() != null) {
			model.addAttribute("rooms",chatRoomRepository.findAllRoom());
			System.out.println(chatRoomRepository.findAllRoom());
		}	
		return "/chat/home";
	}
	
	@RequestMapping(value="/chat", method = RequestMethod.GET)
	public String chat(Integer band_id,String nickname,Model model) {
		System.out.println(band_id);
		System.out.println(nickname);
		if(chatRoomRepository.findRoomById(band_id) != null) {
			Chatroom room = chatRoomRepository.findRoomById(band_id);
			model.addAttribute("room",room);
			System.out.println("error2");
		} else{
			System.out.println("error3");
			Chatroom room = chatRoomRepository.createChatRoom(band_id);
			model.addAttribute("room",room);
			System.out.println("error4");
		};
		System.out.println("error5");
		model.addAttribute("band_id",band_id);
		model.addAttribute("nickname",nickname);
		System.out.println(model);
		return "/chat/view_chat";
	}
	
	@RequestMapping(value="/chat2", method = RequestMethod.POST)
	public String chat1(String c_no,String c_name,Model model, HttpSession sessions) {
		Integer c_num = Integer.parseInt(c_no);
		System.out.println(c_num);
		System.out.println(c_name);
		AccountDTO dto = (AccountDTO)sessions.getAttribute("account");
		String nickname = dto.getA_uid();
		if(chatRoomRepository.findRoomById(c_num) != null) {
			Chatroom room = chatRoomRepository.findRoomById(c_num);
			//request.setAttribute("room",room);
			model.addAttribute("room",room);
			System.out.println("error2");
		} else{
			System.out.println("error3");
			Chatroom room = chatRoomRepository.createChatRoom(c_num);
			model.addAttribute("room",room);
			System.out.println("error4");
		};
		System.out.println("error5");
		model.addAttribute("band_id",c_num);
		model.addAttribute("band_name",c_name);
		model.addAttribute("nickname",nickname);
//		request.setAttribute("band_id",c_num);
//		request.setAttribute("band_name",c_name);
//		request.setAttribute("nickname",nickname);
		System.out.println(model);
//		System.out.println(request);
		return "/chat/view_chat";
		
	}
}
