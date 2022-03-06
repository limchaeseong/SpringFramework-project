package com.web.home.commentview.model;

import java.sql.Date;

public class CommentWriteVO {
	
	private int cm_id;			// 번호
	private String cm_content;	// 댓글 내용
	private Date cm_date;		// 댓글 작성일
	private int b_id;			// 게시판 번호
	private int m_id;			// 멤버 번호
	
	public int getCm_id() {
		return cm_id;
	}
	public void setCm_id(int cm_id) {
		this.cm_id = cm_id;
	}
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public Date getCm_date() {
		return cm_date;
	}
	public void setCm_date(Date cm_date) {
		this.cm_date = cm_date;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	@Override
	public String toString() {
		return "CommentWriteVO [cm_id=" + cm_id + ", cm_content=" + cm_content + ", cm_date=" + cm_date + ", b_id="
				+ b_id + ", m_id=" + m_id + "]";
	}
}
