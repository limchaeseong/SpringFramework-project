package com.web.home.join.model;

public class JoinVO {
	private String userid;
	private String password;
	private String username;
	private String birth;
	private char gender;
	private String address_1;
	private String address_2;
	private String email;
	private String phone_num;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	@Override
	public String toString() {
		return "JoinVO [userid=" + userid + ", password=" + password + ", username=" + username + ", birth=" + birth
				+ ", gender=" + gender + ", address_1=" + address_1 + ", address_2=" + address_2 + ", email=" + email
				+ ", phone_num=" + phone_num + "]";
	}
}
