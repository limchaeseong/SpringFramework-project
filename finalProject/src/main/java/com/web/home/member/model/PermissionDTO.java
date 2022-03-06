package com.web.home.member.model;

public class PermissionDTO {
	int id;
	int aid;
	String TName;
	char selectPerm;
	char insertPerm;
	char updatePerm;
	char deletePerm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getTName() {
		return TName;
	}
	public void setTName(String tName) {
		TName = tName;
	}
	public char getSelectPerm() {
		return selectPerm;
	}
	public void setSelectPerm(char selectPerm) {
		this.selectPerm = selectPerm;
	}
	public char getInsertPerm() {
		return insertPerm;
	}
	public void setInsertPerm(char insertPerm) {
		this.insertPerm = insertPerm;
	}
	public char getUpdatePerm() {
		return updatePerm;
	}
	public void setUpdatePerm(char updatePerm) {
		this.updatePerm = updatePerm;
	}
	public char getDeletePerm() {
		return deletePerm;
	}
	public void setDeletePerm(char deletePerm) {
		this.deletePerm = deletePerm;
	}
	@Override
	public String toString() {
		return "PermissionDTO [id=" + id + ", aid=" + aid + ", TName=" + TName + ", selectPerm=" + selectPerm
				+ ", insertPerm=" + insertPerm + ", updatePerm=" + updatePerm + ", deletePerm=" + deletePerm + "]";
	}
	
	
}
