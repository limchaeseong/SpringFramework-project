package com.web.home.my.model;

import java.sql.Date;

public class postVO {
	//ACCOUNT
	private int a_id;
	private String a_uid; // 아이디
	private String a_photo; // 프로필 사진
	// BOARD
	private int b_id;
	private String b_name; // 게시글 제목
	private String b_content; // 게시글 내용
	private Date b_date; // 작성일
	private int b_good; // 좋아요
	// CLUB
	private int c_id;
	private String c_name; // 모임명
	public int getA_id() {
		return a_id;
	}
	public String getA_uid() {
		return a_uid;
	}
	public String getA_photo() {
		return a_photo;
	}
	public int getB_id() {
		return b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public String getB_content() {
		return b_content;
	}
	public Date getB_date() {
		return b_date;
	}
	public int getB_good() {
		return b_good;
	}
	public int getC_id() {
		return c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public void setA_uid(String a_uid) {
		this.a_uid = a_uid;
	}
	public void setA_photo(String a_photo) {
		this.a_photo = a_photo;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public void setB_good(int b_good) {
		this.b_good = b_good;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	@Override
	public String toString() {
		return "postVO [a_id=" + a_id + ", a_uid=" + a_uid + ", a_photo=" + a_photo + ", b_id=" + b_id + ", b_name="
				+ b_name + ", b_content=" + b_content + ", b_date=" + b_date + ", b_good=" + b_good + ", c_id=" + c_id
				+ ", c_name=" + c_name + "]";
	}

}