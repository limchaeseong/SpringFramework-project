package com.web.home.commentview.model;

public class PostPhotoVO {
	private int p_id;
	private String p_name;
	private int b_id;
	private int c_id;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	@Override
	public String toString() {
		return "PostPhotoVO [p_id=" + p_id + ", p_name=" + p_name + ", b_id=" + b_id + ", c_id=" + c_id + "]";
	}
	
}
