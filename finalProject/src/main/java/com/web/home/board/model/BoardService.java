package com.web.home.board.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public int boardWrite(Map<String, Object> map) {
		int res = dao.insertBoard(map);
		if(res != 0) {
			return res;
		}
		return 0;
	}

	public int photoAdd(Map<String, Object> map) {
		int res = dao.insertPhoto(map);
		if(res != 0) {
			return res;
		}
		return 0;
	}

}
