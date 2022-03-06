package com.web.home.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.model.ApplyDAO;
import com.web.home.club.model.ApplyVO;

@Service
public class ApplyService {
	
	@Autowired
	private ApplyDAO dao;
	
	public int createApply(ApplyVO vo) {
		int sq = dao.insertApply(vo);
		return sq;
	}
	
	public AccountDTO selectAccount(int a_id) {
		return dao.selectAccount(a_id);
	}
	
	public int countMember(int c_id) {
		int count = dao.countMember(c_id);
		return count;
	}
	
	public ApplyVO selectA_id(int c_id) {
		ApplyVO avo = dao.selectA_id(c_id);
		return avo;
	}

	public ApplyVO applyState(int c_id, int a_id) {
		ApplyVO vo = dao.applyState(c_id, a_id);
		return vo;
	}
}
