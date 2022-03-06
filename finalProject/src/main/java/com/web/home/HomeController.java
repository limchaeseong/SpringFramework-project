package com.web.home;

import java.util.List; 

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.home.club.model.ClubVO;
import com.web.home.club.service.ClubService;
import com.web.home.main.model.clubListVO;
import com.web.home.main.service.clubListService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private clubListService service;
	
	@Autowired
	private ClubService service1;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) throws Exception {
		if(session.getAttribute("s_a_id") != null) {
			int a_id = (int) session.getAttribute("s_a_id");
			
			List<clubListVO> vo = service.myClubList(a_id);
			
			logger.info("a_id로 조회한 clubList :::"+ vo);
			session.setAttribute("clubList", vo);
			
			List<ClubVO> clubs = service1.clubList(a_id);
			model.addAttribute("datas", clubs);
		} else {
			List<ClubVO> clubs = service1.clubList();
			model.addAttribute("datas", clubs);
		}	
		return "home";
	}

	@RequestMapping(value = "/socket", method = RequestMethod.GET)
	public String socket() {
		return "socket";
	}

}
