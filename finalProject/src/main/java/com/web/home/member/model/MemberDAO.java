package com.web.home.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.metting.model.MettingDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sess;

	public int memberApply(MemberVO mvo) {
		int member = this.sess.insert("MemberMapper.memberApply", mvo);
		if(member != -1) {
			return member;	
		}
		return -1;
	}

	public List<MemberVO> selectMember(MemberVO mvo) {
		List<MemberVO> vo = this.sess.selectList("MemberMapper.selectMember", mvo);
		return vo;
	}

	public List<AccountDTO> memberList(MemberVO vo) {
		List<AccountDTO> lDto = this.sess.selectList("MemberMapper.memberList", vo);
		return lDto;
	}
	
	public List<AccountDTO> memberA_id(MemberVO vo) {
		List<AccountDTO> aDto = this.sess.selectList("MemberMapper.memberA_id", vo);
		return aDto;
	}
	
	public List<AccountDTO> manager(MemberVO vo) {
		List<AccountDTO> manager = this.sess.selectList("MemberMapper.manager", vo);
		return manager;	

	}

	public String imManager(MemberVO vo) {
		String yN = this.sess.selectOne("MemberMapper.imManager", vo);
		return yN;
	}

	public int memberManager(MemberVO mvo) {
		int memberManager = this.sess.insert("MemberMapper.memberManager", mvo);
		if(memberManager != -1) {
			return memberManager;	
		}
		return -1;
	}

	public int memberDelete(MemberVO vo) {
		int md = this.sess.delete("MemberMapper.memberDelete", vo);
		if(md != -1) {
			return md;	
		}
		return -1;
	}

	public int applyDelete(MemberVO vo) {
		int ad = this.sess.delete("MemberMapper.applyDelete", vo);
		if(ad != -1) {
			return ad;	
		}
		return -1;
	}

	public int ccDelete(int c_id) {
		int data = this.sess.delete("MemberMapper.ccDelete", c_id);
		return data;
	}
}
