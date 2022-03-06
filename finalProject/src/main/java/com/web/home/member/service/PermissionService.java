package com.web.home.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.home.member.model.PermissionDAO;
import com.web.home.member.model.PermissionDTO;
@Service
public class PermissionService {
	@Autowired
	PermissionDAO dao;
	
	public boolean existedPerm(PermissionDTO dto, String crud) {
		dto = this.getPermission(dto); //AOP에서 dto 파라메터로 가져와서 this.getPermission으로 넘기고 mybatis selectOne한 결과를 dto에 재할당
		
		switch(crud){
		case "select" :
			if(dto.getSelectPerm() == 'Y') {//가져온 객체로 Y / N 판단 가능
				return true;
			}		
		case "insert" :
			if(dto.getInsertPerm() == 'Y') { 
				return true;
			}
		case "update" :
			if(dto.getUpdatePerm() == 'Y') {
				return true;
			}
		case "delete" :  
			if(dto.getDeletePerm() == 'Y') {
				return true;
			}
		}
		return false;
	}

	private PermissionDTO getPermission(PermissionDTO dto) {
		return dao.selectPerm(dto);
	}

}
