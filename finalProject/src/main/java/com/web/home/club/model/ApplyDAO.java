package com.web.home.club.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.home.account.model.AccountDTO;

@Repository
public class ApplyDAO {
	
	@Autowired
	private SqlSession sess;
	
	public int insertApply(ApplyVO vo) {
		int sq = this.sess.insert("ApplyMapper.insertApply", vo);
		if(sq != -1) {
			return sq;
		}
		return -1;
	}
	
	public AccountDTO selectAccount(int a_id) {
		AccountDTO vo = sess.selectOne("ApplyMapper.selectAccount", a_id);
		return vo;
	}
	
	// 멤버 수 조회
	public int countMember(int c_id) {
		int count = this.sess.selectOne("ApplyMapper.selectApCount", c_id);
		return count;
	}

	public ApplyVO selectA_id(int c_id) {
		ApplyVO avo = this.sess.selectOne("ApplyMapper.selectA_id", c_id);
		return avo;
	}
	
	public ApplyVO applyState(ApplyVO avo) {
		ApplyVO vo = this.sess.selectOne("ApplyMapper.applyState", avo);
		return vo;
	}

	public ApplyVO applyState(int c_id, int a_id) {
		ApplyVO vo = new ApplyVO();
		vo.setC_id(c_id);
		vo.setA_id(a_id);
		ApplyVO avo = this.sess.selectOne("ApplyMapper.applyState", vo);
		return avo;
	}
}

