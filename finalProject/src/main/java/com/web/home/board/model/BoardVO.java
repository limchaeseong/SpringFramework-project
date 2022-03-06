package com.web.home.board.model;

import java.util.Date;

public class BoardVO {
	private int b_id;
	private String b_name;
	private String b_content;
	private String b_photo;
	private Date b_date;
	private String b_good;
	private int b_people;
	private int c_id;
	private int m_id;
	private int seq;
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_photo() {
		return b_photo;
	}
	public void setB_photo(String b_photo) {
		this.b_photo = b_photo;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public String getB_good() {
		return b_good;
	}
	public void setB_good(String b_good) {
		this.b_good = b_good;
	}
	public int getB_people() {
		return b_people;
	}
	public void setB_people(int b_people) {
		this.b_people = b_people;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "BoardVO [b_id=" + b_id + ", b_name=" + b_name + ", b_content=" + b_content + ", b_photo=" + b_photo
				+ ", b_date=" + b_date + ", b_good=" + b_good + ", b_people=" + b_people + ", c_id=" + c_id + ", m_id="
				+ m_id + "]";
	}
	

}
