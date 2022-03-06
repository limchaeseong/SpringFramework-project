package com.web.home.discover.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.home.discover.model.postBoardVO;
import com.web.home.discover.model.searchClubVO;
import com.web.home.discover.service.discoverService;


@Controller
public class discoverController {
	private static final Logger logger = LoggerFactory.getLogger(discoverController.class);
	
	@Autowired
	private discoverService service;
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(@RequestParam("keyword") String k, 
			HttpSession session, Model model) {
		String keyword = k;
		logger.info("===== 검색을 요청한 단어 [ " + k + " ] =====");
		
		List<searchClubVO> searchClub = service.searchClub(keyword);
		List<postBoardVO> postBoard = service.searchBoard(keyword);
			
		logger.info("===== searchClub 모임에 검색어가 검색되어 저장" + searchClub);
		session.setAttribute("searchClub", searchClub);
				

		logger.info("===== postBoard 게시글에 검색어가 검색되어 저장" + postBoard);
		session.setAttribute("postBoard", postBoard);
		session.setAttribute("keyword", keyword);
				
		return "discover/searchClub";
	}
	
	@RequestMapping(value="/searchClub")
	public String searchClub() {
		return "discover/searchClub";
	}
	@RequestMapping(value="/postBoard")
	public String postBoard() {
		return "discover/postBoard";
	}
}
