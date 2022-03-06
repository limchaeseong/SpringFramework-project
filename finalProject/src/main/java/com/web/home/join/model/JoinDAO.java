package com.web.home.join.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAO {

	@Autowired
	private SqlSession sess;
	
	public int insertJoin(JoinDTO dto) {
		return this.sess.insert("JoinMapper.insertJoin", dto);
	}

	// 회원 아이디 조회
	public int selectIdCheck(JoinDTO dto) {
		int result = this.sess.selectOne("JoinMapper.selectJoin", dto);
		System.out.println("dao -> " + result);
		
		return result;
	}
}
