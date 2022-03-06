package com.web.home.club.model;

public class CategoryVO {
	private int cg_id;
	private String cg_name;
	
	public int getCg_id() {
		return cg_id;
	}
	public void setCg_id(int cg_id) {
		this.cg_id = cg_id;
	}
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	@Override
	public String toString() {
		return "CategoryVO [cg_id=" + cg_id + ", cg_name=" + cg_name + "]";
	}
	
	
}
