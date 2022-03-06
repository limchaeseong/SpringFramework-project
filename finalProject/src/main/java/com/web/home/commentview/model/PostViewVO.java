package com.web.home.commentview.model;

public class PostViewVO {

	private String a_photo;		// 프로필 사진
	private String a_name;		// 이름
	private String b_date;		// 게시글 작성일
	private String b_content;	// 게시글 내용
	private int b_good;			// 좋아요 수
	private int b_people;		// 조회수 (방문자수)
	private int b_id;			// 게시글 번호(댓글 작성 시 필요)
	
	public String getA_photo() {
		return a_photo;
	}
	public void setA_photo(String a_photo) {
		this.a_photo = a_photo;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_good() {
		return b_good;
	}
	public void setB_good(int b_good) {
		this.b_good = b_good;
	}
	public int getB_people() {
		return b_people;
	}
	public void setB_people(int b_people) {
		this.b_people = b_people;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	
	@Override
	public String toString() {
		return "PostViewVO [a_photo=" + a_photo + ", a_name=" + a_name + ", b_date=" + b_date + ", b_content="
				+ b_content + ", b_good=" + b_good + ", b_people=" + b_people + ", b_id=" + b_id + "]";
	}
}
