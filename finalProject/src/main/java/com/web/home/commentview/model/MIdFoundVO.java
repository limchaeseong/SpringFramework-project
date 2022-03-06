package com.web.home.commentview.model;

public class MIdFoundVO {
	private int a_id;
	private int c_id;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	@Override
	public String toString() {
		return "MIdFoundVO [a_id=" + a_id + ", c_id=" + c_id + "]";
	}

}
