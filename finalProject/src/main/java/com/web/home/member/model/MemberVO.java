package com.web.home.member.model;

public class MemberVO {
	private int m_id;
	private char p_chief;
	private char p_cntl;
	private char p_write;
	private char p_join;
	private int j_num;
	private int a_id;
	private int c_id;
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public char getP_chief() {
		return p_chief;
	}
	public void setP_chief(char p_chief) {
		this.p_chief = p_chief;
	}
	public char getP_cntl() {
		return p_cntl;
	}
	public void setP_cntl(char p_cntl) {
		this.p_cntl = p_cntl;
	}
	public char getP_write() {
		return p_write;
	}
	public void setP_write(char p_write) {
		this.p_write = p_write;
	}
	public char getP_join() {
		return p_join;
	}
	public void setP_join(char p_join) {
		this.p_join = p_join;
	}
	public int getJ_num() {
		return j_num;
	}
	public void setJ_num(int j_num) {
		this.j_num = j_num;
	}
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
		return "MemberVO [m_id=" + m_id + ", p_chief=" + p_chief + ", p_cntl=" + p_cntl + ", p_write=" + p_write
				+ ", p_join=" + p_join + ", j_num=" + j_num + ", a_id=" + a_id + ", c_id=" + c_id + "]";
	}
}
