package com.web.home.club.metting.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MettingService {
	
	@Autowired
	private MettingDAO dao;
	
	public int create(MettingDTO dto) {
		int res = dao.insertMetting(dto);
		return res;
	}
	
	public List<MettingDTO> MettingList(int c_id){
		return dao.selectMetting(c_id);
	}
	
	public List<MettingDTO> MettingAllList(){
		return dao.MettingAllList();   
	}
	
	public int applyMetting(int m_id,int mt_id) {
		MettingDTO dto = new MettingDTO(m_id,mt_id);
		return dao.applyMetting(dto);
	}
	
	public int applyMetting2(int a_id,int mt_id) {
		return dao.applyMetting2(a_id,mt_id);
	}
	
	public int applyMM_master(int a_id,int c_id) {
		return dao.applyMM_master(a_id,c_id);
	}

	public int applyMember(int mt_ID) {
		List<MettingDTO> datas = dao.applyMember(mt_ID);
		return datas.size();
	}

	public List<MettingApplyVo> applyCheck(int a_id, String m_no) {	
		return dao.applyCheck(a_id,m_no);
	}
	
	public MettingDTO Metting(int mt_no) {
		return dao.Metting(mt_no);
	}

	public int cancleMetting2(int a_id, int mt_id) {
		return dao.cancleMetting(a_id,mt_id);
	}
	
}
