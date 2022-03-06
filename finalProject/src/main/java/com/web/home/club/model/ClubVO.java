package com.web.home.club.model;

import java.sql.Date;

public class ClubVO {
	private int c_id;
	private String c_name;
	private Date c_sDate;
	private String c_photo;
	private char c_open;
	private int cg_id;
	private int c_chat;
	private int sq;
	private String c_discription;
	
	public String getC_discription() {
		return c_discription;
	}
	public void setC_discription(String c_discription) {
		this.c_discription = c_discription;
	}
	public int getSq() {
		return sq;
	}
	public void setSq(int sq) {
		this.sq = sq;
	}
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Date getC_sDate() {
		return c_sDate;
	}
	public void setC_sDate(Date c_sDate) {
		this.c_sDate = c_sDate;
	}
	public String getC_photo() {
		return c_photo;
	}
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public char getC_open() {
		return c_open;
	}
	public void setC_open(char c_open) {
		this.c_open = c_open;
	}
	public int getCg_id() {
		return cg_id;
	}
	public void setCg_id(int cg_id) {
		this.cg_id = cg_id;
	}
	public int getC_chat() {
		return c_chat;
	}
	public void setC_chat(int c_chat) {
		this.c_chat = c_chat;
	}
	
	@Override
	public String toString() {
		return "ClubVO [c_id=" + c_id + ", c_name=" + c_name + ", c_sDate=" + c_sDate + ", c_photo=" + c_photo
				+ ", c_open=" + c_open + ", cg_id=" + cg_id + ", c_chat=" + c_chat + ", sq=" + sq + ", c_discription="
				+ c_discription + "]";
	}
}
