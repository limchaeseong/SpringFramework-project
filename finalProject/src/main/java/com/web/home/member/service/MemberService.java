package com.web.home.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.metting.model.MettingDTO;
import com.web.home.member.model.MemberDAO;
import com.web.home.member.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public int memberApply(MemberVO mvo) {
		int member = dao.memberApply(mvo);
		return member;
	}

	public List<MemberVO> selectMember(MemberVO mvo) {
		List<MemberVO> vo = dao.selectMember(mvo);
		return vo;	
	}

	public List<AccountDTO> memberList(MemberVO vo) {
		List<AccountDTO> lDto = dao.memberList(vo);
		return lDto;
	}
	
	public List<AccountDTO> memberA_id(MemberVO vo) {
		List<AccountDTO> aDto = dao.memberA_id(vo);
		return aDto;
	}

	public List<AccountDTO> manager(MemberVO vo) {
		List<AccountDTO> manager = dao.manager(vo);
		return manager;
	}

	public String imManager(MemberVO vo) {
		String yN = dao.imManager(vo);
		return yN;
	}

	public int memberManager(MemberVO mvo) {
		int memberManager = dao.memberManager(mvo);
		return memberManager;
		
	}

	public int memberDelete(MemberVO vo) {
		int md = dao.memberDelete(vo);
		return md;
		
	}

	public int applyDelete(MemberVO vo) {
		int ad = dao.applyDelete(vo);
		return ad;
	}

	public int ccDelete(int c_id) {
		int data = dao.ccDelete(c_id);
		return data;
	}

	
}
