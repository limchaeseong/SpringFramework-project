package com.web.home.my.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class myDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(myDAO.class);
	
	@Autowired
	private SqlSession sess;

	public myVO readMember(int a_id) {
		myVO vo = sess.selectOne("MyMapper.selectMyInfo", a_id);
		logger.info("myVO: {}", vo);
		return vo;
	}
	public List<postVO> myPost(int a_id) {
		List<postVO> post = sess.selectList("MyMapper.myPost", a_id);
		logger.info("postVO: {}", post);
		return post;
	}
	public List<commentVO> myComment(int a_id) {
		List<commentVO> comment = sess.selectList("MyMapper.myComment", a_id);
		logger.info("commentVO: {}", comment);
		return comment;
	}
	// 비밀번호 가져오기
	public String pwCheck(int a_id) {
		logger.info("pwCheck");
		String result = sess.selectOne("MyMapper.pwCheck", a_id);
		return result;
	}
	// 비밀번호 변경
	public int pwUpdate(myVO vo) {
		logger.info("pwUpdate : " + vo);
		return sess.update("MyMapper.pwUpdate", vo);
	}
	// 성별
	public int genderUpdate(myVO vo) {
		logger.info("genderUpdate : " + vo);
		return sess.update("MyMapper.genderUpdate", vo);
	}
	// 생년월일
	public int birthUpdate(myVO vo) {
		logger.info("birthUpdate : " + vo);
		return sess.update("MyMapper.birthUpdate", vo);
	}
	public int emailUpdate(myVO vo) {
		logger.info("emailUpdate : " + vo);
		return sess.update("MyMapper.emailUpdate", vo);
	}
	public int phoneUpdate(myVO vo) {
		logger.info("phoneUpdate : " + vo);
		return sess.update("MyMapper.phoneUpdate", vo);
	}
	public int adUpdate(myVO vo) {
		logger.info("adUpdate : " + vo);
		return sess.update("MyMapper.adUpdate", vo);
	}
	public int myInfoEdit(myVO vo) {
		logger.info("myInfoEdit : " + vo);
		return sess.update("MyMapper.photoUpdate", vo);
	}

}
