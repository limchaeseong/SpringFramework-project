package com.web.home.discover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.discover.model.discoverDAO;
import com.web.home.discover.model.postBoardVO;
import com.web.home.discover.model.searchClubVO;

@Service
public class discoverService {
	
	@Autowired
	private discoverDAO dao;

	public List<searchClubVO> searchClub(String keyword) {
		
		return dao.searchClub(keyword);
	}

	public List<postBoardVO> searchBoard(String keyword) {

		return dao.searchBoard(keyword);
	}

}
