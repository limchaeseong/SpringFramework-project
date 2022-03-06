package com.web.home.club.metting.model;

public class MettingVO {
	String mt_name;
	String mt_discription;
	String s_date;
	String s_time;
	String f_date;
	String f_time;
	String address1;
	String address2;
	int mt_price;
	int mt_people;
	int c_id;
	public String getMt_name() {
		return mt_name;
	}
	public void setMt_name(String mt_name) {
		this.mt_name = mt_name;
	}
	public String getMt_discription() {
		return mt_discription;
	}
	public void setMt_discription(String mt_discription) {
		this.mt_discription = mt_discription;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getF_date() {
		return f_date;
	}
	public void setF_date(String f_date) {
		this.f_date = f_date;
	}
	public String getF_time() {
		return f_time;
	}
	public void setF_time(String f_time) {
		this.f_time = f_time;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getMt_price() {
		return mt_price;
	}
	public void setMt_price(int mt_price) {
		this.mt_price = mt_price;
	}
	public int getMt_people() {
		return mt_people;
	}
	public void setMt_people(int mt_people) {
		this.mt_people = mt_people;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "MettingVO [mt_name=" + mt_name + ", mt_discription=" + mt_discription + ", s_date=" + s_date
				+ ", s_time=" + s_time + ", f_date=" + f_date + ", f_time=" + f_time + ", address1=" + address1
				+ ", address2=" + address2 + ", mt_price=" + mt_price + ", mt_people=" + mt_people + ", c_id=" + c_id
				+ "]";
	}
	
	
	
	
	
}
