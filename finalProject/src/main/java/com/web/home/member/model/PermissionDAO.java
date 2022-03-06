package com.web.home.member.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PermissionDAO {
	@Autowired
	SqlSession session;
	
	private String namespace = "PermissionMapper";
	//조회용 
	public PermissionDTO selectPerm(PermissionDTO dto) {
		String mapper = namespace + ".selectPerm";
		return this.session.selectOne(mapper, dto);
	}

}
