package com.web.home.club.metting.model;

public class MettingDTO {
	int MT_ID;
	String MT_NAME;
	String MT_DS;
	String MT_AD;
	int MT_PRICE;
	String MT_SDATE;
	String MT_FDATE;
	String MT_PHOTO;
	int C_ID;
	int MT_P;
	int m_id;
	int a_people;
	
	public MettingDTO() {
		
	};
	
	public MettingDTO(MettingVO vo) {
		
		this.MT_NAME = vo.getMt_name();
		this.MT_DS = vo.getMt_discription();
		this.MT_AD = vo.getAddress1() +" "+ vo.getAddress2();
		this.MT_PRICE = vo.getMt_price();
		if(vo.getS_time().isEmpty()) {
			this.setMT_SDATE(vo.getS_date() + " 00:00");
			this.setMT_FDATE(vo.getF_date() + " 00:00");
		} else {
			this.MT_SDATE = vo.getS_date() + " "+ vo.getS_time();
			this.MT_FDATE = vo.getF_date() + " "+ vo.getF_time();
		}
		this.C_ID = vo.getC_id();
		this.MT_P = vo.getMt_people();
		
	}

	public MettingDTO(int m_id, int mt_id) {
		this.MT_ID = mt_id;
		this.m_id=m_id;
	}
	
	public MettingDTO(int m_id, String mt_id) {
		this.MT_ID = m_id;
		this.MT_NAME=mt_id;
	}
	
	public String cutMT_NAME() {
		return "\""+this.MT_NAME+"\"";
	}

	public String cutSdate() {
		String[] array = this.getMT_SDATE().split(" ");
		System.out.println(array[0]);
		return "\""+array[0]+"\"";
	}
	
	public String cutFdate() {
		String[] array = this.getMT_FDATE().split(" ");
		System.out.println(array[0]);
		return "\""+array[0]+"\"";
	}
	
	public String calcSdate() {
		String[] array = this.getMT_SDATE().split(" ");
		if(array[1].contains("00:00:00")){
			return array[0];
		}
		return this.MT_SDATE;
	}
	
	public String calcFdate() {
		String[] array = this.getMT_FDATE().split(" ");
		if(array[1].contains("00:00:00")){
			return array[0];
		}
		return this.MT_FDATE;
	}
	
	public int getA_people() {
		return a_people;
	}

	public void setA_people(int a_people) {
		this.a_people = a_people;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getMT_ID() {
		return MT_ID;
	}

	public void setMT_ID(int mT_ID) {
		MT_ID = mT_ID;
	}

	public String getMT_NAME() {
		return MT_NAME;
	}

	public void setMT_NAME(String mT_NAME) {
		MT_NAME = mT_NAME;
	}

	public String getMT_DS() {
		return MT_DS;
	}

	public void setMT_DS(String mT_DS) {
		MT_DS = mT_DS;
	}

	public String getMT_AD() {
		return MT_AD;
	}

	public void setMT_AD(String mT_AD) {
		MT_AD = mT_AD;
	}

	public int getMT_PRICE() {
		return MT_PRICE;
	}

	public void setMT_PRICE(int mT_PRICE) {
		MT_PRICE = mT_PRICE;
	}

	public String getMT_SDATE() {
		return MT_SDATE;
	}

	public void setMT_SDATE(String mT_SDATE) {
		MT_SDATE = mT_SDATE;
	}

	public String getMT_FDATE() {
		return MT_FDATE;
	}

	public void setMT_FDATE(String mT_FDATE) {
		MT_FDATE = mT_FDATE;
	}

	public String getMT_PHOTO() {
		return MT_PHOTO;
	}

	public void setMT_PHOTO(String mT_PHOTO) {
		MT_PHOTO = mT_PHOTO;
	}

	public int getC_ID() {
		return C_ID;
	}

	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}

	public int getMT_P() {
		return MT_P;
	}

	public void setMT_P(int mT_P) {
		MT_P = mT_P;
	}

	@Override
	public String toString() {
		return "MettingDTO [MT_ID=" + MT_ID + ", MT_NAME=" + MT_NAME + ", MT_DS=" + MT_DS + ", MT_AD=" + MT_AD
				+ ", MT_PRICE=" + MT_PRICE + ", MT_SDATE=" + MT_SDATE + ", MT_FDATE=" + MT_FDATE + ", MT_PHOTO="
				+ MT_PHOTO + ", C_ID=" + C_ID + ", MT_P=" + MT_P + "]";
	}
	
	
	
}
