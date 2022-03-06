package com.web.home.chat.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatService {
	private static final Logger logger = LoggerFactory.getLogger(ChatDAO.class);
	
	@Autowired
	private ChatDAO dao;
	
	public List<ChatVO> getChat(int a_id){
		logger.info("a_id:{}",a_id);
		return dao.selectChat(a_id);
	}
}
