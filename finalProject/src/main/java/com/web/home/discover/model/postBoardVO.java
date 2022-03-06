package com.web.home.discover.model;

import java.sql.Date;

public class postBoardVO {

	// board table
	private int b_id;
	private String b_name; // 게시글 제목
	private String b_content; // 게시글 내용
	private char b_photo; // 게시글 사진 포함 여부
	private Date b_date; // 게시글 작성일
	private int b_good; // 게시글 좋아요 수

	//culb table
	private int c_id;
	private String c_name;
	private String c_photo;
	public int getB_id() {
		return b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public String getB_content() {
		return b_content;
	}
	public char getB_photo() {
		return b_photo;
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
	public String getC_photo() {
		return c_photo;
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
	public void setB_photo(char b_photo) {
		this.b_photo = b_photo;
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
	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	@Override
	public String toString() {
		return "postBoardVO [b_id=" + b_id + ", b_name=" + b_name + ", b_content=" + b_content + ", b_photo=" + b_photo
				+ ", b_date=" + b_date + ", b_good=" + b_good + ", c_id=" + c_id + ", c_name=" + c_name + ", c_photo="
				+ c_photo + "]";
	}
	
}