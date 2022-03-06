package com.web.home.main.model;

import java.sql.Date;

public class clubListVO {
	// account
	private int a_id;
	private String a_uid;
	// club
	private int c_id;
	private String c_name;
	private Date c_sdate;
	private String c_photo;
	// member
	private int m_id;
	public int getA_id() {
		return a_id;
	}
	public String getA_uid() {
		return a_uid;
	}
	public int getC_id() {
		return c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public Date getC_sdate() {
		return c_sdate;
	}
	public String getC_photo() {
		return c_photo;
	}
	public int getM_id() {
		return m_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public void setA_uid(String a_uid) {
		this.a_uid = a_uid;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setC_sdate(Date c_sdate) {
		this.c_sdate = c_sdate;
	}
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "clubListVO [a_id=" + a_id + ", a_uid=" + a_uid + ", c_id=" + c_id + ", c_name=" + c_name + ", c_sdate="
				+ c_sdate + ", c_photo=" + c_photo + ", m_id=" + m_id + "]";
	}
	
}
