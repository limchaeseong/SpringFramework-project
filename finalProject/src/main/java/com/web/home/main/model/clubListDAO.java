package com.web.home.main.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class clubListDAO {
	private static final Logger logger = LoggerFactory.getLogger(clubListDAO.class);
	@Autowired
	private SqlSession sess;

	public List<clubListVO> myClubList(int a_id) {
		List<clubListVO> vo = sess.selectList("clubListMapper.clubList", a_id);
		return vo;
	}

}
