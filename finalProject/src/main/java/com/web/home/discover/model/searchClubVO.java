package com.web.home.discover.model;

import java.sql.Date;

public class searchClubVO {
	// club
	private String c_id;
	private String c_name; // 모임 이름
	private String c_photo; // 모임 사진
	private Date c_sdate; // 모임 생성일
	private char c_open; // 모임 공개여부
	private String c_discription; // 모임 설명
	//member
	private char p_chief; // 모임 권한
	private int m_a_id; // 멤버 No.
	//account
	private int a_id; // 유저 No.
	private String a_uid; // 유저 아이디
	public String getC_id() {
		return c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public String getC_photo() {
		return c_photo;
	}
	public Date getC_sdate() {
		return c_sdate;
	}
	public char getC_open() {
		return c_open;
	}
	public String getC_discription() {
		return c_discription;
	}
	public char getP_chief() {
		return p_chief;
	}
	public int getM_a_id() {
		return m_a_id;
	}
	public int getA_id() {
		return a_id;
	}
	public String getA_uid() {
		return a_uid;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public void setC_sdate(Date c_sdate) {
		this.c_sdate = c_sdate;
	}
	public void setC_open(char c_open) {
		this.c_open = c_open;
	}
	public void setC_discription(String c_discription) {
		this.c_discription = c_discription;
	}
	public void setP_chief(char p_chief) {
		this.p_chief = p_chief;
	}
	public void setM_a_id(int m_a_id) {
		this.m_a_id = m_a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public void setA_uid(String a_uid) {
		this.a_uid = a_uid;
	}
	@Override
	public String toString() {
		return "searchClubVO [c_id=" + c_id + ", c_name=" + c_name + ", c_photo=" + c_photo + ", c_sdate=" + c_sdate
				+ ", c_open=" + c_open + ", c_discription=" + c_discription + ", p_chief=" + p_chief + ", m_a_id="
				+ m_a_id + ", a_id=" + a_id + ", a_uid=" + a_uid + "]";
	}
	
}