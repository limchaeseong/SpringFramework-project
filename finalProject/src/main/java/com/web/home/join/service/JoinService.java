package com.web.home.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.home.join.model.JoinDAO;
import com.web.home.join.model.JoinDTO;
import com.web.home.join.model.JoinVO;

@Service
public class JoinService {

	@Autowired
	private JoinDAO dao;
	
	@Transactional(rollbackFor=Exception.class)
	public boolean insertJoin(JoinVO vo) {
		
		JoinDTO dto = new JoinDTO(vo.getUserid(), vo.getPassword(), vo.getUsername(), vo.getBirth()
								, vo.getEmail(), vo.getPhone_num(), vo.getGender());
		dto.setA_ad(vo.getAddress_1() + " " + vo.getAddress_2());
		
		
		int result = dao.insertJoin(dto);
		
		System.out.println("service -> " + result);
		
		if(result == 1) {
			return true;
		} else {
			throw new TransientDataAccessResourceException("회원가입 데이터 처리 과정중 문제 발생");	// 에러를 새로 만들어서 던짐
		}
	}

	// 회원 아이디 조회
	public int selectIdCheck(String id) {
		JoinDTO dto = new JoinDTO(id);
		
		System.out.println("service -> " + dto);
		int result = dao.selectIdCheck(dto);
		System.out.println("service -> " + result);
		
		return result;
	}
}
