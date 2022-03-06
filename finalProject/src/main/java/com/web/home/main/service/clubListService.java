package com.web.home.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.main.model.clubListDAO;
import com.web.home.main.model.clubListVO;

@Service
public class clubListService {
	
	@Autowired
	private clubListDAO dao;

	public List<clubListVO> myClubList(int a_id) {
		List<clubListVO> vo = dao.myClubList(a_id);
		return vo;
	}

}
