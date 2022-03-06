package com.web.home.club.model;

public class ApplyVO {
	private int ap_id;
	private char ap_state;
	private int c_id;
	private int a_id;
	
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public char getAp_state() {
		return ap_state;
	}
	public void setAp_state(char ap_state) {
		this.ap_state = ap_state;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	@Override
	public String toString() {
		return "ApplyVO [ap_id=" + ap_id + ", ap_state=" + ap_state + ", c_id=" + c_id + ", a_id=" + a_id + "]";
	}	
}
