package com.web.home.join.model;

import java.sql.Date;

public class JoinDTO {

	private int a_id;			// 번호
	private String a_uid;		// 아이디
	private String a_pw;		// 비밀번호
	private String a_name;		// 이름
	private String a_bdate;		// 생년월일
	private Date a_jdate;		// 가입일
	private String a_email;		// 이메일
	private String a_ad;		// 주소
	private String a_phone;		// 핸드폰번호
	private char a_gender;		// 성별
	
	public JoinDTO() {};
	
	public JoinDTO(String a_uid) {
		this.a_uid = a_uid;
	}
	
	public JoinDTO(String a_uid, String a_pw, String a_name, String a_bdate, String a_email, String a_phone,
			char a_gender) {
		this.a_uid = a_uid;		this.a_pw = a_pw;		this.a_name = a_name;
		this.a_bdate = a_bdate;	this.a_email = a_email;	this.a_phone = a_phone;
		this.a_gender = a_gender;
	}
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_uid() {
		return a_uid;
	}
	public void setA_uid(String a_uid) {
		this.a_uid = a_uid;
	}
	public String getA_pw() {
		return a_pw;
	}
	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_bdate() {
		return a_bdate;
	}
	public void setA_bdate(String a_bdate) {
		this.a_bdate = a_bdate;
	}
	public Date getA_jdate() {
		return a_jdate;
	}
	public void setA_jdate(Date a_jdate) {
		this.a_jdate = a_jdate;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_ad() {
		return a_ad;
	}
	public void setA_ad(String a_ad) {
		this.a_ad = a_ad;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public char getA_gender() {
		return a_gender;
	}
	public void setA_gender(char a_gender) {
		this.a_gender = a_gender;
	}
	
	@Override
	public String toString() {
		return "JoinDTO [a_id=" + a_id + ", a_uid=" + a_uid + ", a_pw=" + a_pw + ", a_name=" + a_name + ", a_bdate="
				+ a_bdate + ", a_jdate=" + a_jdate + ", a_email=" + a_email + ", a_ad=" + a_ad + ", a_phone=" + a_phone
				+ ", a_gender=" + a_gender + "]";
	}
	
}
