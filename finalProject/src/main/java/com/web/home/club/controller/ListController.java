package com.web.home.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.home.club.model.ClubVO;
import com.web.home.club.service.ClubService;

@Controller
public class ListController {
	
	@Autowired
	private ClubService service;

	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		List<ClubVO> datas = service.clubList();
		model.addAttribute("datas", datas);
		
		return "club/list";
	}

}
