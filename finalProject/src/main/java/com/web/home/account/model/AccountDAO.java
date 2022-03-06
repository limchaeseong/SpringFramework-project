package com.web.home.account.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountDAO.class);
	
	@Autowired 
	private SqlSession sess; 
	
	public AccountDTO selectAccount(AccountDTO dto) {
		logger.info("selectAccount()");
		logger.debug("dto :{}", dto);
		return this.sess.selectOne("AccountMapper.selectAccount", dto);
	}


	public String selectA_uid(String a_name) {
		return this.sess.selectOne("AccountMapper.selectA_uid", a_name);

	}


//	public int updateAccount(AccountDTO dto) {
//		return this.sess.update("AccountMapper.updateAuthKey", dto);
//	}


	public int updateA_pw(Map map) {
		return this.sess.update("AccountMapper.updateA_pw", map);
	}


	public int insertKAccount(AccountDTO dto) {
		return this.sess.insert("AccountMapper.insertKAccount", dto);
	}





}
