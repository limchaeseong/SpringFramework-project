																																	package com.web.home.club.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClubDAO {
	
	@Autowired
	private SqlSession sess;
	
	public int insertClub(ClubVO vo) {
		int sq = this.sess.insert("CreateMapper.insertClub", vo);
		if(sq != -1) {
			return sq;	
		}
		return -1;
	}
	
	public ClubVO selectClub(int sq) {
		ClubVO data = this.sess.selectOne("CreateMapper.selectClub", sq);
		return data;
	}
	
	public List<ClubVO> clubList() {
		List<ClubVO> datas = this.sess.selectList("CreateMapper.clubList");
		return datas;
	}
	
	public ClubVO viewClub(int c_id) {
		ClubVO cvo = this.sess.selectOne("CreateMapper.viewClub", c_id);
		return cvo;
	}

	public CategoryVO selectCgName(int c_id) {
		CategoryVO cgName = this.sess.selectOne("ApplyMapper.selectCgName", c_id);
		return cgName;
	}

	public int updateDiscription(ClubVO vo) {
		int discription = this.sess.update("CreateMapper.updateDiscription", vo);
		if(discription != -1) {
			return discription;	
		}
		return -1;
	}

	public List<ClubVO> clubList(int a_id) {
		List<ClubVO> datas = this.sess.selectList("CreateMapper.clubListBya_id",a_id);
		return datas;
	}	
}
