package com.web.home.account.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class AccountDTO {
	private int a_id;
	private String a_uid;
	private String a_pw;
	private String a_name;
	private String a_bdate;
	private Date a_jdate;
	private String a_email;
	private String a_ad; //주소
	private int a_phone;
	private String a_photo;
	private char a_gender;
	private String a_kakao;
	private String a_google;

	public AccountDTO() {}
	
//	public AccountDTO(String a_uid, String a_pw) {
//		this.a_uid = a_uid;
//		this.a_pw = a_pw;
//	}
	
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
	public int getA_phone() {
		return a_phone;
	}
	public void setA_phone(int a_phone) {
		this.a_phone = a_phone;
	}
	public String getA_photo() {
		return a_photo;
	}
	public void setA_photo(String a_photo) {
		this.a_photo = a_photo;
	}
	public char getA_gender() {
		return a_gender;
	}
	public void setA_gender(char a_gender) {
		this.a_gender = a_gender;
	}
	public String getA_kakao() {
		return a_kakao;
	}
	public void setA_kakao(String a_kakao) {
		this.a_kakao = a_kakao;
	}
	public String getA_google() {
		return a_google;
	}
	public void setA_google(String a_google) {
		this.a_google = a_google;
	}
	@Override
	public String toString() {
		return "AccountDTO [a_id=" + a_id + ", a_uid=" + a_uid + ", a_pw=" + a_pw + ", a_name=" + a_name + ", a_bdate="
				+ a_bdate + ", a_jdate=" + a_jdate + ", a_email=" + a_email + ", a_ad=" + a_ad + ", a_phone=" + a_phone
				+ ", a_photo=" + a_photo + ", a_gender=" + a_gender + ", a_kakao=" + a_kakao + ", a_google=" + a_google
				+ "]";
	}
	
}
