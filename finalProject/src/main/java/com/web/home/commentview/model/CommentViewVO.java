package com.web.home.commentview.model;

public class CommentViewVO {

	private String a_photo;		// 프로필 사진
	private String a_name;		// 이름
	private String cm_content;	// 댓글 내용
	private String cm_date;		// 댓글 작성일
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
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public String getCm_date() {
		return cm_date;
	}
	public void setCm_date(String cm_date) {
		this.cm_date = cm_date;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	
	@Override
	public String toString() {
		return "CommentViewVO [a_photo=" + a_photo + ", a_name=" + a_name + ", cm_content=" + cm_content + ", cm_date="
				+ cm_date + ", b_id=" + b_id + "]";
	}
}
