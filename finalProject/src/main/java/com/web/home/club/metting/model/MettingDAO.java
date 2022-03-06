package com.web.home.club.metting.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MettingDAO {

	@Autowired
	private SqlSession sess;
	
	public int insertMetting(MettingDTO dto) {
		int res = this.sess.insert("MettingMapper.insertMetting",dto);
		if(res != 1) {
			return -1;
		}
		return 1;
	}

	public List<MettingDTO> selectMetting(int c_id){
		return this.sess.selectList("MettingMapper.selectMetting",c_id); 
	}
	
	public List<MettingDTO> MettingAllList(){
		return this.sess.selectList("MettingMapper.selectMettingAll2");
	}
	
	public int applyMetting(MettingDTO dto) {
		int res = this.sess.insert("MettingMapper.applyMetting",dto);
		return res;
	}
	
	public int removeMT(MettingDTO dto) {
		int res = this.sess.delete("MettingMapper.removeMetting",dto);
		return res;
	}

	public List<MettingDTO> applyMember(int mt_ID) {
		return this.sess.selectList("MettingMapper.applyMember",mt_ID);
	}

	public int applyMM_master(int a_id,int c_id) {
		System.out.println("a_id:"+a_id+"c_id:"+c_id);
		MettingDTO dto = new MettingDTO(a_id,c_id);
		int m_id = this.sess.selectOne("MettingMapper.GetM_id",dto);
		int mt_id = this.sess.selectOne("MettingMapper.GetMt_id");
		System.out.println("멤버ID : "+m_id+" 일정ID : "+mt_id);
		dto.setC_ID(m_id);
		dto.setMT_ID(mt_id);
		System.out.println(dto);
		int res = this.sess.insert("MettingMapper.applyMettingM",dto);
		return res;
	}

	public List<MettingApplyVo> applyCheck(int a_id, String m_no) {
		System.out.println("a_id:"+a_id+"mt_no:"+m_no);
		MettingDTO dto = new MettingDTO(a_id,m_no);
		List<MettingApplyVo> datas= this.sess.selectList("MettingMapper.checkMeeting",dto);
		System.out.println(datas.size());
		return datas;
	}

	public MettingDTO Metting(int mt_no) {
		return this.sess.selectOne("MettingMapper.Meeting",mt_no);
	}

	public int applyMetting2(int a_id, int mt_id) {
		MettingDTO dto = confirm(a_id,mt_id);	
		int res = this.sess.insert("MettingMapper.applyMetting",dto);
		System.out.println("입력된 일정 : "+res);
		return res;
	}

	public int cancleMetting(int a_id, int mt_id) {
		MettingDTO dto = confirm(a_id,mt_id);
		int res = this.sess.delete("MettingMapper.cancleMetting",dto);
		return res;
	}
	
	public MettingDTO confirm(int a_id,int mt_id) {
		System.out.println("a_id:"+a_id+"mt_no:"+mt_id);
		MettingDTO dto = new MettingDTO(a_id,mt_id);
		int m_id = this.sess.selectOne("MettingMapper.GetM_idByMt_id",dto);
		dto.setM_id(m_id);
		System.out.println("m_id : "+dto.getM_id()+" mt_id : "+dto.getMT_ID());
		return dto;
	}
}
