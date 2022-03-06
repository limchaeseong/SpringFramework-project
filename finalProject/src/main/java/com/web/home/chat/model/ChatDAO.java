package com.web.home.chat.model;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDAO {
	private static final Logger logger = LoggerFactory.getLogger(ChatDAO.class);

	@Autowired
	private SqlSession sess;
	
	public List<ChatVO> selectChat(int a_id) {
		logger.info("ChatDAO()");
		return this.sess.selectList("ChatMapper.selectChat",a_id);
	}
	
	
	
}
