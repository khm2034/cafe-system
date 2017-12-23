package com.spring.Model;

import java.sql.Date;

public class ManagerVO {
	
	private int managerNum;
	private String managerId;
	private String managerPw;
	private String managerName;
	private String managerEmail;
	private String managerPhone;
	private Date managerBirth;
	private String managerGender;
	private Date managerRegDate;
	
	
	public int getManagerNum() {
		return managerNum;
	}


	public void setManagerNum(int managerNum) {
		this.managerNum = managerNum;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	public String getManagerPw() {
		return managerPw;
	}


	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getManagerEmail() {
		return managerEmail;
	}


	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}


	public String getManagerPhone() {
		return managerPhone;
	}


	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}


	public Date getManagerBirth() {
		return managerBirth;
	}


	public void setManagerBirth(Date managerBirth) {
		this.managerBirth = managerBirth;
	}


	public String getManagerGender() {
		return managerGender;
	}


	public void setManagerGender(String managerGender) {
		this.managerGender = managerGender;
	}


	public Date getManagerRegDate() {
		return managerRegDate;
	}


	public void setManagerRegDate(Date managerRegDate) {
		this.managerRegDate = managerRegDate;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberVO [userId=" + managerId + ", userPw= " + managerPw + ", userName= " + managerName 
				+ ", userEmail= " + managerEmail + ", userPhone= " + managerPhone +  ", userBirth= "
		+ managerBirth + ", userGender= " + managerGender + ", userRegDate= " + managerRegDate + "]";
	}
}
