package com.web.home.account.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.home.account.model.AccountDAO;
import com.web.home.account.model.AccountDTO;
import com.web.home.aop.annotation.Perm;

@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountDTO dto;
	@Autowired
	private AccountDAO dao;
	
	public AccountDTO login(String a_uid, String a_pw) {
		logger.debug("a_uid: {}, a_pw: {}", a_uid, a_pw);
		dto.setA_uid(a_uid);
		dto.setA_pw(a_pw);
		AccountDTO account = dao.selectAccount(dto);
		System.out.println(account);
		if(account != null) {
			return account;
		}
		return null;
	}
	//카카오,구글로그인용
	public AccountDTO login(AccountDTO dto) {
		logger.debug("dto", dto);
		AccountDTO account = dao.selectAccount(dto);
		System.out.println(account);
		if(account != null) {
			return account;
		}
		return null;
	}
	//아이디 찾기(성명, 이메일) & 비밀번호 찾기 시 메일발송(아이디, 이메일) -> 위 로그인까지 동적쿼리
	public AccountDTO findUser(AccountDTO dto) {
		logger.debug("a_name: {}, a_email: {}", dto.getA_name(), dto.getA_email());
		AccountDTO account = dao.selectAccount(dto);
		if(account != null) {
			return account;
		}
		return null;
	}
	
	//비밀번호 찾기 시 존재하는 아이디인지 체크 
	public String findUser(String a_name) {
		logger.debug("a_name: {}", a_name);
		String a_uid = dao.selectA_uid(a_name);
		if(a_uid != null) {
			return a_uid;
		}
		return null;
	}

	public int changeA_pw(Map map) {
		int row = dao.updateA_pw(map);
		if(row != 0) {
			return row;
		}
		return 0;
	}
	//카카오톡 로그인 회원가입용
	public int join(AccountDTO dto) {
		int row = dao.insertKAccount(dto);
		if(row != 0) {
			return row;
		}
		return 0;
	}	

}
