package com.web.home.discover.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class discoverDAO {
	
	@Autowired
	private SqlSession sess;

	public List<searchClubVO> searchClub(String keyword) {
		List<searchClubVO> searchClub = sess.selectList("discoverMapper.searchClub", keyword);
		return searchClub;
	}

	public List<postBoardVO> searchBoard(String keyword) {
		List<postBoardVO> postBoard = sess.selectList("discoverMapper.searchPost", keyword);
		return postBoard;
	}

}
