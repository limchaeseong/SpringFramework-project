package com.web.home.board.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	private SqlSession sess;

	public int insertBoard(Map<String, Object> map) {
		logger.debug("map :{}", map);
		return this.sess.insert("BoardMapper.insertBoard", map);
	}

	public int insertPhoto(Map<String, Object> map) {
		logger.debug("map :{}", map);
		return this.sess.insert("BoardMapper.insertPhoto", map);
	}

}
