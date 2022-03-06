package com.web.home.my.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.my.model.commentVO;
import com.web.home.my.model.myDAO;
import com.web.home.my.model.myVO;
import com.web.home.my.model.postVO;

@Service
public class myService {
	
	private static final Logger logger = LoggerFactory.getLogger(myService.class);
	
	@Autowired
	private myDAO dao;
	
	public myVO readMember(int a_id) {
		return dao.readMember(a_id);
	}
	
	public List<postVO> myPost(int a_id) {
		logger.info("myPost 실행");
		return dao.myPost(a_id);
	}

	public List<commentVO> myComment(int a_id) {
		logger.info("myComment 실행");
		return dao.myComment(a_id);
	}

	public String pwCheck(int a_id) {
		logger.info("pwCheck 실행");
		String result = dao.pwCheck(a_id);
		return result;
	}
	
	public int pwUpdate(myVO vo) {
		logger.info("pwUpdate 실행 a_pw:" + vo.getA_pw() + ", a_id: " + vo.getA_id());
		return dao.pwUpdate(vo);
	}

	public int genderUpdate(myVO vo) {
		logger.info("genderUpdate 실행 a_gender:" + vo.getA_gender() + ", a_id: " + vo.getA_id());
		return dao.genderUpdate(vo);
	}

	public int birthUpdate(myVO vo) {
		logger.info("birthUpdate 실행 a_bdate:" + vo.getA_bdate() + ", a_id: " + vo.getA_id());
		return dao.birthUpdate(vo);
	}

	public int emailUpdate(myVO vo) {
		logger.info("emailUpdate 실행 a_email:" + vo.getA_email() + ", a_id: " + vo.getA_id());
		return dao.emailUpdate(vo);
	}

	public int phoneUpdate(myVO vo) {
		logger.info("phoneUpdate 실행 a_phone:" + vo.getA_phone() + ", a_id: " + vo.getA_id());
		return dao.phoneUpdate(vo);
	}

	public int adUpdate(myVO vo) {
		logger.info("adUpdate 실행 a_ad:" + vo.getA_ad() + ", a_id: " + vo.getA_id());
		return dao.adUpdate(vo);
	}

	public int myInfoEdit(myVO vo) {
		logger.info("myInfoEdit 실행 a_photo:" + vo.getA_ad() + ", a_id: " + vo.getA_id());
		return dao.myInfoEdit(vo);
	}

}
