	package com.web.home.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.club.model.CategoryVO;
import com.web.home.club.model.ClubDAO;
import com.web.home.club.model.ClubVO;

@Service
public class ClubService {

	@Autowired
	private ClubDAO dao;

	public int create(ClubVO vo) {
		int sq = dao.insertClub(vo);
		return sq;
	}
	
	public ClubVO selectView(int sq) {
		ClubVO data = dao.selectClub(sq);
		return data;
	}
	
	public List<ClubVO> clubList() {
		List<ClubVO>datas = dao.clubList();
		return datas;
	}
	
	public ClubVO viewClub(int c_id) {
		ClubVO cvo = dao.viewClub(c_id);
		return cvo;
	}

	public CategoryVO selectCgName(int c_id) {
		CategoryVO cgName = dao.selectCgName(c_id);
		return cgName;
	}

	public int updateDiscription(ClubVO vo) {
		int discription = dao.updateDiscription(vo);
		System.out.println("discription" + discription);
		return discription;
	}

	public List<ClubVO> clubList(int a_id) {
		List<ClubVO>datas = dao.clubList(a_id);
		return datas;
	}
}
