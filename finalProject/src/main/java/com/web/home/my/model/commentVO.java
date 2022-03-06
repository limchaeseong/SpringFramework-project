package com.web.home.my.model;

import java.sql.Date;

public class commentVO {
	// CM : COMMENT
	private int cm_id;
	private String cm_content; //댓글 내용
	private Date cm_date; // 댓글 작성일
	// BOARD
	private String b_id;
	private String b_name; //게시글 제목
	private String b_content; //게시글 내용
	private Date b_date; //게시글 작성일
	//CLUB
	private String c_photo; //모임사진
	private String c_name; //모임명
	//ACCOUNT
	private String a_uid; //아이디
	public int getCm_id() {
		return cm_id;
	}
	public String getCm_content() {
		return cm_content;
	}
	public Date getCm_date() {
		return cm_date;
	}
	public String getB_id() {
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
	public String getC_photo() {
		return c_photo;
	}
	public String getC_name() {
		return c_name;
	}
	public String getA_uid() {
		return a_uid;
	}
	public void setCm_id(int cm_id) {
		this.cm_id = cm_id;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public void setCm_date(Date cm_date) {
		this.cm_date = cm_date;
	}
	public void setB_id(String b_id) {
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
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setA_uid(String a_uid) {
		this.a_uid = a_uid;
	}
	@Override
	public String toString() {
		return "commentVO [cm_id=" + cm_id + ", cm_content=" + cm_content + ", cm_date=" + cm_date + ", b_id=" + b_id
				+ ", b_name=" + b_name + ", b_content=" + b_content + ", b_date=" + b_date + ", c_photo=" + c_photo
				+ ", c_name=" + c_name + ", a_uid=" + a_uid + "]";
	}

}