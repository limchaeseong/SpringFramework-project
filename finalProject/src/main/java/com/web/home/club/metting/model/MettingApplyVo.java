package com.web.home.club.metting.model;

public class MettingApplyVo {
	int MM_ID;
	int M_ID;
	int MT_ID;
	String MM_MASTER;
	public int getMM_ID() {
		return MM_ID;
	}
	public void setMM_ID(int mM_ID) {
		MM_ID = mM_ID;
	}
	public int getM_ID() {
		return M_ID;
	}
	public void setM_ID(int m_ID) {
		M_ID = m_ID;
	}
	public int getMT_ID() {
		return MT_ID;
	}
	public void setMT_ID(int mT_ID) {
		MT_ID = mT_ID;
	}
	
	public String getMM_MASTER() {
		return MM_MASTER;
	}
	public void setMM_MASTER(String mM_MASTER) {
		MM_MASTER = mM_MASTER;
	}
	@Override
	public String toString() {
		return "MettingApplyVo [MM_ID=" + MM_ID + ", M_ID=" + M_ID + ", MT_ID=" + MT_ID + ", MM_MASTER=" + MM_MASTER
				+ "]";
	}
	
	
}
