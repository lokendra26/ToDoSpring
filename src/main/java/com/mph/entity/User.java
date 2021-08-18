package com.mph.entity;

public class User {

	private String emailId;
	private String userName;
	private String password;
	private int phoneNumber;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String emailId, String userName, String password, int phoneNumber) {
		super();
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	

}
